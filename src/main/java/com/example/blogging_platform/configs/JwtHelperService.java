package com.example.blogging_platform.configs;

import com.example.blogging_platform.ExceptionHandling.AccessDeniedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * @author Nicholas Nzovia
 * @On 07/05/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

public class JwtHelperService {
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private static final int MINUTES = 60;

    //generating Token
    public static String generateToken(String email){
        var now = Instant.now();
        return Jwts.builder()
                .subject(email)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(MINUTES, ChronoUnit.MINUTES)))
                .signWith(SignatureAlgorithm.ES256,SECRET_KEY)
                .compact();
    }


    //extracting username
    public static  String extractUserName(String token) {
        return getTokenBody(token).getSubject();
    }

    //validating token
    public static Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUserName(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    //Checking token Expiration
    private static boolean isTokenExpired(String token) {
        Claims claims = getTokenBody(token);
        return claims.getExpiration().before(new Date());
    }

    private static Claims getTokenBody(String token) {
        try{
            return Jwts
                    .parser()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        }catch (SignatureException | ExpiredJwtException exception){
            throw new AccessDeniedException("Access denied: "+ exception.getMessage());
        }
    }


}
