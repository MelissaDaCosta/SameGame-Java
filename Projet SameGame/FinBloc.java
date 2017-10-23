/*Melissa Da Costa et Chloe Trugeon*/

import javax.swing.*;

public class FinBloc extends Bloc{

    public FinBloc(char[][]tab, int a, int b, JFrame fenetre){
	super(tab, a, b, fenetre);
    }
    @Override
    public void determinerBlocs(int i, int j){


	if(couleur==tableaucopy[i][j-1]){
	    this.blocValide++;
	    if(this.blocValide<2)
		this.determinerBlocs(i, j-1);
	    	     
	}if(couleur==tableaucopy[i][j+1]){
	    this.blocValide++;
	    if(this.blocValide<2)
		this.determinerBlocs(i, j+1);
		     
	}if(couleur==tableaucopy[i-1][j]){
	    this.blocValide++;
	    if(this.blocValide<2)
		this.determinerBlocs(i-1, j);

	}if(couleur==tableaucopy[i+1][j]){
	    this.blocValide++;
	    if(this.blocValide<2)
		this.determinerBlocs(i+1, j);
	}


    }
}
