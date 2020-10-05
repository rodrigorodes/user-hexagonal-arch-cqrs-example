package br.com.atmz.user.write.application.commands.update;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

import br.com.atmz.commons.cqrs.command.Command;

public class UpdateUserCommand implements Command<UpdateUserRepresentation> {

	@NonNull
	private Long userId;
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Email
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
