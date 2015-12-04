You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] b = transform1(matrix,n);
        int[][] c= transform2(b,n);
    }
    public static int[][] transform1(int[][] matrix, int n){
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
//				swap(matrix[i][j], matrix[j][i]);
				
				int temp;
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
				
			}
		}
		return matrix;
	}
	public static int[][] transform2(int[][] matrix, int n){
		for(int j=0; j<n/2; j++){
			for(int i=0; i<n; i++){
//			swap(matrix[i][j],matrix[n-1-i][j]);
				int temp;
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][n-1-j];
				matrix[i][n-1-j] = temp;
		}
		}
		return matrix;
	}
	public static void swap(int a, int b){
		int temp =a;
		b=a;
		a=temp;
	}
}
