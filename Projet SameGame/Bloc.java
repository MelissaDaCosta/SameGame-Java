/*Melissa Da Costa et Chloe Trugeon*/

import javax.swing.*;

public class Bloc extends JComponent{
    public char[][] tableaucopy = new char[12][17];
    public char couleur;
    private JFrame mafenetre;
    public int blocValide=0;

    
    public Bloc(char[][] tableau, int a, int b, JFrame fenetre){
	this.couleur=tableau[a][b];
	this.mafenetre=fenetre;
	this.tableaucopy=tableau;	 
    }

    public void determinerBlocs(int i, int j){

	if(couleur==tableaucopy[i][j-1] && tableaucopy[i][j-1]!='S'){
	    this.blocValide++;
	    if(this.blocValide>=2){
		tableaucopy[i][j-1]='S';
	    }
	    this.determinerBlocs(i, j-1);
	    
		     
	}if(couleur==tableaucopy[i][j+1] && tableaucopy[i][j+1]!='S'){
	    this.blocValide++;
	    if(this.blocValide>=2){
		tableaucopy[i][j+1]='S';
	    }
		
	    this.determinerBlocs(i, j+1);
		     
	}if(couleur==tableaucopy[i-1][j] && tableaucopy[i-1][j]!='S'){
	    this.blocValide++;
	    if(this.blocValide>=2){
		tableaucopy[i-1][j]='S';
	    }
	
	    this.determinerBlocs(i-1, j);

	}if(couleur==tableaucopy[i+1][j] && tableaucopy[i+1][j]!='S'){
	    this.blocValide++;
	    if(this.blocValide>=2){
		tableaucopy[i+1][j]='S';
	    }

	    this.determinerBlocs(i+1, j);
	}
	if(this.blocValide>=2){	 
	tableaucopy[i][j]='S';
	
	    }


	System.out.println("BLOCS");
	for(int a=0; a<tableaucopy.length; a++){  // afffiche le tableau avec les blocs représentés par des 'S'
	    for(int b=0; b<tableaucopy[a].length; b++){
		System.out.print(tableaucopy[a][b]);
	    }
	    System.out.println();
	}
    }
    
}
