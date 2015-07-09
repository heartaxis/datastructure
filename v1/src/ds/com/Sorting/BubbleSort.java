package ds.com.Sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[]={2,5,1,9,4};
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
