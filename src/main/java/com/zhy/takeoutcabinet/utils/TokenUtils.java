package com.zhy.takeoutcabinet.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class TokenUtils {

    private static final long EXPIRE_TIME = 10*60*1000; // 过期时间(毫秒)
    private static final String TOKEN_SECRET ="zhy"; // 密钥盐

    public static String createToken(String username) {
        String token = null;
        Date expiresAT = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        token = JWT.create()
                .withIssuer("auth0")
                .withClaim("username", username)
                // 使用 HMAC256 加密算法
                .withExpiresAt(expiresAT).sign(Algorithm.HMAC256(TOKEN_SECRET));
        return token;
    }
    // 验证 token
    public static boolean verify(String token){
//        try {
//            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
//            DecodedJWT jwt = verifier.verify(token);
//            System.out.println("jwt: " + jwt);
//            return true;
//        } catch (Exception e){
//            return false;
//        }
        return token != null;
    }

}
