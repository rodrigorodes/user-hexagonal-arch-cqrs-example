package br.com.atmz.user.write.application.commands.create;

import br.com.atmz.user.write.domain.User;

public class CreateUserRepresentation   {

	private User user;

	public CreateUserRepresentation(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
