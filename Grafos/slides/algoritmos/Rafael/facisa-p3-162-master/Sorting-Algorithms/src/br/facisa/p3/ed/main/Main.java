package br.facisa.p3.ed.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.facisa.p3.ed.fileHandling.File;
import br.facisa.p3.ed.sortingAlgorithms.BubbleSort;
import br.facisa.p3.ed.sortingAlgorithms.QuickSort;
import br.facisa.p3.ed.sortingAlgorithms.RadixSort;

public class Main {
	public static void main(String[] args) throws IOException,FileNotFoundException {
		int[] array;
		String file = "./txt/in.txt";
		try{
			array = File.getTextTxt(file);
		}catch(FileNotFoundException e){
			file = "//txt//in.txt";
		}finally{
		
			System.out.println("unordered list:");
			array = File.getTextTxt(file);
			for (int x: array){
				System.out.print(x + " ");
			}
			System.out.println("\n");
			System.out.println("Bubble Sort");
			BubbleSort.sort(array);
			for (int x: array){
				System.out.print(x + " ");
			}
			
			array = File.getTextTxt(file);
			System.out.println("\n");
			System.out.println("Quick Sort");
			QuickSort.sort(array, 0, array.length-1);
			for (int x: array){
				System.out.print(x + " ");
			}
			array = File.getTextTxt(file);
			System.out.println("\n");
			System.out.println("Radix Sort");
			RadixSort.sort(array);
			for (int x: array){
				System.out.print(x + " ");
	
			}
		}
	}
}
