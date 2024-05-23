package algorithm;

import java.util.Arrays;

public class BubbleSort {

	static void bubbleSort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}		
	}

	public static void main(String[] args) {
		int[] arr = {30, 67, 55, 79, 97, 65, 33, 78, 96, 58, 94, 32};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
}
