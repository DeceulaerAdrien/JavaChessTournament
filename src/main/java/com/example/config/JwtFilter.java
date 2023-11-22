package com.example.config;

import com.example.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtils utils;

    private final UserDetailsService userDetailsService;

    public JwtFilter(JwtUtils utils, UserDetailsService userDetailsService) {
        this.utils = utils;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain
    ) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        //Bearer fsdjnjkgnkjflsdqnhjgknbhdfqskjnhbgkljfdhsbnkljhbdl
        if (authorization != null) {
            String[] authorizations = authorization.split(" ");
            //[0] = Bearer  [1]ndsfklqngkljqsdhnkoqhfgokdsqhokjfhgsdiokuh(token)
            String type = authorizations[0];
            String token = authorizations[1];
            if (type.equals("Bearer") && !token.isEmpty()) {
                if (utils.isValid(token)) {
                    String username = utils.getUsername(token);
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            token,
                            userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(upat);
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}