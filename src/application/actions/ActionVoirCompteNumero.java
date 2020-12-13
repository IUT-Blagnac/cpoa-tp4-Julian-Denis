package application.actions;

import java.util.Scanner;

import action.Action;
import application.GenericActionAB;
import banque.AgenceBancaire;

public class ActionVoirCompteNumero extends GenericActionAB{
	public ActionVoirCompteNumero(String message,  String code) {
		super("Voir un compte (par son numéro)","2");
	}

	@Override
	public void execute(AgenceBancaire ag) throws Exception {
		System.out.println("Saisir le numéro de compte :\n");
		Scanner scan = new Scanner(System.in);
		String num = scan.nextLine();
		System.out.println("Affichage du compte :\n");
		System.out.println(ag.getCompte(num)+"\n");
		
	}
	
}
