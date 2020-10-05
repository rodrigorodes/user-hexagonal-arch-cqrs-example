package br.com.atmz.commons.cqrs.query;

public interface QueryHandler<R, C extends Query<R>> {
	
    R handle(C query);
}
