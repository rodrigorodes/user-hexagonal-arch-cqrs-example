package br.com.atmz.user.write.domain;

import java.util.Optional;

public interface WriteUserRepository {

	User create(User user);
	
    Optional<User> findById(Long userId);


}
