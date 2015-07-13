package Sort;

import java.util.Arrays;
import java.util.Random;

import javax.xml.transform.Templates;

public class SortTestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		BubbleSrot(nums1);
		System.out.println(Arrays.toString(nums1));
		
		int[] nums2 = {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		SelectionSort(nums2);
		System.out.println(Arrays.toString(nums2));
		
		int[] nums3 = {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		InsertionSort(nums3);
		System.out.println(Arrays.toString(nums3));
		
		int[] nums4 = {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		QuickSort(nums4, 0, nums4.length - 1);
		System.out.println(Arrays.toString(nums4));
		
		int[] nums5 = {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		MergeSort(nums5, 0, nums5.length - 1);
		System.out.println(Arrays.toString(nums5));
		
		int[] nums6 = {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		
		int[] nums7 = {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		
	}
	
	//冒泡排序
	public static void BubbleSrot(int[] nums){
		if(nums == null || nums.length <= 0){
			return;
		}
		int i,j;
		for(i = 0; i < nums.length; i++){
			for(j = 0; j < nums.length - i - 1; j++){
				if(nums[j] > nums[j+1]){
					swap(nums, j, j + 1);
				}
			}
		}
	}
	
	
	//选择排序
	public static void SelectionSort(int[] nums){
		if(nums == null || nums.length <= 0){
			return;
		}
		
		int i,j,max;
		for(i = 0; i < nums.length; i++){
			max = 0;
			for(j = 1; j < nums.length - i; j++){
				if(nums[j] > nums[max]){
					max = j;
				}
			}
			//将max和每一趟的最后一个交换
			swap(nums, max, j - 1);
		}
	}
	
	//插入排序，认为前面是有序的
	public static void InsertionSort(int[] nums){
		if(nums == null || nums.length <= 0){
			return;
		}
		int i,j,tmp;
		for(i = 1; i < nums.length; i++){
			tmp = nums[i];
			//寻找插入位置，并移动
			for(j = i - 1; j >= 0 && nums[j] > tmp; j--){
				nums[j+1] = nums[j];
			}
			//移动之后，空出一个位置为tmp
			nums[j+1] = tmp;
		}
	}
	
	//快速排序
	public static void QuickSort(int[] nums, int l, int r){
		if(l < r){
			int mid = Partition(nums, l, r);
			QuickSort(nums, l, mid - 1);//再对左侧进行快速排序
			QuickSort(nums, mid + 1, r);//再对右侧进行快速排序
		}
	}
	
	public static int Partition(int[] nums, int l, int r){
		if(nums == null || nums.length <= 0 || l < 0 || r >= nums.length){
			throw new RuntimeException("输入错误！");
		}		

		int tmp = nums[l];//数组的第一个作为中轴 
		while(l < r){
			while((l < r) && (nums[r] >= tmp))
				r--;
			nums[l] = nums[r];
			while((l < r) && (nums[l] <= tmp))
				l++;
			nums[r] = nums[l];
		}
		//此时l=r，这个位置也是tmp的位置
		nums[l] = tmp;
		return l;
	}
	
	//归并排序 O(n*logn)
	public static void MergeSort(int[] nums, int l, int r){
		if(l < r){
			int mid = (r + l) / 2;
			MergeSort(nums, l, mid);
			MergeSort(nums, mid + 1, r);
			Merge(nums, l, mid, r);
		}
	}
	
	public static void Merge(int[] nums, int l, int mid, int r){
		int[] tmp = new int[r - l + 1];//创建一个临时数组
		int i = l;//负责数组左侧
		int j = mid + 1;//负责数组右侧
		int k = 0;//负责新数组
		while(i <= mid && j <= r){
			if(nums[i] < nums[j]){
				tmp[k++] = nums[i++];
			}else{
				tmp[k++] = nums[j++];
			}
		}
		
		while(i <= mid){
			tmp[k++] = nums[i++];
		}
		
		while(j <= r){
			tmp[k++] = nums[j++];
		}
		
		//将临时数组的值覆盖原数组，注意，不是从0开始，是从l开始
		for(i = 0; i < tmp.length; i++){
			nums[i + l] = tmp[i];
		}
	}
	
	public static void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
