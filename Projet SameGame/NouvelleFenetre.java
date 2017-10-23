/*Melissa Da Costa et Chloe Trugeon*/

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.io.*;


public class NouvelleFenetre extends JComponent {

    public void creerNouvelleFenetre (String action){
	char[][] tab = new char[12][17];

	JFrame fenetre = new JFrame("RUBIS");

	fenetre.setSize(800, 600);
	fenetre.setLocationRelativeTo(null);
fenetre.getContentPane().setBackground(Color.WHITE);  // couleur fond fenetre
	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
JLabel score=new JLabel("");
	score.setHorizontalAlignment(JLabel.CENTER); 
score.setForeground(Color.magenta);
	fenetre.add(score,BorderLayout.SOUTH); 


/*******************************************************************************************/

	if(action.equals("Jouer avec une grille al\u00e9atoire")){ 
	    GrilleAleatoire magrille = new GrilleAleatoire(tab);
	    magrille.remplirGrilleAleatoirement(); 
	    fenetre.add(magrille);
Survol monsurvol= new Survol(magrille.montableau, fenetre, score);
	fenetre.addMouseMotionListener(monsurvol);
	}else{

	    JFileChooser choix= new JFileChooser();
	    FileNameExtensionFilter filtre= new FileNameExtensionFilter("fichier texte RVB", "txt");
	    choix.addChoosableFileFilter(filtre);
	    int valeur = choix.showOpenDialog(fenetre);
	    if(valeur == JFileChooser.APPROVE_OPTION) {


String fichierchoisi=choix.getSelectedFile().getName();
		System.out.println("Vous avez ouvert ce fichier: " +fichierchoisi);

 File fichier= new File(choix.getCurrentDirectory()+File.separator+fichierchoisi); // recupere le chemin du fichier

String chemin=fichier.getAbsolutePath();  // converti le chemin en String

	FichierGrille fichiergrille= new FichierGrille(chemin, fenetre);
		tab=fichiergrille.lireGrille();
		GrilleAleatoire magrille = new GrilleAleatoire(tab);
		fenetre.add(magrille);
Survol monsurvol= new Survol(magrille.montableau, fenetre, score);
	fenetre.addMouseMotionListener(monsurvol);
	    }	 
	    
	}

	fenetre.setVisible(true);

    }
}
