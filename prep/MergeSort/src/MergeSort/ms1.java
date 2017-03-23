
// we have at least 2 items
// sort A[p..q]
// sort A[q+1..r]
// merge everything together
//￼         MergeSort(array A, int p, int r) {
//             if (p < r) {
//                 q = (p + r)/2
//                 MergeSort(A, p, q)
//                 MergeSort(A, q+1, r)
//                 Merge(A, p, q, r)
//} }

package MergeSort;
public class ms1{
	private int[] array;
	private int[] tempArr;
	private int length;
	
	public void sort(int inputArr[]){
		this.array = inputArr;
		this.length = inputArr.length;
		this.tempArr = new int[length];
		MergeSort(0,length-1);
	}
	
	
	public void MergeSort(int low, int high){
		if (low < high) {
			int middle = low + (high - low)/2;
			MergeSort(low,middle);
			MergeSort(middle+1,high);
			Merge(low,middle,high);
		}
	}
	
	public void Merge(int low, int middle, int high){
		//copy all elements into the temparr
		for(int i=low;i<=high;i++){
			tempArr[i] = array[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		while(i<=middle && j<=high){
			if(tempArr[i]<=tempArr[j]){
				array[k] = tempArr[i];
				i++;
			}
			else{
				array[k]=tempArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempArr[i];
			k++;
			i++;
		}
		
	}
	
	public static void main(String[] args){
		int a = (int) 0.00000001;
		System.out.println("Hello" + a);
		
//		int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
		int[] inputArr = {23 ,11 ,45 ,77 ,89 ,4 ,28 ,65 ,43 ,98};
		ms1 mms = new ms1();
		mms.sort(inputArr);
		for(int i:inputArr){
	    	System.out.print(i);
	    	System.out.print(" ");
		}
	
	}
	
}