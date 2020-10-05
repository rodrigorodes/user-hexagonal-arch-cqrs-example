package br.com.atmz.user.read.domain;

public interface ReadUserRepository {

	UserRepresentation findUserById(Long id);

	UserAllRepresentation findAll();

}
