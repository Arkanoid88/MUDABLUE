package it.univaq.disim.mudablue.matrix;

import java.io.PrintStream;
import java.util.ArrayList;

import it.univaq.disim.mudablue.models.Repositories;

public class Row {
	
	public ArrayList<Double> create_row(Repositories repository_object, PrintStream ps)
	{
		ArrayList<Double> occurrencies_list = new ArrayList<Double>();
		CountOccurrencies counter = new CountOccurrencies();
	
		for(String elem :repository_object.getMain_list())
		{
			occurrencies_list.add(counter.Count(repository_object.getTerms(), elem, ps));
		}
		
		return occurrencies_list;
	}

}
	