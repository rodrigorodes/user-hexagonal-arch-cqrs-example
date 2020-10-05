package br.com.atmz.commons.cqrs.command;

public interface CommandHandler<R, C extends  Command<R>> {
	
    R handle(C command);
}
