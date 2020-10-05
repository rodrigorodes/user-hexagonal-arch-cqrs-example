package br.com.atmz.user.write.application.commands.update;

import br.com.atmz.commons.cqrs.command.Command;

public class UpdateUserCommand implements Command<UpdateUserRepresentation> {

	private Long userId;
	private String name;
	private String mail;

	public UpdateUserCommand(Long userId, String name, String mail) {
		this.userId = userId;
		this.name = name;
		this.mail = mail;
	}

	public Long getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getMail() {
		return mail;
	}
}
