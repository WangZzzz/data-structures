package Offer;

import java.awt.geom.RectangularShape;
import java.util.function.IntPredicate;

/**
 * 
 * @author WangZ
 *	面试题36：数组中的逆序对 189页
 *	题目：在数组中的两个数字，如果前面一个数字大于后面的数字，这这两个数字组成一个逆序对，输入一个数组，求出这个数组中的逆序对的总数，
 *	例如：{7,5,6,4},一共存在5个逆序对：(7,6)、(7,5)、(7,4)、(6,4)、(5,4)
 */
public class InversePairsDemo {

	private static int cnt = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums =  {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		System.out.println(InversePairs(nums));
		System.out.println(InversePairs2(nums));
		
		int[] nums2 =  {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		//利用归并排序
		MergeSort(nums2, 0, nums2.length - 1);
		System.out.println(cnt);
	}
	
	/*
	 * 方法一：
	 * 	O(n^2)的做法，扫描数组，每扫描到一个数，就跟后面的每一个数字比较，判断是不是逆序对
	 * 	这种算法太慢，不符合要求
	 */
	public static int InversePairs(int[] nums){
		if(nums == null || nums.length <= 0){
			return -1;
		}
		int i = 0, j = 0;
		int cnt = 0;
		for(i = 0; i < nums.length; i ++){
			for(j = i + 1; j < nums.length; j++){
				if(nums[i] > nums[j]){
					cnt ++;
				}
			}
		}
		
		return cnt;
	}
	
	/*
	 * 	考虑利用归并排序
	 */
	public static int InversePairs2(int[] nums){
		if(nums == null || nums.length <= 0){
			return 0;
		}
		
		int[] copy = new int[nums.length];
		for(int i = 0; i < nums.length; i ++){
			copy[i] = nums[i];
		}
		
		int count = InversePairsCore(nums, copy, 0, nums.length - 1);
				
		return count;
	}
	
	private static int InversePairsCore(int[] nums, int[] copy, int start, int end){
		if(start == end){
			copy[start] = nums[start];
			return 0;
		}
		
		int length = (end - start) / 2;//length是一半的长度
		
		int left = InversePairsCore(copy, nums, start, start + length);
		int right = InversePairsCore(copy, nums, start + length + 1, end);
		
		//i初始化为前半段最后一个数字的下标
		int i = start + length;
		
		//j初始化为后半段第一个数字的下标
		int j = end;
		//新数组的索引
		//因为是逆序对，比较条件是>，所以从末尾开始比较赋值
		int indexCopy = end;
		int count = 0;
		
		while(i >= start && j >= start + length + 1){
			if(nums[i] > nums[j]){
				copy[indexCopy--] = nums[i--];
				count += j - start - length;//start + length 为j那半数组的起始位置索引
			}else{
				copy[indexCopy--] = nums[j--];
			}
		}
		
		for(; i >= start; --i){
			copy[indexCopy--] = nums[i];
		}
		
		for(; j >= start + length + 1; j--){
			copy[indexCopy--] = nums[j];
		}
		
		return left + right + count;
	}
	
	//方法三：方法二的改进型，更容易看懂，归并排序
	
	public static void MergeSort(int[] data, int low, int high){
		if(low < high){
			int mid = (low + high) / 2;
			//左边
			MergeSort(data, low, mid);
			//右边
			MergeSort(data, mid + 1, high);
//			//将完成排序的左右归并
			Merge(data, low, mid, high);
		}
	}
	
	public static void Merge(int[] data, int low, int mid, int high){
		int[] tmp = new int[high - low + 1];
		int i = mid;//左指针，负责low~mid这边的数组
		int j = high;//右指针，负责mid+1~high这边的数组
		int k = tmp.length - 1;//负责新数组

		while(i >= low && j >= mid + 1){
			if(data[i] > data[j])
			{
				tmp[k--] = data[i--];
				cnt += j - mid;//此时，说明有逆序对，并且逆序对的数量为j - mid
			}else{
				tmp[k--] = data[j--];
			}
		}
		
		//将左边剩余的数移到临时数组，左边和右边不可能同时都有剩余的数组，只可能有一边有
		while(i >= low){
			tmp[k--] = data[i--];
		}
		
		//将右边剩余的数移到临时数组
		while(j >= mid + 1){
			tmp[k--] = data[j--];
		}
		
		//将临时数组的值覆盖原数组，注意，不是从0开始，是从low开始
		for(int m = 0; m < tmp.length; m++){
			data[m + low] = tmp[m];
		}
	}	
	
}
