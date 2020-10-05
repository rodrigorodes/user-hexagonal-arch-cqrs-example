package br.com.atmz.user.write.application.commands.create;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.atmz.commons.cqrs.command.Command;
import br.com.atmz.commons.validators.SelfValidating;

public class CreateUserCommand extends SelfValidating<CreateUserCommand> implements Command<CreateUserRepresentation> {

	@NotBlank
	private final String name;
	
	@Email
	private final String mail;
	
	@NotBlank
	private final String password;
	
	public CreateUserCommand(String name, String mail, String password) {
		this.name = name;
		this.mail = mail;
		this.password = password;
		validateSelf();
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

}
