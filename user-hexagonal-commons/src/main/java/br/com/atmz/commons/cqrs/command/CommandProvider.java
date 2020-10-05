package br.com.atmz.commons.cqrs.command;

import org.springframework.context.ApplicationContext;

public class CommandProvider<H extends CommandHandler<?, ?>> {
	
    private final ApplicationContext applicationContext;
    private final Class<H> type;

    public CommandProvider(ApplicationContext applicationContext, Class<H> type) {
        this.applicationContext = applicationContext;
        this.type = type;
    }

    public H get() {
        return applicationContext.getBean(type);
    }
}
