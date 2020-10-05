package br.com.atmz.user.read.domain;

import java.util.ArrayList;
import java.util.List;

public class UserAllRepresentation {

	private List<UserRepresentation> userQueryReps;

	public UserAllRepresentation() {
		userQueryReps = new ArrayList<>();
	}

	public void add(UserRepresentation rep) {
		userQueryReps.add(rep);
	}
	
	public List<UserRepresentation> getUserQueryReps() {
		return userQueryReps;
	}

}
