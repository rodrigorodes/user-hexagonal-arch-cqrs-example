package br.com.atmz.user.write.application.events;

import br.com.atmz.commons.events.GenericEvent;
import br.com.atmz.user.write.application.commands.create.CreateUserRepresentation;
import br.com.atmz.user.write.domain.Event;

public class CreateUserEvent extends GenericEvent<CreateUserRepresentation> implements Event {

	private static final long serialVersionUID = -3227836731144398749L;

	public CreateUserEvent(Object source, CreateUserRepresentation what) {
		super(source, what);
	}

}
