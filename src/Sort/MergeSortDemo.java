package Sort;

import java.util.Arrays;

/*
 * 归并排序：归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
 * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 *	时间复杂度至少为O(n)
 *	1.合并两个有序数组：
 *		这个非常简单，只要从比较二个数列的第一个数，谁小就先取谁，取了后就在对应数列中删除这个数。
 *		然后再进行比较，如果有数列为空，那直接将另一个数列的数据依次取出即可。
 *	2.归并排序：将数组分成二组A，B，如果这二组组内的数据都是有序的，那么就可以很方便的将这二组数据进行排序。
 *		如何让这二组组内数据有序了？
 *		可以将A，B组各自再分成二组。依次类推，当分出来的小组只有一个数据时，可以认为这个小组组内已经达到了有序，
 *		然后再合并相邻的二个小组就可以了。这样通过先递归的分解数列，再合并数列就完成了归并排序。
 *
 *	归并排序的效率是比较高的，设数列长为N，将数列分开成小数列一共要logN步，每步都是一个合并有序数列的过程，
 *	时间复杂度可以记为O(N)，故一共为O(N*logN)。因为归并排序每次都是在相邻的数据中进行操作，所以归并排序在O(N*logN)
 *	的几种排序方法（快速排序，归并排序，希尔排序，堆排序）也是效率比较高的。
 */
public class MergeSortDemo {
	public static void main(String[] args){
		int[] data = {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		mergeSort(data, 0, data.length-1);
		System.out.println(Arrays.toString(data));
	}
	
	/*
	 * 	合并两个有序序列：data[low~mid],data[mid~high]
	 */
	public static void merge(int[] data, int low, int mid, int high){
		int[] tmp = new int[high - low + 1];
		int i = low;//左指针，负责low~mid这边的数组
		int j = mid + 1;//右指针，负责mid+1~high这边的数组
		int k = 0;//负责新数组

		System.out.println("left side : ");
		for(int m = low; m <= mid; m++){
			System.out.print(data[m] + " ");
		}
		System.out.println();
		System.out.println("right side : ");
		for(int m = mid + 1; m <= high; m++){
			System.out.print(data[m] + " ");
		}
		System.out.println();
		//先将两个序列中较小的数移到临时数组
		while(i <= mid && j <= high){
			if(data[i] < data[j])
			{
				tmp[k] = data[i];
				i++;
				k++;
			}else{
				tmp[k++] = data[j++];
			}
		}
		
		//将左边剩余的数移到临时数组
		while(i <= mid){
			tmp[k++] = data[i++];
		}
		
		//将右边剩余的数移到临时数组
		while(j <= high){
			tmp[k++] = data[j++];
		}
		
		//将临时数组的值覆盖原数组，注意，不是从0开始，是从low开始
		for(int m = 0; m < tmp.length; m++){
			data[m + low] = tmp[m];
		}
	}
	public static void mergeSort(int[] data, int low, int high){
		int mid = (low + high) / 2;
		if(low < high){
			//左边
			mergeSort(data, low, mid);
			//右边
			mergeSort(data, mid + 1, high);
//			//将完成排序的左右归并
			merge(data, low, mid, high);
		}
	}
}

