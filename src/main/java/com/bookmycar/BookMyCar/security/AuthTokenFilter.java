package com.bookmycar.BookMyCar.security;

import java.io.IOException;

import com.bookmycar.BookMyCar.service.UserDetailsImpl;
import com.bookmycar.BookMyCar.service.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthTokenFilter extends OncePerRequestFilter {
  @Autowired
  private JwtUtils jwtUtility;

  @Autowired
  private UserDetailsServiceImpl userService;

  @Override
  protected void doFilterInternal (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
    String authorization = httpServletRequest.getHeader("Authorization");
    String token = null;
    String email = null;

    if (null != authorization && authorization.startsWith("Bearer ")) {
      token = authorization.substring(7);
      email = jwtUtility.getEmailFromToken(token);
    }

    if (email!=null && SecurityContextHolder.getContext().getAuthentication() == null) {

      UserDetailsImpl userDetails = userService.loadUserByUsername(email);

      if (jwtUtility.validateToken(token, userDetails)) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(userDetails,
                null, userDetails.getAuthorities());
        usernamePasswordAuthenticationToken.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(httpServletRequest)
        );

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
      }

    }
    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }
}
