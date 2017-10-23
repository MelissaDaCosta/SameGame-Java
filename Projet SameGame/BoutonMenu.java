/*Melissa Da Costa et Chloe Trugeon*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // importe les evenements

public class BoutonMenu implements ActionListener {

    private JFrame fenetre2 = new JFrame();

    @Override // remplace methode
    public void actionPerformed(ActionEvent evenement){
	String action = evenement.getActionCommand();// donne le texte du bouton cliqué

	if(action.equals("Quitter")){
	    System.exit(0);
	}else if(action.equals("Rejouer")){
	    fenetre2.setVisible(false);
	    Menu monmenu= new Menu();
	    monmenu.creerMenu();

	}else{

	    fenetre2.setVisible(false);
	    NouvelleFenetre lapartie= new NouvelleFenetre();
	    lapartie.creerNouvelleFenetre(action);
	}

    }


    public BoutonMenu(JFrame fenetre){  // constructeur
	this.fenetre2 = fenetre; // affecte a notre nouvelle fenetre la fenetre a effacer
    }

}
