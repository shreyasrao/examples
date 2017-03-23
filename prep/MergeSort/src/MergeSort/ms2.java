package MergeSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// my attempt # 2 

public class ms2{
	
	private int[] array;
	private int[] temp;
	private int length;
	public long inversions;
	private boolean f = true;
	
	public void sort(int[] input){
		length = input.length;
		temp = new int[length];
		array = input;
		inversions = 0;
		
		mergesort(0,length-1);
		
	}
	
	private void mergesort(int low, int high){
		if(high > low ){
			int middle = low + (high - low) / 2;
			mergesort(low, middle);
			mergesort(middle + 1, high);
			merge(low,middle,high);
		}
	}
	
	private void merge(int low, int middle, int high){
		for(int i=low;i<=high;i++){ //why <=high here instead of just < ??
			temp[i] = array[i];
		}
		int k = low;
		int i = low;
		int j = middle + 1;
		
		while(i<=middle && j<=high){
			if(temp[i]<temp[j]){
				array[k] = temp[i];
				k++;
				i++;
			}
			else{
				array[k] = temp[j];
				inversions = inversions + (middle-i+1);
				
				
				
//				if(inversions < 0 && f){
//					System.out.println("WHAAAAAA: " + middle + " i:" + i + " inv: " + inversions);
//					f = false;
//				}
//				if(f){
//					System.out.println("ok : " + inversions);
//				}
				
				j++;
				k++;
				
			}
		}
		
		while(i<=middle){
			array[k] = temp[i];
			k++;
			i++;
		}
		
//		while(j<=high){
//			array[k] = temp[j];
//			j++;
//			k++;
//		}
			
		
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File("/Users/shreyas/Desktop/git-repo/shreyas/prep/MergeSort/src/MergeSort/input.txt"));
		int [] tall = new int [100000];
		int n = 0;
		while(scanner.hasNextInt()){
		   tall[n++] = scanner.nextInt();
		}
		
		
		System.out.println("HELLO");
//		int[] inputArr = {23 ,11 ,45 ,77 ,89 ,4 ,28 ,65 ,43 ,98};
//		int[] inputArr = {3 ,4, 6, 1, 2, 5};
		int[] inputArr = tall;
		ms2 ms = new ms2();
		ms.sort(inputArr);
//		for(int i:inputArr){
//	    	System.out.print(i);
//	    	System.out.print(" ");
//		}
		System.out.print("\n");
		System.out.println("Number of inversions is: " + ms.inversions);
		
		scanner.close();
	}
	
}