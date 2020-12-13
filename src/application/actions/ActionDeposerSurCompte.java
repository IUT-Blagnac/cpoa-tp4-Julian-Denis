package application.actions;

import java.util.Scanner;

import action.Action;
import application.GenericActionAB;
import banque.AgenceBancaire;

public class ActionDeposerSurCompte extends GenericActionAB{

	
	
	public ActionDeposerSurCompte(String message, String code) {
		super("Déposer de l'argent sur un compte","1");
	}

	@Override
	public void execute(AgenceBancaire ag) throws Exception {
		System.out.println("Saisir le numéro de compte :\n");
		Scanner lect = new Scanner ( System.in );
		String numCompte = lect.next();
		System.out.println("Entrez le montant à deposer :\n");
		Double montant = lect.nextDouble();
		ag.getCompte(numCompte).deposer((Double)montant);
		
	}
}
