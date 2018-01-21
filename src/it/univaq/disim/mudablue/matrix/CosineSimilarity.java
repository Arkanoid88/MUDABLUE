package it.univaq.disim.mudablue.matrix;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import java.lang.Math;

public class CosineSimilarity {
	
	public double sum(RealVector vect1, RealVector vect2)
	{
		double result = 0;
		
		for(int i=0; i<vect1.getDimension(); i++)
		{
			result += vect1.getEntry(i)*vect2.getEntry(i);
		}
		
		return result;
	}
	
	public double sumPower(RealVector vect)
	{
		double result = 0;
		
		for(int i=0; i<vect.getDimension(); i++)
		{
			result += vect.getEntry(i)*vect.getEntry(i);
		}
		
		return result;
	}
	
	public double Similarity(RealVector vect1, RealVector vect2)
	{
		/*
		 * apply the cosine formula
		 */
		
		
		double num = sum(vect1,vect2);
		double sumApower = sumPower(vect1);
		double sumBpower = sumPower(vect2);
		
		double result = (num)/(Math.sqrt(sumApower)*Math.sqrt(sumBpower));
		
		return result;
	}
	
	/*public RealMatrix CS(RealMatrix m)
	{
		/*
		 * creation of the similarity matrix
		 */
		/*
		RealMatrix mFinal = MatrixUtils.createRealMatrix(m.getRowDimension(), m.getRowDimension());
		
		for(int i=0;i<mFinal.getColumnDimension(); i++)
		{
			for(int j=0; j<mFinal.getRowDimension(); j++)
			{
				double simil = Similarity(m.getRowVector(i),m.getRowVector(j));
				mFinal.setEntry(i, j, simil);
			}
		}
		
		return mFinal;
	}*/
	
	public RealMatrix CS(RealMatrix m)
	{
		/*
		 * creation of the similarity matrix
		 */
		
		RealMatrix mFinal = MatrixUtils.createRealMatrix(m.getColumnDimension(), m.getColumnDimension());
		
		for(int i=0; i<m.getColumnDimension(); i++)
		{
			for(int j=0; j<m.getColumnDimension(); j++)
			{

				if(j>=i) // triangolare superiore per fare la met� delle operazioni
				{
					double simil = Similarity(m.getColumnVector(i),m.getColumnVector(j));
					mFinal.setEntry(i, j, simil);
				}
				else 
				{
					mFinal.setEntry(i, j, mFinal.getEntry(j, i));
				}
			}
		}
		
		return mFinal;
	}

}
