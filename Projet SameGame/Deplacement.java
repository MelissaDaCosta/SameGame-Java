/*Melissa Da Costa et Chloe Trugeon*/

import javax.swing.*;

public class Deplacement{
    public char[][] tableaudeplacer;
    private JFrame mafenetre;
	
    public void deplacer(){
	int compteur;

	//Deplacement vers le bas
	for(int i=1; i<(this.tableaudeplacer.length)-1; i++){
	 
	    for(int j=1; j<(this.tableaudeplacer[i].length)-1; j++){
		if(this.tableaudeplacer[i][j]  == 'E'){
		   
		    if(this.tableaudeplacer[i-1][j]!='E' && this.tableaudeplacer[i-1][j]!='-'){
			char tmp = this.tableaudeplacer[i-1][j];
			this.tableaudeplacer[i-1][j]='E';
			this.tableaudeplacer[i][j]=tmp;
			Deplacement encore = new Deplacement(this.tableaudeplacer,mafenetre);
			encore.deplacer();
		    }
		}
	    }
	}

	//Deplacement vers la gauche
	for(int a=1; a<16; a++){
	    compteur = 0;
	    for(int b=1; b<11; b++){
		if(this.tableaudeplacer[b][a]=='E'){
		    compteur++;
		}
		if(compteur==10 && this.tableaudeplacer[b][a+1]!='|'){
		    for(int c=1;c<11;c++){
			char tmp = this.tableaudeplacer[c][a+1];
			this.tableaudeplacer[c][a+1]='E';
			this.tableaudeplacer[c][a]=tmp;
		    }
			    
		}
			
			
	    }
	}
	
	GrilleAleatoire grille3 = new GrilleAleatoire(this.tableaudeplacer);
	mafenetre.add(grille3);
    }
    
    public Deplacement(char[][] tableau, JFrame fenetre){
	this.tableaudeplacer=tableau;
	this.mafenetre=fenetre;
    }
}
