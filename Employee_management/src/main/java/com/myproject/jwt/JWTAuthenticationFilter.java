/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.myproject.jwt;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class JWTAuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestURI = httpRequest.getRequestURI();

        // Exclude login page and any resources like CSS, JS, images
        if (requestURI.endsWith("/index.xhtml") || requestURI.endsWith("/index.html") || requestURI.endsWith("/")) {
            chain.doFilter(request, response); // Allow the request to proceed without filtering
            return;
        }
        chain.doFilter(request, response);
        
//        String token = httpRequest.getHeader("Authorization");
//        System.out.println("com.myproject.jwt.JWTAuthenticationFilter.doFilter()" + token);
//        System.out.println("Token from session " + FacesContext.getCurrentInstance());
////        System.out.println("Token from session " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("jwtToken"));
//
//        if (token != null && token.startsWith("Bearer ")) {
//            token = token.substring(7); // Remove "Bearer " prefix
//            try {
//                // Validate token and extract the role
//                String role = JWTUtil.getUserRoleFromToken(token);
//                // Check if the user has the correct role (admin or manager)
//                if (role.equals("admin") || role.equals("manager")) {
//                    chain.doFilter(request, response); // User is authorized, proceed with the request
//                } else {
//                    // User is not authorized for this resource
//                    httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied: Insufficient permissions");
//                }
//            } catch (Exception e) {
//                // Handle invalid token
//                httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token validation failed");
//            }
//        } else {
//            // No token found, return unauthorized error
//            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid token");
//        }

    }

    @Override
    public void destroy() {
    }
}
