package it.univaq.disim.mudablue.models;

import java.util.ArrayList;
import java.util.List;

public class Repositories {
	
	private String repo_name;
	private ArrayList<String> main_list = new ArrayList<String>();
	private ArrayList<String> terms = new ArrayList<String>();
	private ArrayList<ArrayList<Double>> occurrencies_list = new ArrayList<ArrayList<Double>>();
	
	public String getRepo_name() {
		return repo_name;
	}
	public void setRepo_name(String repo_name) {
		this.repo_name = repo_name;
	}
	public ArrayList<String> getTerms() {
		return terms;
	}
	public void setTerms(ArrayList<String> terms) {
		this.terms = terms;
	}
	public ArrayList<String> getMain_list() {
		return main_list;
	}
	public void setMain_list(ArrayList<String> main_list) {
		this.main_list = main_list;
	}
	public ArrayList<ArrayList<Double>> getOccurrencies_list() {
		return occurrencies_list;
	}
	public void setOccurrencies_list(ArrayList<ArrayList<Double>> occurrencies_list) {
		this.occurrencies_list = occurrencies_list;
	}
	

}
