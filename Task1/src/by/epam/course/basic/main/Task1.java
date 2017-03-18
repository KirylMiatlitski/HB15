package by.epam.course.basic.main;

import java.util.ArrayList;

/**
 * @author Kiryl_Miatlitski
 *
 * Date: 18 March 2017
 * 
 * Task: Необходимо разработать многопоточное приложение, позволяющее перемножать 
 * квадратные матрицы одного (любого) порядка. При необходимости для синхронизации 
 * использовать только инструменты, доступные в версии Java 1.4.
 * Приведите решение задачи, когда количество дочерних потоков не ограничено.
 */
public class Task1 {
	public static Integer[][] result = null;
	public static void main(String[] args) {
		GetMatrix getMatrix = new GetMatrix();
		Integer[][] matrixA = getMatrix.getMatrixA();
		Integer[][] matrixB = getMatrix.getMatrixB();
		ArrayList<MatrixThread> pool = new ArrayList<>();
		//showMatrix(matrixA);
		//showMatrix(matrixB);
		result = new Integer[matrixA.length][matrixA.length];
		for (int i = 0; i < matrixA.length; i++){
			for (int j = 0; j < matrixA.length; j++){
				pool.add(new  MatrixThread(matrixA, matrixB,i,j));
				pool.get(pool.size()-1).start();
			}
			
		}
		for (MatrixThread t : pool){
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		showMatrix(result);
	}
	
	public static void showMatrix(Integer[][] matrix){
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix.length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
