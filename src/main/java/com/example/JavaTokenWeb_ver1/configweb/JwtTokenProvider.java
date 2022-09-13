package com.example.JavaTokenWeb_ver1.configweb;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@Slf4j
public class JwtTokenProvider {
    // Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
    private final String JWT_SECRET = "hehehaha";

    //Thời gian có hiệu lực của chuỗi jwt
    private final long JWT_EXPIRATION = 60*5;


    // Tạo ra jwt từ thông tin user
//    public String generateToken(org.springframework.security.core.userdetails.User userDetails) {
//        Date now = new Date(System.currentTimeMillis());
//        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
//
//        // Tạo chuỗi json web token từ id của user.
//        return Jwts.builder()
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(now)
//                .setExpiration(expiryDate)
//                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
//                .compact();
//    }

    //generate token for user
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION * 1000))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
    }

    // Lấy thông tin user từ jwt
//    public String getUserIdFromJWT(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(JWT_SECRET)
//                .parseClaimsJws(token)
//                .getBody();
//
//        System.out.println(token);
//        return claims.getSubject();
//    }

    // Lấy thông tin user từ jwt
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
    }
    public boolean validateToken(String authToken, UserDetails userDetails) {
//            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            final String username = getUsernameFromToken(authToken);
            return (username.equals(userDetails.getUsername()) && !isTokenExpired(authToken));
    }

}