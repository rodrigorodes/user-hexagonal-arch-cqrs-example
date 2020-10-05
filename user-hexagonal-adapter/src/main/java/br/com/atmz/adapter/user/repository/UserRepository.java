package br.com.atmz.adapter.user.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.atmz.adapter.user.entity.UserJpa;

@Repository
public interface UserRepository extends CrudRepository<UserJpa, Long> {

	Optional<UserJpa> findByMail(String username);

}
