package application.actions;

import application.GenericActionAB;
import banque.AgenceBancaire;

public class ActionListeDesComptes extends GenericActionAB{


	
	
	public ActionListeDesComptes(String message, String code) {
		super("Liste des comptes de l'agence","1");
	}
	

	@Override
	public void execute(AgenceBancaire ag) throws Exception {
		// TODO Auto-generated method stub
		ag.afficher();
	}

}
