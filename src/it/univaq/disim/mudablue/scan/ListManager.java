package it.univaq.disim.mudablue.scan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

public class ListManager {
	
	public ArrayList<String> create_local_list(File file) throws FileNotFoundException{
		// preso un file, torna la lista dei termini di quel file
		
		InputStream inputStream = new FileInputStream(file);
		
		try
		{
			CompilationUnit cu = JavaParser.parse(inputStream);
			ArrayList<String> small_list = new ArrayList<String>();
			
			small_list = merge(small_list,cu);
			return small_list;
		}
    	catch(Exception exc)
    	{
    		ArrayList<String> small_list = new ArrayList<String>();
    		small_list.add("");
    		return small_list;
    	}	
		

		
	}
	
	public ArrayList<String> merge(ArrayList<String> target_list, CompilationUnit cu){
		
		Parser parser = new Parser();
		for(List<String> elem : parser.GetVariables(cu))
		{
			target_list.add(elem.get(1));
		}
		for(String elem : parser.GetPackages(cu))
		{
			target_list.add(elem);
		}
		for(String elem : parser.GetMethods(cu))
		{
			target_list.add(elem);
		}
		for(String elem : parser.GetFieldsVariables(cu))
		{
			target_list.add(elem);
		}

		return target_list;
	}
	
	public ArrayList<String> create_main_list(ArrayList<String> main_list, ArrayList<String> local_list){	
		//data una lista locale e quella principale, mette tutti gli elementi nella lista principale
		
		for(String elem : local_list)
		{
			if(main_list.contains(elem)!=true)
			{
				main_list.add(elem);
			}
		}
		
		//main_list.sort(null);
		
		return main_list;
	}
	
	public ArrayList<String> create_raw_main_list(ArrayList<String> raw_main_list, ArrayList<String> local_list){	
		//data una lista locale e quella principale, mette tutti gli elementi nella lista principale
		
		for(String elem : local_list)
		{
			raw_main_list.add(elem);
		}
		
		//raw_main_list.sort(null);
		
		return raw_main_list;
	}
}
