package Offer;

import java.util.Arrays;

/**
 * 
 * @author WangZ
 *	面试题51：数组中重复的数字 261页
 *	题目：在一个长度为n的数组里面的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但是不知道有几个数字重复了，也不知道每个数字
 *	重复了几次，请找出数组中任意一个重复的数字，例如输入长度为7的数组{2,3,1,0,2,5,3},那么对应的输出是重复的数字2或者3
 *	
 *	思路：首先想到的是将数组进行排序，在排序数组中找到重复的数字是很容易的，只需要从头到尾扫描怕徐后的数组就可以了，O(nlogn)
 *		，排序的做法是不符合要求的
 *	那么，可以考虑将每个数字换到它的正确的索引位置上，如扫描第0个元素，如果不是0，比如是2，那么就将他与索引2位置的元素比较，如果相等，
 *	那么就找到了一个重复的数组，如果不相等，那么就把索引2处的数字和索引0处的数字2交换，不停地重复下去
 */
public class DuplicationInArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,1,0,2,5,3};
		DuplicationInArray(nums);
	}
	
	/*
	 * 	循环一次即可,O(n)的时间复杂度，没有动用额外空间，O(1)的空间复杂度
	 */
	public static void DuplicationInArray(int[] nums){
		if(nums == null || nums.length <= 0){
			return;
		}
		
		int i = 0;
		for(i = 0; i < nums.length; i++){
			while(nums[i] != i){
				if(nums[i] == nums[nums[i]]){
					System.out.println("重复：" + nums[i]);
					swap(nums, i, nums[i]);			
					break;//当两个位置数字相同时，如果不break，会成为死循环
				}else{
					swap(nums, i, nums[i]);			
				}
					
			}
		}
		System.out.println(Arrays.toString(nums));
	}
	
	public static void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
