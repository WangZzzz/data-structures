package Sort;

import java.util.Arrays;

import javax.sound.midi.MidiDevice;
import javax.xml.transform.Templates;

public class SortTestDemo2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		BubbleSort(nums1);
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
		HeapSort(nums6);
		System.out.println(Arrays.toString(nums6));
	}
	
	public static void BubbleSort(int[] nums){
		if(nums == null || nums.length <= 0){
			return;
		}
		int i, j;
		for(i = 0; i < nums.length; i++){
			for(j = 1; j < nums.length - i; j++){
				if(nums[j - 1] > nums[j]){
					swap(nums, j, j - 1);
				}
			}
		}
	}
	
	public static void SelectionSort(int[] nums){
		if(nums == null || nums.length <= 0){
			return;
		}
		
		int max,i,j;
		for(i = 0; i < nums.length; i++){
			max = 0;
			for(j = 1; j < nums.length - i; j++){
				if(nums[j] > nums[max]){
					max = j;
				}
			}
			swap(nums, max, j - 1);
		}
	}
	
	public static void InsertionSort(int[] nums){
		if(nums == null || nums.length <= 0){
			return;
		}
		
		int i,j,tmp;
		for(i = 1; i < nums.length; i++){
			tmp = nums[i];//需要一个临时变量存储当前要插入的值
			for(j = i - 1; j >= 0 && nums[j] > tmp; j--){
				nums[j + 1] = nums[j];
			}
			nums[j + 1] = tmp;//找到插入位置
		}
	}
	
	public static void QuickSort(int[] nums, int l, int r){
		if(l >= r){
			return;//只有一个数了，认为有序
		}
		int middle = Partition(nums, l, r);
		QuickSort(nums, 0, middle - 1);
		QuickSort(nums, middle + 1, r);
	}
	
	public static int Partition(int[] nums, int l, int r){
		if(nums == null || nums.length <= 0 || l < 0 || r >= nums.length){
			throw new RuntimeException("错误");
		}
		
		int tmp = nums[l];
		
		while(l < r){
			while((l < r) && nums[r] >= tmp){
				r--;
			}
			nums[l] = nums[r];
			while((l < r) && nums[l] <= tmp){
				l++;
			}
			nums[r] = nums[l];
		}
		nums[l] = tmp;
		return l;
	}
	
	public static void MergeSort(int[] nums, int l, int r){
		if(nums == null || nums.length <= 0 || l >= r){
			return;
		}
		int mid = (l + r)/2;
		MergeSort(nums, l, mid);
		MergeSort(nums, mid + 1, r);
		Merge(nums, l, mid, r);
	}
	
	public static void Merge(int[] nums, int l, int mid, int r){
		int[] tmp = new int[r - l + 1];
		int i = l;
		int j = mid + 1;
		int k = 0;
		while(i <= mid && j <= r){
			if(nums[i] <= nums[j]){
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
		
		for(i = 0; i < tmp.length; i++){
			nums[l + i] = tmp[i];
		}
	}
	
	public static void HeapSort(int[] nums){
		if(nums == null || nums.length <= 0){
			return;
		}
		//首先将数组整体堆化
		for(int i = nums.length / 2 + 1; i >= 0; i--){
			Heapfy(nums, i, nums.length);
		}
		for(int i = nums.length - 1; i >= 1; i--){
			swap(nums, 0, i);
			Heapfy(nums, 0, i);
		}
	}
	
	//最大堆化
	public static void Heapfy(int[] nums, int i, int n){
		if(nums == null || nums.length <= 0 || i >= n || i < 0){
			return;
		}
		int tmp = nums[i];
		int j = 2 * i + 1;
		while(j < n){
			if((j + 1 < n) && (nums[j + 1] > nums[j])){
				j++;//找到两个结点中较大的结点
			}
			
			if(tmp >= nums[j]){
				break;
			}
			
			nums[i] = nums[j];
			i = j;
			j = 2 * i + 1;
		}
		nums[i] = tmp;
	}
	
	public static void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
