/*Melissa Da Costa et Chloe Trugeon*/

import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.*;

public class Survol  implements MouseMotionListener {
    private char[][] tableau=new char[12][17];
    public char[][] tableaumodif=new char[12][17];
    private char[][] montableau= new char[12][17];
    private JLabel etiquetteScore;
    private int nbrblocs=0;
    private double gain=0;
    private double score;
    private JFrame mafenetre;
    private int coordx;
    private int coordy;

    public Survol(char[][]tab, JFrame fenetre, JLabel monetiquette){  // constructeur
	this.mafenetre=fenetre;
	this.tableau=tab;
	this.etiquetteScore=monetiquette;
    }
    
    @Override
    public void mouseMoved(MouseEvent evenement){ // a chaque mouvement de souris

	this.coordx=evenement.getX(); // coordonnees curseur souris
	this.coordy = evenement.getY();
	mafenetre.repaint();
	this.grilleAvecSurvol(this.tableau);  // appel methode	
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    public void grilleAvecSurvol (char[][] tab){

	for(int a=0; a<tab.length; a++){ 
	    for(int b=0; b<tab[a].length; b++){
	        this.montableau[a][b]=tab[a][b];
	    }	  
	}
	
	for(int i=1; i<(this.montableau.length)-1; i++){
	    for(int j=1; j<(this.montableau[i].length)-1; j++){
		
		if(((((i*100)/2)-50<coordy-30) && (coordy-30<(((i*100)/2)))) && ((((j*100)/2)-50<coordx) && (coordx<(((j*100)/2)))) && this.montableau[i][j]!='E'){  // calcul intervalle  coordonnées=un rubis

		    // y a pour minimun 30 pour certains systeme (d'ou le -30 )

		    Bloc montest= new Bloc(tab, i, j, mafenetre);
		    montest.determinerBlocs(i, j);
		    if(montest.blocValide>=2){  // si c'est un bon groupe de blocs

			GrilleAleatoire magrille=new GrilleAleatoire(montest.tableaucopy);	  

			mafenetre.add(magrille);
			this.nbrblocs=montest.blocValide-1;
			Score monscore= new Score(this.nbrblocs); 
			this.gain=monscore.donnerGain();  // donne le gain des blocs survolés
			EffacerBlocs effacement = new EffacerBlocs(montest.tableaucopy, mafenetre, this.gain, etiquetteScore); // efface bloc clickés
			mafenetre.addMouseListener(effacement);
			this.score=effacement.donnerScore(this.score, this.gain); // met a jour le score
			this.gain=0;

			GrilleAleatoire grille2 = new GrilleAleatoire(effacement.tableaueffacer);
			mafenetre.add(grille2);


		    }else{  // si c'est pas un bon groupe de blocs
			EffacerBlocs effacement = new EffacerBlocs(montest.tableaucopy, mafenetre);
			FinJeu partie= new FinJeu(mafenetre, effacement.tableaueffacer);
			partie.ecranFin(this.score);
		    }

		}
	    }
	}
	
    }

}
