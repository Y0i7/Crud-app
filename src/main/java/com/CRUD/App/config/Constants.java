package com.CRUD.App.config;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

public class Constants {

    public static final String LOGIN_URL = "/autenticar";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";
    public static final String HEADER_AUTHORIZATION = "Authorization";


    public static final String SECRET = "kEySeCrEta15895kEySeCrEta15895kEySeCrEta15895";
    public static final long EXPIRATION_TIME = 300_000; // 5 minutos

    public static SecretKey getSigningKeyB64(String secret){
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public static SecretKey getSigningKey(String secret){
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
