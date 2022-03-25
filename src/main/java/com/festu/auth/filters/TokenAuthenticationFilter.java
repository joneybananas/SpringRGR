package com.festu.auth.filters;

import com.festu.auth.model.AuthToken;
import com.festu.auth.model.User;
import com.festu.auth.service.token.AuthTokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class TokenAuthenticationFilter implements Filter {

    private final AuthTokenService authTokenService;

//    @Value("${auth.token-name}")
    private String AUTH_TOKEN_NAME = "Authorization";

    public TokenAuthenticationFilter(AuthTokenService authTokenService) {
        this.authTokenService = authTokenService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;

        final String accessTokenHeader = httpRequest.getHeader(AUTH_TOKEN_NAME);

        if (accessTokenHeader != null) {
            final UUID accessToken = UUID.fromString(accessTokenHeader);
            AuthToken token = this.authTokenService.findById(accessToken);

            if (token != null) {
                if (this.authTokenService.isAuthTokenExpired(token)) {
                    this.authTokenService.remove(token);
                } else {
                    final User user = token.getUser();
                    final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    this.authTokenService.update(token);
                }
            }
            //TODO you can set to unauthorized if that is what you need.
        }

        chain.doFilter(request, response);
    }

}
