/*Melissa Da Costa et Chloe Trugeon*/

import java.awt.*;
import javax.swing.*;


public class GrilleAleatoire  extends JComponent{
    public char[][] montableau = new char[12][17];
   
    Hasard methode = new Hasard(); 
	
    public void remplirGrilleAleatoirement(){
	
	for(int b=0; b<montableau[0].length; b++){  // encadre premiere et derniere lignes
	    montableau[11][b]='-';	 
	    montableau[0][b]='-';
	}

	for(int a=0; a<montableau.length; a++){   // encadre premiere et derniere colonnes
	    montableau[a][16]='|'; 
	    montableau[a][0]='|';
	}
	
	for(int i=1; i<(montableau.length)-1; i++){
	    for(int j=1; j<(montableau[i].length)-1; j++){
		
		montableau[i][j]=methode.hasard();	// rempli tableau
	    }	   
	}

  System.out.println("TABLEAU ALEATOIRE");
	for(int i=0; i<montableau.length; i++){   // affiche tableau
	    for(int j=0; j<montableau[0].length; j++){
		System.out.print(montableau[i][j]);
	    }
	    System.out.println();
	}

    }


/**********************************************************************************/
    @Override
    public void paintComponent(Graphics g) {

	Color vert= new Color(0, 230, 0);
Color survol= new Color(255, 255, 0, 200);
	if (this.isOpaque()) {
	    // on repeint toute la surface avec la couleur de fond
	   
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	int x=0;
	int y=0;

	for(int i=1; i<(this.montableau.length)-1; i++){
	    for(int j=1; j<(this.montableau[i].length)-1; j++){
		
		if(this.montableau[i][j]=='S'){
		    g.setColor(survol);
		   
		}else if(this.montableau[i][j]=='R'){
		    g.setColor(Color.RED);
        
		}else if(this.montableau[i][j]=='V'){
		    g.setColor(vert);
        
		}else if(this.montableau[i][j]=='B'){
		    g.setColor(Color.BLUE);
		   
		}else if(this.montableau[i][j]=='E'){
		    g.setColor(Color.WHITE);
	        
		}
		g.drawOval(x, y, 50, 50);
		g.fillOval(x, y, 50, 50);
		x=x+50;
	    }
	    x=0;
	    y=y+50;
	}
	
	
    }
    public GrilleAleatoire(char[][]tab){ // constructeur
	this.montableau=tab;
	
    }
}
