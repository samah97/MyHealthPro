package com.sd.myhealthpro.auth.service;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.MacAlgorithm;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import io.jsonwebtoken.security.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenService {

    private static final String SECRET_KEY = "NllmZHptNVVrNG9RRUs3NllmZHptNVVrNG9RRUs3NllmZHptNVVrNG9RRUs3NllmZHptNVVrNG9RRUs3NllmZHptNVVrNG9RRUs3NllmZHptNVVrNG9RRUs3NllmZHptNVVrNG9RRUs3Nl";
    private static final MacAlgorithm SIGNING_ALGORITHM = Jwts.SIG.HS512;
    private static final long ACCESS_TOKEN_VALIDITY_SECONDS = 1000*60*60;


    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        SecretKey secretKey = getSigningKey();
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String GenerateToken(String username){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String username){
        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+ACCESS_TOKEN_VALIDITY_SECONDS))
                .signWith(getSigningKey())
                .signWith(getSigningKey(), SIGNING_ALGORITHM)
                .compact();
    }

//    public String generateToken(String username, Set<Roles> authorities){
//        return Jwts.builder().subject(username)
//                .claim("roles",authorities)
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis()+ ACCESS_TOKEN_VALIDITY_SECONDS *  1000))
//                .signWith(getSecretKey(), SignatureAlgorithm.HS512)
//                .compact();
//    }
//
//    public String extractUsernameFromToken(String token){
//        if(isTokenExpired(token)){
//            return null;
//        }
//        return getClaims(token, Claims::getSubject);
//    }
//
//    public boolean isTokenExpired(String token){
//        Date expiration = getClaims(token, Claims::getExpiration);
//        return expiration.before(new Date());
//    }
//
//    public <T> T getClaims(String token, Function<Claims, T> resolver){
//        return resolver.apply(
//                Jwts.parser().verifyWith(
//                        getSecretKey()
//                ).build()
//                        .parseSignedClaims(token)
//                        .getPayload()
//        );
//    }
//
//    private SecretKey getSecretKey() {
//        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }





}
