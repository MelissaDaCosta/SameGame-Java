/*Melissa Da Costa et Chloe Trugeon*/

import javax.swing.*;
import java.awt.*;

public class FinJeu{
    boolean finPartie=true;
    JFrame mafenetre;
    private char[][] tab;


    public FinJeu(JFrame fenetre, char[][]tableau) {
	this.mafenetre=fenetre;
	this.tab=tableau;
    }
    public boolean finDeLaPartie(){

	for(int i=1; i<(this.tab.length)-1; i++){
	    for(int j=1; j<(this.tab[i].length)-1; j++){
		if(this.tab[i][j]!='E'){
		    FinBloc nouveaubloc= new FinBloc(this.tab, i, j, mafenetre);
		    nouveaubloc.determinerBlocs(i, j);
		    if(nouveaubloc.blocValide>=2){
			this.finPartie=false;
		    }
		}
	    }
	}
	return this.finPartie;	       
    }


    public void ecranFin(double score){
	if(finDeLaPartie()){
	this.mafenetre.setVisible(false);

	JFrame fenetre = new JFrame("RUBIS");

	fenetre.setSize(750, 500);
	fenetre.setLocationRelativeTo(null);
	
	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	GridLayout gestionnaire = new GridLayout(2, 1);  // cree grille 2 lignes 1 colonne
	fenetre.setLayout(gestionnaire);

	JLabel etiquette=new JLabel("La partie est finie vous avez fait un score de: "+score);
	etiquette.setHorizontalAlignment(JLabel.CENTER); //  la positionne
	fenetre.add(etiquette,BorderLayout.CENTER); // ajoute le premier element de la grille ligne 1 colonne 1
	JPanel panneau = new JPanel();
	JButton bouton1 = new JButton("Rejouer");

	panneau.add(bouton1); // affiche le bouton

	JButton bouton2 = new JButton("Quitter");

	panneau.add(bouton2);

	fenetre.add(panneau, BorderLayout.CENTER); 

	BoutonMenu observateur = new BoutonMenu(fenetre);
	bouton1.addActionListener(observateur);
	bouton2.addActionListener(observateur);
 
	fenetre.setVisible(true);
		}
    }
}
