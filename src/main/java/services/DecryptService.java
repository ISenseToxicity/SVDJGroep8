package services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class DecryptService {

    public String decrypt(String token) {
        byte[] key = new byte[64]; //my eyes are burning from this

        Jws<Claims> result = Jwts.parserBuilder()
                .requireAudience("Frontend")
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);

        return result.getBody().get("Json", String.class);
    }

}
