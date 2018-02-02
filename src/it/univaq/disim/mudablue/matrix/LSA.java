package it.univaq.disim.mudablue.matrix;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularValueDecomposition;

public class LSA {

	public RealMatrix algorithm (RealMatrix m)
	{
		/*
		 * taken as input the term-matrix, returns a new matrix after SVD and LSA algorithm
		 * procedure, ready for cosine similarity.
		 */
		/*
		RealMatrix mFinal = MatrixUtils.createRealMatrix(m.getRowDimension(), m.getColumnDimension());
		
		SingularValueDecomposition svd = new SingularValueDecomposition(m);
		
		RealMatrix U = svd.getU();
		RealMatrix S = svd.getS();
		RealMatrix Vt = svd.getVT();
		
		System.out.println(U);
		System.out.println(S);
		System.out.println(Vt);

		RealMatrix Saux =  MatrixUtils.createRealMatrix(S.getRowDimension(), S.getColumnDimension());
		RealMatrix Uaux =  MatrixUtils.createRealMatrix(U.getRowDimension(), U.getColumnDimension());
		RealMatrix Vtaux =  MatrixUtils.createRealMatrix(Vt.getRowDimension(), Vt.getColumnDimension());
		
		Saux.setColumnMatrix(0, S.getColumnMatrix(0));
		Saux.setColumnMatrix(1, S.getColumnMatrix(1));
		
		Uaux.setColumnMatrix(0, U.getColumnMatrix(0));
		Vtaux.setColumnMatrix(0, Vt.getColumnMatrix(0));
		Uaux.setColumnMatrix(1, U.getColumnMatrix(1));
		Vtaux.setColumnMatrix(1, Vt.getColumnMatrix(1));
		
		mFinal.setColumnMatrix(0, Uaux.multiply(Saux.multiply(Vtaux)).getColumnMatrix(0));
		mFinal.setColumnMatrix(1, Uaux.multiply(Saux.multiply(Vtaux)).getColumnMatrix(1));
		
		
		for(int i=2; i<m.getColumnDimension(); i = i+1)
		{
				
				if(i<Uaux.getColumnDimension())
				{
					Uaux.setColumnMatrix(i, U.getColumnMatrix(i));
				}
				
				if(i<Vtaux.getColumnDimension())
				{
					Vtaux.setColumnMatrix(i, Vt.getColumnMatrix(i));
				}
				
				mFinal.setColumnMatrix(i, Uaux.multiply(Saux.multiply(Vtaux)).getColumnMatrix(i));	
		}

		return mFinal;*/
		
		RealMatrix mFinal = MatrixUtils.createRealMatrix(m.getRowDimension(), m.getColumnDimension());
		
		SingularValueDecomposition svd = new SingularValueDecomposition(m);
		
		RealMatrix U = svd.getU();
		RealMatrix S = svd.getS();
		RealMatrix Vt = svd.getVT();
		
		RealMatrix Saux =  MatrixUtils.createRealMatrix(S.getRowDimension(), S.getColumnDimension());
		RealMatrix Uaux =  MatrixUtils.createRealMatrix(U.getRowDimension(), U.getColumnDimension());
		RealMatrix Vtaux =  MatrixUtils.createRealMatrix(Vt.getRowDimension(), Vt.getColumnDimension());
		
		Saux.setRowMatrix(0, S.getRowMatrix(0));
		Saux.setRowMatrix(1, S.getRowMatrix(1));
		
		Uaux.setRowMatrix(0, U.getRowMatrix(0));
		Vtaux.setRowMatrix(0, Vt.getRowMatrix(0));
		Uaux.setRowMatrix(1, U.getRowMatrix(1));
		Vtaux.setRowMatrix(1, Vt.getRowMatrix(1));
		
		mFinal.setRowMatrix(0, Uaux.multiply(Saux.multiply(Vtaux)).getRowMatrix(0));
		mFinal.setRowMatrix(1, Uaux.multiply(Saux.multiply(Vtaux)).getRowMatrix(1));
		
		
		//for(int i=2; i<m.getRowDimension(); i = i+1)
		for(int i=2; i<=50; i = i+1) //testare con i = 300
		{
				
				if(i<Uaux.getRowDimension())
				{
					Uaux.setRowMatrix(i, U.getRowMatrix(i));
				}
				
				if(i<Vtaux.getRowDimension())
				{
					Vtaux.setRowMatrix(i, Vt.getRowMatrix(i));
				}
				
				if(i<Saux.getRowDimension())
				{
					Saux.setRowMatrix(i, S.getRowMatrix(i));
				}
				
				
				mFinal.setRowMatrix(i, Uaux.multiply(Saux.multiply(Vtaux)).getRowMatrix(i));	
		}

		return mFinal;
	}
	
}
