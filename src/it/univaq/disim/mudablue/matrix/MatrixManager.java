package it.univaq.disim.mudablue.matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import it.univaq.disim.mudablue.models.Repositories;
import it.univaq.disim.mudablue.scan.FolderNavigator;

public class MatrixManager {

	public RealMatrix createMatrix (ArrayList<ArrayList<Double>> occurrencies_list)
	{
		/*
		 * conversione nei formati real matrix
		 * dovremmo cercare un sistema più efficiente
		 */
		RealMatrix m = MatrixUtils.createRealMatrix(occurrencies_list.get(0).size(),occurrencies_list.size());

		int rowCounter=0;
		for(ArrayList elem : occurrencies_list)
		{
			RealVector vector = new ArrayRealVector(elem.size());
			for(int i=0; i<elem.size();i++)
			{
				vector.setEntry(i, (double) elem.get(i));
			}
			m.setColumnVector(rowCounter, vector);
			rowCounter++;
		}
		
		return m;
	}
	
	public ArrayList<ArrayList<Double>> createList(ArrayList<String> path_list) throws FileNotFoundException
	{
		Row row = new Row();
		Repositories repository_object = new Repositories();
		
		
		ArrayList<ArrayList<Double>> occurrencies_list = new ArrayList<ArrayList<Double>>();
		
		for(String repo : path_list)
		{
			
			File file = new File(repo);
			
	        
	        FolderNavigator magellano = new FolderNavigator();
			ArrayList<String> terms= new ArrayList<String>();
	        // questione terms
	        repository_object = magellano.Files_List(file, repository_object.getMain_list(), terms, repository_object);
	        
	        occurrencies_list.add(row.create_row(repository_object));
		}
		
		/* normalizzazione delle liste, per ogni lista
		 * più corta della più lunga, si aggiungono tanti 0
		 * quant'è la differenza di lunghezza in modo da avere
		 * una matrice quadrata alla fine
		 * */
		
		int max = 0;
		for(ArrayList elem : occurrencies_list)
		{
			if(max <= elem.size())
			{
				max = elem.size();
			}
			
		}
				
		for(ArrayList elem : occurrencies_list)
		{
			for(int i=elem.size(); i<max;i++)
			{
				elem.add(0.0);
			}
		}
		
		return occurrencies_list;
	}

	public RealMatrix cleanMatrix(RealMatrix m){
		
		/*
		 * prendiamo la matrice realmatrix termini-documenti ed eliminiamo alcune colonne secondo questo principio:
		 * se un termine appare in una sola repository lo eliminiamo oppure se appare in più della metà delle repository
		 */
		
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		for(int i=0; i<m.getRowDimension(); i++)
		{
			RealVector row = m.getRowVector(i);
			
			int counter = 0;
			boolean remove = false;
			
			for(int j=0; j<row.getDimension(); j++)
			{
				if(row.getEntry(j)!=0.0)
				{
					counter += 1;
				}
			}
			
			if(counter==1)
			{
				remove=true;
				//System.out.println("removeLB");
			}
			
			if(counter>row.getDimension()/2) //occhio qui, fallirà sempre se gli passi meno di 4 repository
			{
				remove=true;
				//System.out.println("removeUB");
			}
			
			if(remove==false)
			{
				results.add(i);
			}
			
		}
		
		RealMatrix mFinal = MatrixUtils.createRealMatrix(results.size(),m.getColumnDimension());
		int j=0;
		for(int i=0; i<m.getRowDimension(); i++)
		{
			if(results.contains(i))
			{
				mFinal.setRowMatrix(j, m.getRowMatrix(results.get(j)));
				j += 1;
			}
			
		}
		
		return mFinal;
	}
}
