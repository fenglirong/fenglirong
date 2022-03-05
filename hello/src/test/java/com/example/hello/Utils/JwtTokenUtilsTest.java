package com.example.hello.Utils;

import io.jsonwebtoken.Claims;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtTokenUtilsTest {

    @Test
    void testCreateJwtTokenAndParseToken() {
        String token = JwtTokenUtils.createJwtToken("1");
        Claims claims = JwtTokenUtils.parseToken(token);
        String userid = (String) claims.get("userid");
        Assert.assertEquals("1",userid);
    }
}