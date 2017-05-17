package by.epam.course.basic.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class GetMatrix {
	
	public Integer[][] matrixA ;
	public Integer[][] matrixB ;
	public GetMatrix() {
		matrixA = null;
		matrixB = null;
		getMatrixes();
	}
	private void getMatrixes(){
		String fileA = "MatrixA.txt";
		String fileB = "MatrixB.txt";
		File fileMatrixA = new File (fileA);
		File fileMatrixB = new File (fileB);
		FileReader fr = null;
		Scanner sc = null;
		Integer[] intLine;
		String stringLine;
		String strArr[];
		int index = 0;
		try {
			fr = new FileReader(fileMatrixA);
			sc = new Scanner(fr);
			
			while (sc.hasNextLine()){
				stringLine = sc.nextLine();
				strArr = stringLine.split(" ");
				intLine = new Integer[strArr.length];
				for (int i = 0; i < strArr.length; i++) {
					intLine[i] = Integer.parseInt(strArr[i]);					
				}
				if (matrixA == null){
					matrixA = new Integer[intLine.length][intLine.length];
				}
				matrixA[index] = intLine;
				index++;
			}
			
			sc.close();//?????
		} catch (FileNotFoundException e) {
			e.printStackTrace();// выучили одно, забыли про все остальное)
			// на логику кода посмотри
			// захомячил исключение и дальше выполняешь код как ни в чем не бывало!!!
		} finally {
			sc.close();//?????
		}
		
		index = 0;
		try {
			fr = new FileReader(fileMatrixB);
			sc = new Scanner(fr);
			
			while (sc.hasNextLine()){
				stringLine = sc.nextLine();
				strArr = stringLine.split(" ");
				intLine = new Integer[strArr.length];
				for (int i = 0; i < strArr.length; i++) {
					intLine[i] = Integer.parseInt(strArr[i]);					
				}
				if (matrixB == null){
					matrixB = new Integer[intLine.length][intLine.length];
				}
				matrixB[index] = intLine;
				index++;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
	
	public Integer[][] getMatrixA(){
		return matrixA;
	}
	
	public Integer[][] getMatrixB(){
		return matrixB;
	}
	
	
}
