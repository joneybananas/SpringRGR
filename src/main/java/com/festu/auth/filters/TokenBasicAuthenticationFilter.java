package com.festu.auth.filters;

import com.festu.auth.model.AuthToken;
import com.festu.auth.model.User;
import com.festu.auth.service.token.AuthTokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenBasicAuthenticationFilter extends BasicAuthenticationFilter {

    private final AuthTokenService authTokenService;

//    @Value("${auth.token-name}")
    private String AUTH_TOKEN_NAME = "Authorization";

    public TokenBasicAuthenticationFilter(AuthenticationManager authenticationManager, AuthTokenService authTokenService) {
        super(authenticationManager);
        this.authTokenService = authTokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        super.doFilterInternal(request, response, chain);
    }

    @Override
    protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult) {
        //Get user.
        final User user = (User) authResult.getPrincipal();

        //Remove previous tokens.
        this.authTokenService.removeByUser(user);

        //Generate new token.
        final AuthToken newToken = this.authTokenService.createToken(user);

        //Add token to session.
        request.getSession(true).setAttribute(AUTH_TOKEN_NAME, newToken.getId());
    }
}
