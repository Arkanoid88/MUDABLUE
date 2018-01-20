package it.univaq.disim.mudablue.matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class testMain {

	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<String> path_list = new ArrayList<String>();
		/*path_list.add("C:/MudaBlue/webdriverextensions-master");
		path_list.add("C:/MudaBlue/seleniumQuery-master");
		path_list.add("C:/MudaBlue/selenium-cucumber-java-master");
		path_list.add("C:/MudaBlue/conductor-master");
		/*path_list.add("C:/MudaBlue/FakeRepo1");
		path_list.add("C:/MudaBlue/FakeRepo2");
		path_list.add("C:/MudaBlue/FakeRepo3");
		path_list.add("C:/MudaBlue/FakeRepo4");*/
		
		MatrixManager manager = new MatrixManager();
		LSA lsa = new LSA();
		
		
		/*File folder_path = new File("C:/MudaBlue/newtest/cosastrana");
		File[] listOfRepos = folder_path.listFiles();
		
		for(File elem:listOfRepos)
		{
			path_list.add(elem.toString());
		}
		
		ArrayList<ArrayList<Double>> occurrencies_list = new ArrayList<ArrayList<Double>>();
		occurrencies_list = manager.createList(path_list);
		
		System.out.println(occurrencies_list.get(0).size());
		RealMatrix m = manager.createMatrix(occurrencies_list);*/
		//debug
		//double[][] matrixData = {{1,2,0,0,0,1,0,0},{1,1,1,1,1,0,0,0},{0,1,3,1,0,0,0,0},{0,0,0,0,0,0,2,0},{0,0,0,0,0,1,1,2},{0,0,0,0,1,0,1,1}};
		double[][] matrixData = {{1,2,0,0,0,1,0,0,0,1},{1,1,1,1,1,0,0,0,0,0},{0,1,3,1,0,0,0,0,0,0},{0,0,0,0,0,0,2,0,1,1},{0,0,0,0,0,1,1,2,0,1},{0,0,0,0,1,0,1,1,0,1}};
		//double[][] matrixData = {{1,0,0,1,0,0,0,0,0},{1,0,1,0,0,0,0,0,0},{1,1,0,0,0,0,0,0,0},{0,1,1,0,1,0,0,0,0},{0,1,1,2,0,0,0,0,0},{0,1,0,0,1,0,0,0,0},{0,1,0,0,1,0,0,0,0},{0,0,1,1,0,0,0,0,0},{0,1,0,0,0,0,0,0,1},{0,0,0,0,0,1,1,1,0},{0,0,0,0,0,0,1,1,1},{0,0,0,0,0,0,0,1,1}};
		RealMatrix m = MatrixUtils.createRealMatrix(matrixData);
		
		System.out.println(m.getRowDimension());
		
		m = manager.cleanMatrix(m);

		m = lsa.algorithm(m);
		System.out.println(m);
		
		/*
		 * Similarità
		 */
		
		CosineSimilarity csm = new CosineSimilarity();
		m = csm.CS(m);
		
	}

}
