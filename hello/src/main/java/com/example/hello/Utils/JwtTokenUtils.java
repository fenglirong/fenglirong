package com.example.hello.Utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

public class JwtTokenUtils {

    private static long time =1000*60*24;
    private static String signature ="secret";

    /**
     *@Title createJwtToken
     *@Author:Frank Feng
     *@Param:
     *@Description
     *@Date:2022/3/5 17:11
     *
     */
    public static String createJwtToken(String userid)
    {
        JwtBuilder builder = Jwts.builder();
        String jwtToken = builder.setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .claim("userid", userid)
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256,signature)
                .compact();
        return jwtToken;
    }

    /**
     *@Title parseToken
     *@Author:Frank Feng
     *@Param:
     *@Description
     *@Date:2022/3/5 17:13
     *
     */
    public static Claims parseToken(String token)
    {
        JwtParser parser = Jwts.parser();
        Jws<Claims> claimsJws = parser.setSigningKey(signature).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return claims;
    }

}
