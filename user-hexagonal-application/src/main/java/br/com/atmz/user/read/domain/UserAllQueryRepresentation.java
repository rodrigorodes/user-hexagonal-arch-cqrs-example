package br.com.atmz.user.read.domain;

import java.util.ArrayList;
import java.util.List;

public class UserAllQueryRepresentation {

	private List<UserQueryRepresentation> userQueryReps;

	public UserAllQueryRepresentation() {
		userQueryReps = new ArrayList<>();
	}

	public void add(UserQueryRepresentation rep) {
		userQueryReps.add(rep);
	}
	
	public List<UserQueryRepresentation> getUserQueryReps() {
		return userQueryReps;
	}

}
