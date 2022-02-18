package com.immunization.common.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.immunization.common.security.TokenBasedAuthentication;
import com.immunization.common.service.UserDetailsServiceImpl;
import com.immunization.common.util.TokenUtils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private TokenUtils tokenUtils;

    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String username;
        String authToken = tokenUtils.getToken(request);

        if (authToken != null) {
            username = tokenUtils.getUsernameFromToken(authToken);

            if (username != null) {
                UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);

                if (userDetails != null && tokenUtils.validateToken(authToken, userDetails)) {
                    TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
                    authentication.setToken(authToken);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        chain.doFilter(request, response);
    }
}
