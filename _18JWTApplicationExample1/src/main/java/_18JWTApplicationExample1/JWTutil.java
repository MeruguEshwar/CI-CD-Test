package _18JWTApplicationExample1;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTutil {

	//1.Generate Token
	public String generateToken(String id,String subject,String key) {
		return Jwts.builder()
				.setId("A526")
				.setSubject("Eshwar")
				.setIssuer("Merugu")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)))
				.signWith(SignatureAlgorithm.HS256,Base64.getEncoder().encode(key.getBytes())).compact();
	}
	
	//2.Get Claims
	public Claims getClaims(String token,String key) {
		return Jwts.parser().setSigningKey(Base64.getEncoder().encode(key.getBytes())).parseClaimsJws(token).getBody();
	}
	
	public String getSubject(String key,String token) {
		return getClaims(key, token).getSubject();
	}
	
	public boolean isValidToken(String key,String token) {
		return getClaims(token, key)
				.getExpiration()
				.after(new Date(System.currentTimeMillis()));
	}
}
