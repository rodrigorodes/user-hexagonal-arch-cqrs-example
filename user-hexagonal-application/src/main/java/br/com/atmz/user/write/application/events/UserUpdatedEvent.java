package br.com.atmz.user.write.application.events;

import br.com.atmz.commons.events.GenericEvent;
import br.com.atmz.user.write.application.commands.update.UpdateUserRepresentation;
import br.com.atmz.user.write.domain.Event;

public class UserUpdatedEvent extends GenericEvent<UpdateUserRepresentation> implements Event {

	private static final long serialVersionUID = -7684957097144714275L;

	public UserUpdatedEvent(Object source, UpdateUserRepresentation what) {
		super(source, what);
	}
}
