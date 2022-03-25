package com.festu.auth.model;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BasicAuthenticationEntryPoint  implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.addHeader("Content-Type", "application/json");

        response.addHeader("Access-Control-Allow-Headers", "session");
        response.addHeader("Access-Control-Allow-Methods", "HEAD,GET,PUT,POST,DELETE,PATCH");
        response.addHeader("Access-Control-Allow-Origin", "*");

        response.getWriter().println("{\"message\":\"Invalid Credentials\"}");
    }

}
