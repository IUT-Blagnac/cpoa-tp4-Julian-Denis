package application.actions;

import java.util.Scanner;

import action.Action;
import application.GenericActionAB;
import banque.AgenceBancaire;

public class ActionRetirerSurCompte extends GenericActionAB{
	public ActionRetirerSurCompte(String message, String code) {
		super("Retirer de l'argent sur un compte","2");
	}
	

	@Override
	public void execute(AgenceBancaire ag) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Saisir le numéro de compte :\n");
		Scanner lect = new Scanner ( System.in );
		String numCompte = lect.next();
		System.out.println("Entrez le montant à retirer :\n");
		Double montant = lect.nextDouble();
		ag.getCompte(numCompte).retirer((Double)montant);
	}


}
