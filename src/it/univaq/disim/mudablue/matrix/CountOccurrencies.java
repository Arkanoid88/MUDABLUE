package it.univaq.disim.mudablue.matrix;

import java.util.ArrayList;

public class CountOccurrencies {

	public double Count(ArrayList<String> list, String term){
		
		double counter = 0.0;

		for (String elem :list) {
			if(elem.equals(term)){counter+=1.0;}
		}
		
		//System.out.println(term);
		return counter;
	}
	
}
