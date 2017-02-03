package shellSort;

import java.util.Random;

public class ShellSort {

	public static void main(String[] args) {
		Random r = new Random();
		int[] array =new int[10];
		
		
		System.out.println("random integers: ");
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(50);
		}
		for(int i = 0; i < array.length; i++) {
			 System.out.println(array[i]);
		}
		System.out.println("shellSortByIteration: ");
		shellSortByIteration(array);
		for(int i = 0; i < array.length; i++) {
			 System.out.println(array[i]);
		}
		
		
		System.out.println("random integers: ");
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(50);
		}
		for(int i = 0; i < array.length; i++) {
			 System.out.println(array[i]);
		}
		System.out.println("shellSortByRecursion: ");
		shellSortByRecursion(array);
		for(int i = 0; i < array.length; i++) {
			 System.out.println(array[i]);
		}

	}
	
	public static void shellSortByIteration(int[] array) {
		int k = 1;
		int index = 0;
		int indexWhenSwap = 0;
		while((2 * k + 1) < array.length) {
			k = 2 * k + 1;
		}
		while(k > 0) {
			indexWhenSwap = index;
			while((indexWhenSwap >= 0) 
					&& ((indexWhenSwap + k) < array.length) 
					&& (array[indexWhenSwap] > array[indexWhenSwap + k])) {
				
				int temp = array[indexWhenSwap];
				array[indexWhenSwap] = array[indexWhenSwap + k];
				array[indexWhenSwap + k] = temp;
				indexWhenSwap -= k;
			}//end nested while
			index++;
			if((index + k) >= array.length) {
				k = k / 2;
				index = 0;
			}
		}//end while
	}//end shellSortByIteration
	
	public static void shellSortByRecursion(int[] array) {
		int k = 1;
		while((2 * k + 1) < array.length) {
			k = 2 * k + 1;
		}
		traversalElements(array,k,0);	
	}//end shellSortByRecursion
	
	private static void traversalElements(int[] array, int k, int index) {
		if(k > 0) {
			if ((index + k) < array.length) {
				swapElements(array, k, index);
				traversalElements(array, k, index + 1);
			}
			else {
				traversalElements(array, k / 2, 0);
			}
			
		}
		
	}//end traversalElements
	
	private static void swapElements(int[] array, int k, int index) {
		
		if(index >= 0 && array[index] > array[index + k]) {
			int temp = array[index];
			array[index] = array[index + k];
			array[index + k] = temp;
			swapElements(array, k, index - k);
		}
		
	}//end swapElements

}
