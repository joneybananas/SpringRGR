//package com.festu.auth.config;
//
//import com.festu.auth.filters.TokenAuthenticationFilter;
//import com.festu.auth.filters.TokenBasicAuthenticationFilter;
//import com.festu.auth.model.BasicAuthenticationEntryPoint;
//import com.festu.auth.service.token.AuthTokenService;
//import com.festu.auth.service.user.UserService;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    AuthTokenService authTokenService;
//
//    UserService userService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().disable()
//            .csrf().disable()
//            .userDetailsService(userService)
//            .httpBasic()
//            .authenticationEntryPoint(new BasicAuthenticationEntryPoint())
//            .and()
//            .sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        final TokenBasicAuthenticationFilter basicAuthenticationFilter = new TokenBasicAuthenticationFilter(this.authenticationManagerBean(), this.authTokenService);
//        final TokenAuthenticationFilter tokenFilter = new TokenAuthenticationFilter(this.authTokenService);
//
//        http.addFilter(basicAuthenticationFilter);
//        http.addFilterBefore(tokenFilter, BasicAuthenticationFilter.class);
//    }
//
//}
