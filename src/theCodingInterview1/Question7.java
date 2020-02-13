package theCodingInterview1;

public class Question7 {
	
	public static int[][] randomMatrix(int M, int N, int min, int max) {
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = randomIntInRange(min, max);
			}
		}
		return matrix;
	}
	
	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] < 10 && matrix[i][j] > -10) {
					System.out.print(" ");
				}
				if (matrix[i][j] < 100 && matrix[i][j] > -100) {
					System.out.print(" ");
				}
				if (matrix[i][j] >= 0) {
					System.out.print(" ");
				}
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public static boolean rotate(int[][] matrix) {
		int n = matrix.length;
		
		for(int i=0 ; i<n/2 ; i++) {
			int first = i;
			int last = n - 1 - i;
			for(int j=first ; j<last ; j++) {
				int offset = j - first;
				int tmp = matrix[first][j];
				
				matrix[first][j] = matrix[last-offset][first];
				
				matrix[last-offset][first] = matrix[last][last-offset];
				
				matrix[last][last-offset] = matrix[j][last];
				
				matrix[j][last] = tmp;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int[][] matrix = randomMatrix(5, 5, 0, 9);
		printMatrix(matrix);
		rotate(matrix);
		System.out.println();
		printMatrix(matrix);
	}
}
