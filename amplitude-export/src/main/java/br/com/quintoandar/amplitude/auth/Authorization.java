package br.com.quintoandar.amplitude.auth;

import org.apache.commons.codec.binary.Base64;

public class Authorization {
	
	private String username;
	
	private String password;
	
	public Authorization(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String toString(){
		return String.format("Basic %s", getAsBase64());
	}

	private String getAsBase64() {
		return Base64.encodeBase64String(String.format("%s:%s", username,password).getBytes());
	}
	
	public static void main(String[] args) {
		System.out.println(new Authorization("httpwatch", "f"));
		System.out.println(new Authorization("Aladdin","OpenSesame"));
	}
}
