package br.com.atmz.user.read.domain;

public class UserQueryRepresentation {

	private final Long id;
	private final String name;
	private final String mail;
	private final String role;
	
	public UserQueryRepresentation(Long id, String name, String mail, String role) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMail() {
		return mail;
	}

	public String getRole() {
		return role;
	}

}
