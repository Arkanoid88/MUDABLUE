package it.univaq.disim.mudablue.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Repositories {
	
	private String repoName;
	private ArrayList<String> mainList = resumeMainList();
	private ArrayList<String> terms = new ArrayList<String>();
	private ArrayList<ArrayList<Double>> occurrencies_list = new ArrayList<ArrayList<Double>>();
	
	public String getRepo_name() {
		return repoName;
	}
	public void setRepo_name(String repo_name) {
		this.repoName = repo_name;
	}
	public ArrayList<String> getTerms() {
		return terms;
	}
	public void setTerms(ArrayList<String> terms) {
		this.terms = terms;
	}
	public ArrayList<String> getMain_list() {
		return mainList;
	}
	public void setMain_list(ArrayList<String> main_list) {
		this.mainList = main_list;
	}
	public ArrayList<ArrayList<Double>> getOccurrencies_list() {
		return occurrencies_list;
	}
	public void setOccurrencies_list(ArrayList<ArrayList<Double>> occurrencies_list) {
		this.occurrencies_list = occurrencies_list;
	}
	
	public ArrayList<String> resumeMainList()
	{
		File folder_path = new File("results/");
		File[] listOfFiles = folder_path.listFiles();
		
		ArrayList<String> files = new ArrayList<String>();
		for(File elem:listOfFiles)
		{
			int indexx = elem.toString().indexOf("/");
			String string = elem.toString().substring(indexx+9);
			files.add(string);
		}
		
		if(files.contains("mainList.txt"))
		{
			File mainListFile = new File(folder_path+"/mainList.txt");
		    Scanner scan;
		    ArrayList<String> mainList = new ArrayList<String>();
		    
		    try {
				scan = new Scanner(mainListFile);
				while(scan.hasNext())
				{
				    mainList.add(scan.next());
				    
				}
				return mainList;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    

		}
		else 
		{
			ArrayList<String> mainList = new ArrayList<String>();
			return mainList;
		}
		return mainList;
	}
	public void saveMainList(ArrayList<String> main_list) {
		try {
			
			PrintStream ps = new PrintStream("results/mainList.txt");
			for(String elem:main_list)
			{
				ps.println(elem);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

