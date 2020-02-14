package theCodingInterview1;

import CtCILibrary.*;

public class Question8 {
	
	public static void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] col = new boolean[matrix[0].length];
		
		for(int i=0 ; i<matrix.length ; i++) {
			for(int j=0 ; j<matrix[0].length ; j++) {
				if(matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		for(int i=0 ; i<matrix.length ; i++) {
			if(row[i] == true) {
				for(int j=0 ; j<matrix[0].length ; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for(int i=0 ; i<matrix[0].length ; i++) {
			if(col[i] == true) {
				for(int j=0 ; j<matrix.length ; j++) {
					matrix[j][i] = 0;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		int nrows = 5;
		int ncols = 7;
		int[][] matrix = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);		

		AssortedMethods.printMatrix(matrix);
		
		setZeros(matrix);
		
		System.out.println();
		
		AssortedMethods.printMatrix(matrix);
	}
}
