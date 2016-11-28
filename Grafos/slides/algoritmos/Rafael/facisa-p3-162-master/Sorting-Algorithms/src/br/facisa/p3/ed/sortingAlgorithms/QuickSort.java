package br.facisa.p3.ed.sortingAlgorithms;
/**
 * Class to sort array using Quick sort algorthm
 * @author Rafael
 *
 */
public class QuickSort{
	
	/**
	 * Method of sorting
	 * @param array
	 * @param first element array
	 * @param last element array
	 * @return sorted array
	 */
	public static void sort(int[] array, int first, int last){
		if (first < last){
			int head = division(array, first, last);
			sort (array, first, head-1);
			sort (array, head +1, last);
		}
	}
		
	private static int division(int[] array, int first, int last){
		int head = array[first];
		int i = first+1;
		int j = last;
		while (i <= j){
			if(array[i] <= head){
				i++;
			}else if (head < array[j]){
				j--;
			}else{
				int aux = array[i];
				array[i] = array[j];
				array[j] =  aux;
				i ++;
				j --;
			}
		}
		array[first] = array[j];
		array[j] = head;
		
		return j;
		
	}
}