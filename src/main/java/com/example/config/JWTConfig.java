package com.example.config;

import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Component
public class JWTConfig {

    private byte[] secret ="QQ5JeAwBQ5!s-&1K^+V#wMAeP1p*m69#".getBytes(StandardCharsets.UTF_8);

    public int expireAt = 86400;

    public SecretKey secretKey = new SecretKeySpec(secret,"HmacSHA384");
}
