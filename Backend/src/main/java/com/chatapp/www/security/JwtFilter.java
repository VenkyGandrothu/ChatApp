package com.chatapp.www.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter{

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException, java.io.IOException {

        //Get authorization header
        String authHeader = request.getHeader("Authorization");

        String token = null;
        String username = null;

        //Extract token and username from header
        if(authHeader != null && authHeader.startsWith("Bearer")){
            token = authHeader.substring(7);
            username = jwtService.extractUsername(token);
        }

        // 3. If token exists and user is not already authenticated
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            //Validate token
            if(jwtService.isTokenValid(token, userDetails.getUsername())){

                // 5. Set authentication in security context
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        
        // 6. Continue filter chain
        filterChain.doFilter(request, response);

    }

}
