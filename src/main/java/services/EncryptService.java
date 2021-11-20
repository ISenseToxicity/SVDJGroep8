package services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class EncryptService {

    public String encrypt(String json) {
        Instant now = Instant.now();
        byte[] key = new byte[64];

        return Jwts.builder()
                .setSubject("Frontend")
                .setAudience("Backend")
                .claim("JsonString", json)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(1, ChronoUnit.MINUTES)))
                .signWith(Keys.hmacShaKeyFor(key))
                .compact();
    }
}
