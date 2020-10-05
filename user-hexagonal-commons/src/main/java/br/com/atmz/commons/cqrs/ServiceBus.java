package br.com.atmz.commons.cqrs;

import br.com.atmz.commons.cqrs.command.Command;
import br.com.atmz.commons.cqrs.command.CommandHandler;
import br.com.atmz.commons.cqrs.query.Query;
import br.com.atmz.commons.cqrs.query.QueryHandler;

@SuppressWarnings("unchecked")
public class ServiceBus implements Bus {
	
    private final Registry registry;

    public ServiceBus(Registry registry) {
        this.registry = registry;
    }

    @Override
    public <R, C extends Command<R>> R executeCommand(C command) {
    	
        CommandHandler<R, C> commandHandler = (CommandHandler<R, C>) registry.getCmd(command.getClass());
        
        return commandHandler.handle(command);
    }

	@Override
    public <R, Q extends Query<R>> R executeQuery(Q query) {
		
        QueryHandler<R, Q> queryHandler = (QueryHandler<R, Q>) registry.getQuery(query.getClass());
        
        return queryHandler.handle(query);
    }
}
