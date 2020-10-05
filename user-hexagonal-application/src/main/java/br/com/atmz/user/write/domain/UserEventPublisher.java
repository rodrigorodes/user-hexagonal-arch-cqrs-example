package br.com.atmz.user.write.domain;

public interface UserEventPublisher {

	void publishEvent(Event event);

}
