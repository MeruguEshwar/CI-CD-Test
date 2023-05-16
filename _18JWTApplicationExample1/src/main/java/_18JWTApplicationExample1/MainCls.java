package _18JWTApplicationExample1;

import io.jsonwebtoken.Claims;

public class MainCls {

	public static void main(String[] args) {
		System.out.println("hi...");
		JWTutil util = new JWTutil();
		
		//to generate tokens
		String token = util.generateToken("123", "Eshwar","Merugu");
		System.out.println("token data is:"+token);
		
		
		//to generate claims
		Claims c = util.getClaims(token, "Merugu");
		System.out.println("claims id is:"+c.getId());
		System.out.println("claims subject is:"+c.getSubject());
		System.out.println("claims duraion is:"+c.getExpiration());
	}
}
