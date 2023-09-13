package com.generation.blogpessoall.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {

	public static final String SECRET = "N6lF8ZzKIjJZk4q0UcVLXxE96M4mo0JHVgKBtDKo2Q2IpKH+FefD/3xiZ78bFn0EfULqaPbNcbcQIk0hXo+pEnYw92+TBRzfcnvwz2AkKhtiK4caOmy8K41W8KaE4yaYZfVvPySeXuUCXB79HyKQJTUnTScIG2iB3fbz0a77HdxPnOy7+DtlX0oGXE/i9sqBF+g/63VX89XpTPcUmLfNGYpXSLaXdXjVEgkneNvv9A2WlwxDxPYalr1vrM2h0oiEe2nvvPDL40I/DyfHgzgCyKmK9c8zfkSsMD200kbQX/TZZACJFyI+vXIRnr8I4VntqDnl6eYwdkm1kAxx4CJFFP23JYsUxRBDJKCYFy4fNQ0=\r\n"
			+ "";

	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(getSignKey()).build()
				.parseClaimsJws(token).getBody();
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private String createToken(Map<String, Object> claims, String userName) {
		return Jwts.builder()
					.setClaims(claims)
					.setSubject(userName)
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
					.signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
	}

	public String generateToken(String userName) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userName);
	}

}
