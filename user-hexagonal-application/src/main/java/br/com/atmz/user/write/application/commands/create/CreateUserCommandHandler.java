package br.com.atmz.user.write.application.commands.create;

import javax.inject.Named;

import br.com.atmz.commons.cqrs.command.CommandHandler;
import br.com.atmz.user.write.application.events.CreateUserEvent;
import br.com.atmz.user.write.domain.Role.RoleEnum;
import br.com.atmz.user.write.domain.User;
import br.com.atmz.user.write.domain.UserEventPublisher;
import br.com.atmz.user.write.domain.WriteUserRepository;

@Named
public class CreateUserCommandHandler implements CommandHandler<CreateUserRepresentation, CreateUserCommand> {

	private WriteUserRepository repository;
	
    private UserEventPublisher userPublisher;
	
	public CreateUserCommandHandler(
			WriteUserRepository repository, 
			@Named("mailCreateUserEventPublisher") UserEventPublisher userPublisher) {
		this.repository = repository;
		this.userPublisher = userPublisher;
	}

	@Override
	public CreateUserRepresentation handle(CreateUserCommand command) {
		
		var newUser = repository.create(
				User.of(
				command.getName(),
				command.getMail(),
				command.getPassword(),
				RoleEnum.USER));
		
		var createUserRepresentation = new CreateUserRepresentation(newUser);	
		
		userPublisher.publishEvent(new CreateUserEvent(newUser, createUserRepresentation));
		
		return createUserRepresentation;
	}

}	


