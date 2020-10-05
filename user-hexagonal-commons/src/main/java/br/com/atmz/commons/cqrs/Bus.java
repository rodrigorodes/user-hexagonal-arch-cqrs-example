package br.com.atmz.commons.cqrs;

import br.com.atmz.commons.cqrs.command.Command;
import br.com.atmz.commons.cqrs.query.Query;

public interface Bus {
	
    <R,C extends Command<R>> R executeCommand(C command);
    <R,Q extends Query<R>> R executeQuery(Q query);
}
