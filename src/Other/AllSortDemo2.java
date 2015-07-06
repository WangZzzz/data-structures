package Other;

import java.util.Arrays;

/*
 * 	字符串数组全排列
 */
public class AllSortDemo2 {

	public static void main(String[] args){
		String[] arr = {"1","2","3"};
		AllSort(arr, 0, arr.length - 1);
	}
	
	public static void AllSort(String[] arr, int start, int end){
		if(start == end){
			printArr(arr);
		}else{
			for(int i = start; i <= end; i++){
				String tmp = arr[start];
				arr[start] = arr[i];
				arr[i] = tmp;
				
				AllSort(arr, start + 1, end);
				
				tmp = arr[start];
				arr[start] = arr[i];
				arr[i] = tmp;
			}
		}		
	}
	
	public static void printArr(String[] arr){
		String tmp = "";
		for(String str : arr){
			tmp += str;
		}
		System.out.println(tmp);
	}
}
