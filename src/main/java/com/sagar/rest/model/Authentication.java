package com.sagar.rest.model;

import java.util.List;

public class Authentication {
	
	public String email;
	public List<String> GrantedScopes;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "[email=" + email + ", GrantedScopes=" + GrantedScopes + "]";
	}
	public List<String> getGrantedScopes() {
		return GrantedScopes;
	}
	public void setGrantedScopes(List<String> grantedScopes) {
		GrantedScopes = grantedScopes;
	}

}
