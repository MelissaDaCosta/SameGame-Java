/*Melissa Da Costa et Chloe Trugeon*/

import javax.swing.*;
import java.applet.*;
import java.awt.event.*;

public class EffacerBlocs implements MouseListener{
    public char[][] tableaueffacer;
    private JFrame mafenetre;
    private double score;
    private double gain=0;
    private JLabel etiquetteScore;
    @Override
    public void mouseClicked(MouseEvent evenement){

	for(int i=1; i<(this.tableaueffacer.length)-1; i++){
	    for(int j=1; j<(this.tableaueffacer[0].length)-1; j++){
		if(this.tableaueffacer[i][j]=='S'){
		    this.tableaueffacer[i][j]='E';  // remplace les S par des E

		}
	    }
	}
	Deplacement essai = new Deplacement(this.tableaueffacer, mafenetre);
	essai.deplacer();
	this.afficherScore(this.score, this.gain);  // appel la MAJ du score
    }

    public void afficherScore(double monscore, double mongain){
	String score="GAIN PRECEDENT: "+Double.toString(mongain)+"     SCORE: "+Double.toString(monscore);
	this.etiquetteScore.setText(score);   // met a jour l'étiquette pour le score
    }


    public double donnerScore(double monscore, double gains){ // calcul du score
	this.score=monscore+gains;
	return this.score;

    }
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}

    public EffacerBlocs(char[][] tableau, JFrame fenetre, double mesgains, JLabel voirScore){ // constructeur
	this.mafenetre=fenetre;
	this.tableaueffacer=tableau;
	this.gain=mesgains;
	this.etiquetteScore=voirScore;
    }
    public EffacerBlocs(char[][] tableau, JFrame fenetre){  // autre constructeur
	this.mafenetre=fenetre;
	this.tableaueffacer=tableau;
    }
}
    
    
    
