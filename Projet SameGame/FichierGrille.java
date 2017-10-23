/*Melissa Da Costa et Chloe Trugeon*/

import java.io.*;
import javax.swing.*;
import java.applet.*;


public class FichierGrille{
    private char[][] montableau = new char[12][17];
    private String fichier;
    private JFrame mafenetre;
    

    public char[][] lireGrille(){
	for(int b=0; b<this.montableau[0].length; b++){  // encadre premiere et derniere lignes
	    this.montableau[11][b]='-';	 
	    this.montableau[0][b]='-';
	}

	for(int a=0; a<this.montableau.length; a++){   // encadre premiere et derniere colonnes
	    this.montableau[a][16]='|'; 
	    this.montableau[a][0]='|';
	}


	try{
	 
	    BufferedReader monfichier= new BufferedReader(new FileReader(this.fichier));

	    try{
		int v;

		while((v=monfichier.read())!=-1){

		    for(int i=1; i<(montableau.length)-1; i++){
			
		
			for(int j=1; j<(montableau[i].length)-1; j++){
			   
			    char valeur=(char) v;
			    montableau[i][j]=valeur; // rempli tableau
			    
			    if(j==(montableau[i].length)-2){
			    	monfichier.read();
			    }else{
				v=monfichier.read();
				 
			    }
			}
		
			
			v=monfichier.read();
		    }
		   
			    
		       
		}
		
	    }catch(IOException e){
		System.err.println("Erreur de lecture");
	    }

	    try{
		monfichier.close();
	    }catch(IOException e){
		System.err.println("Erreur fermeture fichier");
	    }
	}catch(FileNotFoundException e){
	    System.err.println("Erreur ouverture fichier");
	}


	/**************************************************************************************************/


	for(int i=0; i<montableau.length; i++){
	    for(int j=0; j<montableau[i].length; j++){

		System.out.print(montableau[i][j]);
	    }
	    System.out.println();
	}
			
	return montableau;

    }

    public FichierGrille(String lefichier, JFrame fenetre){
	this.fichier=lefichier;
	this.mafenetre= fenetre;
	
	
    }
	

    
}

  
