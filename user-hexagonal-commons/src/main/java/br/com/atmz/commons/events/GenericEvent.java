package br.com.atmz.commons.events;

import org.springframework.context.ApplicationEvent;

public class GenericEvent<T> extends ApplicationEvent {

	private static final long serialVersionUID = -7660465962438070309L;
	
	private final T what;

	public GenericEvent(final Object source, final T what) {
		super(source);
		this.what = what;
	}

	public T getWhat() {
		return what;
	}

}