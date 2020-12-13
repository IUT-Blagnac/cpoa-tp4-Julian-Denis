package application;

import java.util.ArrayList;
import java.util.Scanner;

import action.Action;
import action.ActionList;
import banque.AgenceBancaire;

public class ActionListAgenceBancaire implements ActionList {

	private String message, code, title; 
	private ArrayList<Action> listeDesActions;

	public ActionListAgenceBancaire(String message, String code, String title, ArrayList<Action> listeDesActions) {
		this.message = message;
		this.code = code;
		this.listeDesActions = listeDesActions;
	}

	@Override
	public String actionMessage() {
		return this.message;
	}

	@Override
	public String actionCode() {
		return this.code;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(AgenceBancaire ag) throws Exception {
		Boolean found = true; 
		while(found) {
			System.out.println("--\n  Agence " + ag.getNomAgence() + " de " + ag.getLocAgence());
			System.out.println("  Menu Général\n--");
			System.out.println("  Choisir :");
			for (int i = 0; i < listeDesActions.size(); i++) {		
				System.out.println("    "+listeDesActions.get(i).actionCode()+" - "+listeDesActions.get(i).actionMessage());	
			}
			System.out.println("\n    0 - Pour quitter ce menu");
			System.out.println("Votre choix ?\\n");
			Scanner lect = new Scanner(System.in);
			String choix = lect.next();
			boolean erreurSaisie = true;
			if (choix.equals("0")) {
				found = false;
				erreurSaisie = false;
				break;
			}else{
				for (int i = 0; i< listeDesActions.size(); i++) {
					if (listeDesActions.get(i).actionCode().equals(choix)) {
						listeDesActions.get(i).execute(ag);
						erreurSaisie = false;
					}
				}
			}
			if (erreurSaisie == true) {
				System.out.println("Veuillez resaisir :");
			}
		}
		System.out.println("Fin de "+this.message);
	}

	@Override
	public String listTitle() {

		return this.title;
	}

	@Override
	public int size() {
		return listeDesActions.size();
	}

	@Override
	public boolean addAction(Action ac) {
		return false;
	}

}
