package by.epam.course.basic.main;

public class MatrixThread extends Thread{
	private Integer[][] matrixA;
	private Integer[][] matrixB;
	private int index1;
	private int index2;
	
	public MatrixThread(Integer[][] matrixA, Integer[][] matrixB, int k1, int k2) {
		this.matrixA = matrixA;
		this.matrixB = matrixB;
		index1 = k1;
		index2 = k2;
		
	}
	
	public void run(){
		Thread t = Thread.currentThread();
		t.setName("Поток "+ index1 + ":" + index2);
		Integer result = 0;
		for (int i = 0; i < matrixA.length; i++){
			result = result + matrixA[index1][i] * matrixB[i][index2];
		
			
		}
		System.out.println(" Finded result for [" + index1 + "][" + index2	 + "] = " + result);
		Task1.result[index1][index2] = result;
		System.out.println("                                       set to result [" + index1 + "][" + index2	 + "]");
		    
	}

}
