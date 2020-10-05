package br.com.atmz.user.write.domain;

public class Role {

	private String name;

	private Role(String role) {
		this.name = role;
	}

	public String getName() {
		return name;
	}

	public static Role of(String name) {
		return new Role(name);
	}

	public enum RoleEnum {

		ADMIN("ADMIN"), USER("USER");

		private String name;

		private RoleEnum(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public static RoleEnum getRoleByName(String nameRole) {
			for (RoleEnum role : RoleEnum.values()) {

				if (role.getName().equals(nameRole)) {
					return role;
				}
			}

			throw new IllegalArgumentException("Role not found !");
		}
	}
}
