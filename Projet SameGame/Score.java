/*Melissa Da Costa et Chloe Trugeon*/

import javax.swing.*;

public class Score{
    private JFrame mafenetre;
    private double blocs;

    public Score(int nbrblocs){
	this.blocs= (double) nbrblocs;
    }

    public double donnerGain(){
	double gain=0;
	    gain=Math.pow((this.blocs-2),2);
		return gain;
    }



}

	     

	
    
