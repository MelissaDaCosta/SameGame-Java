/*Melissa Da Costa et Chloe Trugeon*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Menu {
    public void creerMenu (){
	
	JFrame fenetre = new JFrame("RUBIS");

	fenetre.setSize(750, 500);
	fenetre.setLocationRelativeTo(null);
	
	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	GridLayout gestionnaire = new GridLayout(2, 1);  // cree grille 2 lignes 1 colonne
	fenetre.setLayout(gestionnaire);

	JLabel etiquette=new JLabel("Comment voulez-vous jouer ?");
	etiquette.setHorizontalAlignment(JLabel.CENTER); //  la positionne
	fenetre.add(etiquette,BorderLayout.CENTER); // ajoute le premier element de la grille ligne 1 colonne 1
	JPanel panneau = new JPanel();
	JButton bouton1 = new JButton("Jouer avec une grille al\u00e9atoire");

	
	panneau.add(bouton1); // affiche le bouton

	JButton bouton2 = new JButton("Jouer \u00e0 partir d'un fichier");

	panneau.add(bouton2);

	fenetre.add(panneau, BorderLayout.CENTER); 

	BoutonMenu observateur = new BoutonMenu(fenetre);
	bouton1.addActionListener(observateur);
	bouton2.addActionListener(observateur);
 

	fenetre.setVisible(true);
    }
}
