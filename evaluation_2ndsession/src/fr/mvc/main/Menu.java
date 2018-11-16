/**
 * Projet D�mo JDBC-SQL
 */
package fr.mvc.main;

import java.util.Scanner;

public class Menu {
 
	public static Scanner saisie = new Scanner(System.in);
	
	public static void lancerMenu() {
		int choix = 0;
		
		do {
			System.out.println("Choisissez une commande : ");
			System.out.println("1. Afficher la liste des apprenants");
			System.out.println("2. Afficher la liste des apprenants par région");
			System.out.println("3. Afficher la liste des apprenants par activité");
            System.out.println("4. Afficher la liste des activités d'un apprenant");
            System.out.println("5. Afficher la liste des activités d'un apprenant");
			System.out.println("5. quitter");
			choix = saisie.nextInt();
			
			switch (choix) {
			case 1:
				System.out.print("Choisissez une largeur :");
				largeur = saisie.nextInt();
				System.out.print("Choisissez une hauteur :");
				hauteur = saisie.nextInt();
				Dessins.afficherRectangle(largeur, hauteur);
				break;
				
			case 2:
				System.out.print("Choisissez une hauteur :");
				hauteur = saisie.nextInt();
				Dessins.afficherTriangleIsoceleEtTriangleIsoceleInverse(hauteur);
				break;
				
			case 3:
				System.out.print("Choisissez une hauteur (chiffre impair) :");
				hauteur = saisie.nextInt();
				Dessins.afficherLosange(hauteur);;
				break;
				
			case 4:
				System.out.print("Choisissez une hauteur (chiffre impair) :");  
				hauteur = saisie.nextInt();
				Dessins.afficherCroix(hauteur);;
				break;
				
			case 5:
				System.out.print("Au revoir");
				break;

			default:
				System.out.print("cette commande n'existe pas.");
				break;
			}
		} while(choix != 5);
			
	}
}