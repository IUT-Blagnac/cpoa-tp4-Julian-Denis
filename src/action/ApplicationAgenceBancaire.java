package action;


import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import application.AccesAgenceBancaire;
import application.ActionListAgenceBancaire;
import application.actions.ActionDeposerSurCompte;
import application.actions.ActionListeDesComptes;
import application.actions.ActionRetirerSurCompte;
import application.actions.ActionVoirCompteNumero;
import banque.AgenceBancaire;
import banque.Compte;
import banque.exception.CompteException;

public class ApplicationAgenceBancaire {
	

	public static void main(String argv[]) {
		ActionListeDesComptes action1 = new ActionListeDesComptes("Liste des comptes", "12");
		ActionVoirCompteNumero action2 = new ActionVoirCompteNumero("Voir numero compte", "1");
		ArrayList<Action> listeActionOPCompte = new ArrayList<Action>();
		ActionRetirerSurCompte actRetirer = new ActionRetirerSurCompte("Retirer", "27");
		
		ActionDeposerSurCompte actDepot = new ActionDeposerSurCompte("Depot", "35");
		listeActionOPCompte.add(actRetirer);
		listeActionOPCompte.add(actDepot);
		ActionListAgenceBancaire OPComtpe = new ActionListAgenceBancaire("Menu opérations sur comptes" , "42", "Menu opérations sur comptes", listeActionOPCompte);
		
		ArrayList<Action> listeAction = new ArrayList<Action>();
		listeAction.add(action1);
		listeAction.add(action2);
		listeAction.add(OPComtpe);
		ActionListAgenceBancaire actionList = new ActionListAgenceBancaire("Acceuil Pibrac", "69", "Pibrac",listeAction);
		
		try {
			actionList.execute(AccesAgenceBancaire.getAgenceBancaire());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void comptesDUnPropretaire (AgenceBancaire ag, String nomProprietaire) {
		Compte []  t; 
		
		t = ag.getComptesDe(nomProprietaire);
		if (t.length == 0) {
			System.out.println("pas de compte à ce nom ...");
		} else {
			System.out.println("  " + t.length + " comptes pour " + nomProprietaire);
			for (int i=0; i<t.length; i++)
				t[i].afficher();
		}
	}

	public static void deposerSurUnCompte (AgenceBancaire ag, String numeroCompte, double montant) {
		Compte c;
		
		c = ag.getCompte(numeroCompte);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant dépôt: "+c.soldeCompte());
			try {
				c.deposer(montant);
				System.out.println("Montant déposé, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de dépot, solde inchangé : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void retirerSurUnCompte (AgenceBancaire ag, String numeroCompte, double montant) {
		Compte c;
		
		c = ag.getCompte(numeroCompte);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant retrait : " + c.soldeCompte());
			try {
				c.retirer(montant);
				System.out.println("Montant retiré, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de dépot, solde inchangé : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}

	}
}
