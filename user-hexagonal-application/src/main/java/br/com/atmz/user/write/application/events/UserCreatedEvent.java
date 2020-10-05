package br.com.atmz.user.write.application.events;

import br.com.atmz.commons.events.GenericEvent;
import br.com.atmz.user.write.application.commands.create.CreateUserRepresentation;
import br.com.atmz.user.write.domain.Event;

public class UserCreatedEvent extends GenericEvent<CreateUserRepresentation> implements Event {

	private static final long serialVersionUID = -3227836731144398749L;

	public UserCreatedEvent(Object source, CreateUserRepresentation what) {
		super(source, what);
	}

}
