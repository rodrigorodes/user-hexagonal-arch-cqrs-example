package br.com.atmz.adapter.user;

import java.util.Optional;

import br.com.atmz.adapter.user.mapper.UserJpaCommandMapper;
import br.com.atmz.adapter.user.repository.UserRepository;
import br.com.atmz.commons.cqrs.annotations.RepositoryAdapter;
import br.com.atmz.user.write.domain.User;
import br.com.atmz.user.write.domain.WriteUserRepository;

@RepositoryAdapter
public class WriteUserRepositoryAdapter implements WriteUserRepository {

	private final UserRepository userRepository;

	public WriteUserRepositoryAdapter(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User create(User user) {
		return UserJpaCommandMapper.convertToModel(userRepository.save(UserJpaCommandMapper.convertToEntity(user))).get();
	}

	@Override
	public Optional<User> findById(Long userId) {
		return UserJpaCommandMapper.convertToModel(userRepository.findById(userId).get());
	}


}
