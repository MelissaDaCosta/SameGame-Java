/*Melissa Da Costa et Chloe Trugeon*/

import java.util.Random;

public class Hasard{
	
	public char hasard() {
		String nomrubis ="RVB";
		int rubis=nomrubis.length();
		
		Random hasard= new Random();
		
		return nomrubis.charAt(hasard.nextInt(rubis));
		}
	
}
