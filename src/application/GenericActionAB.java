package application;

import action.Action;
import banque.AgenceBancaire;

public abstract class GenericActionAB implements Action {

	private String message;
	private String code;

	public GenericActionAB(String message, String code) {
		this.message = message;
		this.code = code;
	}
	
	public String actionMessage () {
		return this.message;
	}
	
	public String actionCode () {
		return this.code;
	}

	public abstract void execute(AgenceBancaire ag) throws Exception;

}
