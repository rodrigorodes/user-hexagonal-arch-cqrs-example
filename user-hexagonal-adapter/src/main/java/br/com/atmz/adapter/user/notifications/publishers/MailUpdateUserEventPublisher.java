package br.com.atmz.adapter.user.notifications.publishers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import br.com.atmz.user.write.domain.Event;
import br.com.atmz.user.write.domain.UserEventPublisher;

@Component
public class MailUpdateUserEventPublisher implements UserEventPublisher {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Override
	public void publishEvent(Event event) {
		publisher.publishEvent(event);
	}

}
