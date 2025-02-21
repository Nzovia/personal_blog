package com.example.blogging_platform.jwt_security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Nicholas Nzovia
 * @On 24/05/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Component
public class JwtService {
    public static final String SECRET = "76334825613d4428743d6a2b4a3e7e32213e6a4d2f3241345c704d3e57"; //256 bit key

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }
    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    public Boolean isTokenExpired(String token){
        return  extractExpiration(token).before(new Date());
    }

    //validating token
    public Boolean validateToken(String token, UserDetails userDetails){
        final String userName =  extractUsername(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    //Generating Token
    public static String generateToken(String username){
        Map<String,Object> claims = new HashMap<>();
        return  createToken(claims,username);
    }

    private static String createToken(Map<String, Object> claims, String username) {
        return  Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private static Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
