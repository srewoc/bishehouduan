package com.bydbishe.common;

import io.jsonwebtoken.*;
import org.apache.tomcat.Jar;

import java.util.Date;
import java.util.UUID;

public class JWT {
    
    private final static long timelimit = 1000 * 60 * 60 * 24 * 7;
    private final static String  signature = "login";
    
    public static String jwtBuilde(Integer uid){
        JwtBuilder jwtBuilder = Jwts.builder();
        return jwtBuilder
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .claim("uid", uid)
                .setSubject("login")
                .setExpiration(new Date(System.currentTimeMillis()+ timelimit))
                .setId(UUID.randomUUID().toString()) 
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
    }
    
    public static Claims parse(String token){
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
        return claimsJws.getBody();
    }
}
