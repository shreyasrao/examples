package QuickSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//import MergeSort.ms2;

public class QuickSort{
	
	public int comparisons=0;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(new File("/Users/shreyas/Desktop/git-repo/shreyas/prep/MergeSort/src/MergeSort/input.txt"));
		int [] x = new int [10];
		int n = 0;
		while(scanner.hasNextInt()){
		   x[n++] = scanner.nextInt();
		}
		
//		int[] x = { 9, 2, 4, 7, 3, 7, 10 };
//		System.out.println(Arrays.toString(x));
		
//		int chck = 4 + (7-4)/2;
//		int[] a = {3,1,2};
//		Arrays.sort(a);
//		int chck = a[1];
//		System.out.println("chck is " + chck);
		int low = 0;
		int high = x.length - 1;
		QuickSort qs = new QuickSort();
//		qs.comparisons = 0;
		qs.quickSort(x, low, high);
//		System.out.println(Arrays.toString(x));
		System.out.println("Number of Compars is " + qs.comparisons);
	}
 
	public void quickSort(int[] arr, int low, int high) {
		
		
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		//add number of comparisions
		comparisons = comparisons + high - low - 1;
		
		// pick the pivot
		
		//original code copy
		int middle = (high + low) / 2;
		
		int[] a = {middle,low,high};
		Arrays.sort(a);
		
		int index = a[1];
		
		int pivot = arr[index];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}
	
//	public static void main(String[] args) throws FileNotFoundException{
//		
//		Scanner scanner = new Scanner(new File("//dUsers/shreyas/Desktop/git-repo/shreyas/prep/MergeSort/src/MergeSort/input.txt"));
//		int [] tall = new int [100000];
//		int n = 0;
//		while(scanner.hasNextInt()){
//		   tall[n++] = scanner.nextInt();
//		}
//		
//		
//		System.out.println("HELLO");
////		int[] inputArr = {23 ,11 ,45 ,77 ,89 ,4 ,28 ,65 ,43 ,98};
////		int[] inputArr = {3 ,4, 6, 1, 2, 5};
//		int[] inputArr = tall;
////		ms2 ms = new ms2();
////		ms.sort(inputArr);
////		for(int i:inputArr){
////	    	System.out.print(i);
////	    	System.out.print(" ");
////		}
////		System.out.print("\n");
////		System.out.println("Number of inversions is: " + ms.inversions);
////		
//		scanner.close();
//	}
	
}