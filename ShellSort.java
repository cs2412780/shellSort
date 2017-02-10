package shellSort;

import java.util.Random;

import lab1.ArrayBag;

public class ShellSort {

	static int n = 0;
	static int m = 0;
	public static void main(String[] args) {
		
		ArrayBag<Integer> a1 = new ArrayBag<>(1000);
		ArrayBag<Integer> a2 = new ArrayBag<>(1000);

		Random r = new Random();
		int[] array =new int[1000];
		boolean pass = true;
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(1000);
			a1.add(array[i]);
			//System.out.println(array[i]);
		}
		
		System.out.println("shellSortByIteration: ");
		shellSortByIteration(array);
		for(int i = 0; i < array.length; i++) {
			a2.add(array[i]);
			//System.out.println(array[i]);
		}
		
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i + 1]) {
				System.out.println("*****Failed");
				pass = false;
				break;
			}
		}
		
		if(a1.equals(a2) && pass) {
			System.out.println("Sorted.");
		}
		System.out.println();
		
		a1.clear();
		a2.clear();
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(1000);
			a1.add(array[i]);
			//System.out.println(array[i]);
		}
		System.out.println("shellSortByRecursion: ");
		//long starttimes = System.nanoTime();
		shellSortByRecursion(array);
		//long endtimes = System.nanoTime();
		
		//long  b = (endtimes - starttimes) / 1000000;
		//System.out.println(b);
		for(int i = 0; i < array.length; i++) {
			a2.add(array[i]);
			//System.out.println(array[i]);
		}
		pass = true;
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i + 1]) {
				System.out.println("*****Failed");
				pass = false;
				break;
			}
		}
		if(a1.equals(a2) && pass) {
			System.out.println("Sorted.");
		}
		//System.out.println("n: " + n);
		//System.out.println("m: " + m);
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
				array[indexWhenSwap] = array[indexWhenSwap + 1];
				array[indexWhenSwap + 1] = temp;
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
		traversalElements(array, k, 0);	
	}//end shellSortByRecursion
	
	private static void traversalElements(int[] array, int k, int index) {
		//System.out.println(index);
		if(k >= 1 && (index + k) < array.length) {
			compareElements(array, k, index);
			traversalElements(array, k, index + 1);
		}
		else if(k > 1 && (index + k) >= array.length) {
			traversalElements(array, k / 2, 0);
		}
	}//end traversalElements
	
	private static void compareElements(int[] array, int k, int index) {
		
		if(index >= 0 && array[index] > array[index + k]) {
			
			int temp = array[index];
			array[index] = array[index + k];
			array[index + k] = temp;
			compareElements(array, k, index - k);
		}
		
	}//end swapElements

}
