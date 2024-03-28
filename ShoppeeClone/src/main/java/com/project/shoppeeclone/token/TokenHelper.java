package com.project.shoppeeclone.token;

import com.project.shoppeeclone.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class TokenHelper {
    private final static String SECRET_KEY = "yourSecretKeyyourSecretKeyyourSecretKeyyourSecretKeyyourSecretKeyyourSecretKeyyourSecretKeyyourSecretKeyyourSecretKeyyourSecretKeyyourSecretKeyyourSecretKey";
    public static String generateToken(UserEntity userEntity){
        Date now = new Date();
        return Jwts.builder()
                .setIssuedAt(now)
                .claim("user_id",userEntity.getId())
                .setSubject(userEntity.getUserName())
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
    public static Long getUserIdFromToken(String accessToken){
        String token = accessToken.substring(7);
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims.get("user_id", Long.class);
    }
}
