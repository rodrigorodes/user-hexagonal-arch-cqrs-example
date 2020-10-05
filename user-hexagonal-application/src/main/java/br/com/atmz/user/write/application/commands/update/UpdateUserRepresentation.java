package br.com.atmz.user.write.application.commands.update;

import br.com.atmz.user.write.domain.User;

public class UpdateUserRepresentation   {

	private User user;

	public UpdateUserRepresentation(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
