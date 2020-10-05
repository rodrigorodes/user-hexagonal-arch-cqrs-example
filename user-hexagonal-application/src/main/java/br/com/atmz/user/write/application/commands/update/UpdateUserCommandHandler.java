package br.com.atmz.user.write.application.commands.update;

import java.util.Optional;

import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.atmz.commons.cqrs.command.CommandHandler;
import br.com.atmz.commons.validators.SelfValidating;
import br.com.atmz.user.write.application.events.UserUpdatedEvent;
import br.com.atmz.user.write.domain.User;
import br.com.atmz.user.write.domain.UserEventPublisher;
import br.com.atmz.user.write.domain.WriteUserRepository;

@Named
public class UpdateUserCommandHandler extends SelfValidating<UpdateUserCommand> implements CommandHandler<UpdateUserRepresentation, UpdateUserCommand> {

	private WriteUserRepository writeUserRepository;
	
    private UserEventPublisher userPublisher;
	
	public UpdateUserCommandHandler(
	    	WriteUserRepository writeUserRepository, 
	    	@Named("mailUpdateUserEventPublisher") UserEventPublisher userPublisher) {
		this.writeUserRepository = writeUserRepository;
		this.userPublisher = userPublisher;
		this.validateSelf();

	}

	@Transactional
	@Override
	public UpdateUserRepresentation handle(UpdateUserCommand command) {
		
		Optional<User> user = writeUserRepository.findById(command.getUserId());
		
		user.orElseGet(() -> user.orElseThrow(IllegalArgumentException::new));
		
		User userUpdate = user.get().update(command.getName(), command.getMail());
		
		UpdateUserRepresentation updateUserRepresentation = new UpdateUserRepresentation(userUpdate);
		
		userPublisher.publishEvent(new UserUpdatedEvent(userUpdate, updateUserRepresentation));

		return updateUserRepresentation;
	}

}	


