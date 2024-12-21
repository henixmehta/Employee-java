package com.myproject.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JWTUtil {

    private static final String SECRET_KEY = "V2JZa9y3Un2gh9Vmk1tO7l07sVqUcbmM6fEw7rJ2l1F0kHRZ0ZtVpTkF0Ym5mHJt"; // Ensure this secret key is the same everywhere

    // Method to generate token, includes username and groupName (role)
    public static String generateToken(String username, String groupName) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", groupName) // Set the role (groupName) as claim
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour expiration
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    // Method to extract the role (groupName) from the token
    public static String getUserRoleFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        System.out.println("com.myproject.jwt.JWTUtil.getUserRoleFromToken()" + claims);
        return claims.get("role", String.class); // Return the role (groupName) from the token
    }

    // Method to extract the username from the token
    public static String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Method to check if the token is expired
    public static boolean isTokenExpired(String token) {
        return getExpirationDateFromToken(token).before(new Date());
    }

    // Method to get the expiration date from the token
    private static Date getExpirationDateFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }

    public static boolean validateToken(String token, String role) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY) // Ensure this matches the key used during token creation
                    .parseClaimsJws(token) // Parse the JWT
                    .getBody();

            // Extract the role from the claims and compare it to the expected role
            String tokenRole = claims.get("role", String.class);
            System.out.println("com.myproject.jwt.JWTUtil.validateToken()" + tokenRole);
            return tokenRole != null && tokenRole.equals(role) && !isTokenExpired(token);
        } catch (Exception e) {
            System.out.println("Token validation failed: " + e.getMessage());
            return false;
        }
    }
//public static void main(String[] args) {
//    String token = generateToken("test@example.com", "admin");
//    System.out.println("Generated Token: " + token);
//
//    // Simulate token validation
//    boolean isValid = validateToken(token, "admin");
//    System.out.println("Token valid: " + isValid);
//}

}
