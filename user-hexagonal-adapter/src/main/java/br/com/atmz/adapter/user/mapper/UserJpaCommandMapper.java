package br.com.atmz.adapter.user.mapper;

import java.util.Optional;

import br.com.atmz.user.write.domain.Role.RoleEnum;
import br.com.atmz.adapter.user.entity.UserJpa;
import br.com.atmz.user.write.domain.User;

public class UserJpaCommandMapper {

	public static Optional<User> convertToModel(UserJpa userJpa) {
		return Optional.ofNullable(
				User.ofWithoutPassword(
						userJpa.getName(), 
						userJpa.getMail(), 
						RoleEnum.getRoleByName(userJpa.getRoleName())));
	}

	public static UserJpa convertToEntity(User user) {
		return UserJpa.createWithoutId(
				user.getName(), 
				user.getMail(), 
				user.getPassword(), 
				user.getRoleName());
	}

}
