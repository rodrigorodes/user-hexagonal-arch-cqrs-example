package br.com.atmz.user.write.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.atmz.user.write.domain.Role.RoleEnum;

public class User {

	private Long id;
	private String name;
	private String mail;
	private String password;
	private List<Role> roles = new ArrayList<>();

	private User(String name, String mail, String password, RoleEnum role) {
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.addRole(role.name());		
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
	
	public String getPassword() {
		return password;
	}

	public String getRoleName() {
		return this.roles
				.stream()
				.findFirst()
				.get()
				.getName();
	}
	
	public void addRole(String roleName) {
		
		Objects.requireNonNull(roleName);
		
		boolean hasRole = roles
		.stream()
		.filter(role -> role.getName().equals(roleName))
		.findFirst()
		.isPresent();
		
		if(!hasRole) {
			roles.add(Role.of(roleName));
		}

	}

	public User update(String name, String mail) {
		this.name = name;
		this.mail = mail;
		return this;
	}

	public static User of(String name, String mail, String password, RoleEnum role) {
		return new User(name, mail, password, role);
	}
	
}
