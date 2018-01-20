package it.univaq.disim.mudablue.matrix;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.SingularValueDecomposition;

public class graziegesu {

	public static void main(String[] args) {
		
		//double[][] matrixData = { {1,0,0,1,0,0,0,0,0}, {1,0,1,0,0,0,0,0,0}, {1,1,0,0,0,0,0,0,0}, {0,1,1,0,1,0,0,0,0},{0,1,1,2,0,0,0,0,0}, {0,1,0,0,1,0,0,0,0}, {0,1,0,0,1,0,0,0,0}, {0,0,1,1,0,0,0,0,0},{0,1,0,0,0,0,0,0,1}, {0,0,0,0,0,1,1,1,0}, {0,0,0,0,0,0,1,1,1}, {0,0,0,0,0,0,0,1,1}};
		double[][] matrixData = {{1,2,0,0,0,1,0,0},{1,1,1,1,1,0,0,0},{0,1,3,1,0,0,0,0},{0,0,0,0,0,0,2,0},{0,0,0,0,0,1,1,2},{0,0,0,0,1,0,1,1}};
		RealMatrix m = MatrixUtils.createRealMatrix(matrixData);
		RealMatrix mFinal = MatrixUtils.createRealMatrix(m.getRowDimension(), m.getColumnDimension());
		
		SingularValueDecomposition svd = new SingularValueDecomposition(m);
		
		RealMatrix U = svd.getU();
		RealMatrix S = svd.getS();
		RealMatrix Vt = svd.getVT();
		System.out.println(m.getRowDimension());
		System.out.println(m.getColumnDimension());

		
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

		
		for(int i=0; i<mFinal.getRowDimension(); i++)
		{
			System.out.println(mFinal.getRowMatrix(i));
		}
		
		
		/*
		 * riga iniz, riga fin, colonna iniz, colonna fin
		 */
		
	}

}
