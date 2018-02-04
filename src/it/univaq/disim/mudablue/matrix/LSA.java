package it.univaq.disim.mudablue.matrix;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularValueDecomposition;

public class LSA {

	public RealMatrix algorithm (RealMatrix m)
	{
		
		RealMatrix mFinal = MatrixUtils.createRealMatrix(m.getRowDimension(), m.getColumnDimension());
		
		SingularValueDecomposition svd = new SingularValueDecomposition(m);
		
		RealMatrix U = svd.getU();
		RealMatrix S = svd.getS();
		RealMatrix Vt = svd.getVT();
		
		RealMatrix Saux =  MatrixUtils.createRealMatrix(S.getRowDimension(), S.getColumnDimension());
		RealMatrix Uaux =  MatrixUtils.createRealMatrix(U.getRowDimension(), U.getColumnDimension());
		RealMatrix Vtaux =  MatrixUtils.createRealMatrix(Vt.getRowDimension(), Vt.getColumnDimension());
		
		/*Saux.setRowMatrix(0, S.getRowMatrix(0));
		Saux.setRowMatrix(1, S.getRowMatrix(1));
		
		Uaux.setRowMatrix(0, U.getRowMatrix(0));
		Vtaux.setRowMatrix(0, Vt.getRowMatrix(0));
		Uaux.setRowMatrix(1, U.getRowMatrix(1));
		Vtaux.setRowMatrix(1, Vt.getRowMatrix(1));
		
		mFinal.setRowMatrix(0, Uaux.multiply(Saux.multiply(Vtaux)).getRowMatrix(0));
		mFinal.setRowMatrix(1, Uaux.multiply(Saux.multiply(Vtaux)).getRowMatrix(1));*/
		
		
		//for(int i=2; i<m.getRowDimension(); i = i+1)
		
		int value=300;
		if(m.getRowDimension()<value)
		{
			value = m.getRowDimension();
		}
		
		for(int i=0; i<=value; i = i+1)
		{
				
				if(i<Uaux.getColumnDimension())
				{
					Uaux.setColumnMatrix(i, U.getColumnMatrix(i));
				}
				
				if(i<Vtaux.getRowDimension())
				{
					Vtaux.setRowMatrix(i, Vt.getRowMatrix(i));
				}
				
				if(i<Saux.getRowDimension())
				{
					Saux.setRowMatrix(i, S.getRowMatrix(i));
				}
		}
		
		mFinal = Uaux.multiply(Saux.multiply(Vtaux));
		

		return mFinal;
	}
	
}
