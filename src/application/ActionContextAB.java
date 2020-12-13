package application;

import action.ActionContext;
import banque.AgenceBancaire;

public class ActionContextAB implements ActionContext{
	private AgenceBancaire ag = new AgenceBancaire("", "");

	public ActionContextAB(AgenceBancaire ag) {
		this.ag = ag;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public AgenceBancaire getContext() {
		return this.ag;
	}
}
