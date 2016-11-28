package br.facisa.p3.ed.fileHandling;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class File {
	
	public static int[] getTextTxt(String in) throws IOException{
		 
		InputStream aux = new FileInputStream(in);
	    InputStreamReader aux2 = new InputStreamReader(aux);
	    BufferedReader aux3 = new BufferedReader(aux2);
	    String text = aux3.readLine();
	    String[] array = text.split(" ");
	    int[] array2 = new int[array.length];
	    for (int i = 0; i < array.length; i++){
	    	array2[i] = Integer.parseInt(array[i]);
	    }
	    return array2;
	}

}
