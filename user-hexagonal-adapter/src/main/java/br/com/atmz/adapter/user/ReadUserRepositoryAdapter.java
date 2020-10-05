package br.com.atmz.adapter.user;

import java.util.Optional;

import org.springframework.util.Assert;

import br.com.atmz.adapter.user.entity.UserJpa;
import br.com.atmz.adapter.user.mapper.UserJpaQueryMapper;
import br.com.atmz.adapter.user.repository.UserRepository;
import br.com.atmz.commons.cqrs.annotations.RepositoryAdapter;
import br.com.atmz.user.read.domain.ReadUserRepository;
import br.com.atmz.user.read.domain.UserAllRepresentation;
import br.com.atmz.user.read.domain.UserRepresentation;

@RepositoryAdapter
public class ReadUserRepositoryAdapter implements ReadUserRepository {
	
	private final UserRepository userRepository;

	public ReadUserRepositoryAdapter(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserRepresentation findUserById(Long id) {
		
		Optional<UserJpa> user = userRepository.findById(id);

		Assert.notNull(user, "User Not null");

		return UserJpaQueryMapper.convertToQuery(user.get());
	}

	@Override
	public UserAllRepresentation findAll() {
		return UserJpaQueryMapper.convertToQueryAll(userRepository.findAll());
	}
}
