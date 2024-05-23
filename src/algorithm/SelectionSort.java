package algorithm;

import java.util.Arrays;

public class SelectionSort {

	static void selectionSort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i; j<arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}		
	}

	public static void main(String[] args) {
		int[] arr = {30, 67, 55, 79, 97, 65, 33, 78, 96, 58, 94, 32};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
}
