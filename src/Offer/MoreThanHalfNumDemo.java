package Offer;

/***
 * @author WangZ
 * 	面试题29：数组中出现次数超过一半的数字 163页
 * 		题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字，例如，输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 		由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2
 */

import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;

public class MoreThanHalfNumDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		int[] data = {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		quickSort(data,0,data.length-1);
		System.out.println(Arrays.toString(data));*/
		int[] nums = {1,2,3,2,2,2,5,4,2};
		System.out.println(MoreThanHalfNum(nums));
		System.out.println(MoreThanHalfNum2(nums));
	}
	
	/**
	 *	方法一：利用快速排序
	 *	思路：如果将数组排序，那么排序之后，位于数组中间的数字一定就是那个出现次数超过数组长度一半的数字
	 *	快速排序的Paration每次都能返回 mid数，所以可以看返回的mid是不是数组的中间，如果是则返回数据
	 *	事件复杂度O(n)
	 */
	public static int MoreThanHalfNum(int[] nums){
		if(nums == null || nums.length <= 0){
			throw new RuntimeException();
		}
		int length = nums.length;
		int middle = length >> 1;//就是除以2
		int start = 0;
		int end = length - 1;
		int index = Partition(nums, start, end);
		while(index != middle){
			if(index > middle){
				//说明middle在index的左边
				end = index - 1;
				index = Partition(nums, start, end);
			}else{
				start = index + 1;
				index = Partition(nums, start, end);
			}
		}
		
		int result = nums[middle];
		/*
		 * 	判断这个中位数出现的次数是否大于数组长度的一般
		 */
		int cnt = 0;
		for(int i : nums){
			if(i == nums[middle])
				cnt ++;
		}
		if(cnt <= (length >> 1)){
			result = 0;
		}
		
		return result;
		
	}
		
	public static int Partition(int[] nums, int start, int end){
		/*
		 * 随机选取一个轴
		 */
		if(nums == null || nums.length <= 0 || start < 0 || end >= nums.length){
			throw new RuntimeException("输入错误！");
		}
		Random random = new Random();
		int ran = random.nextInt(end - start + 1) + start;
		int tmp = nums[start];
		nums[start] = nums[ran];
		nums[ran] = tmp;
		
		tmp = nums[start];
		while(start < end){
			while((start < end) && (nums[end] >= tmp))
				end--;
			nums[start] = nums[end];
			while((start < end) && (nums[start] <= tmp))
				start++;
			nums[end] = nums[start];
		}
		nums[start] = tmp;
		return start;
	}
	
	/*
	 * 	方法二：根据数组特点找出O(n)的算法
	 * 	遍历数组时，保存两个值，一个是数组中的一个数字，一个是次数，当遍历到下一个数字的时候，如果下一个数字和之前保存的数字相同，
	 * 	则次数+1，如果下一个数字和之前保存的数字不同，则次数减1，如果次数为0，则需要保存下一个数字，并将次数设置为1，
	 * 	由于我们要找的数字的出现的次数比其他所有数字出现的次数之和还要多，那么要找的数字肯定是最后一次把次数设置为1对应的数字
	 */
	
	public static int MoreThanHalfNum2(int[] nums){
		if(nums == null || nums.length <=0){
			throw new RuntimeException();
		}
		
		int result = nums[0];
		int times = 1;
		for(int i = 0; i < nums.length; i++){
			if(times == 0){
				result = nums[i];
				times = 1;
			}else if(nums[i] == result){
				times++;
			}else{
				times --;
			}
		}
		/*
		 * 	判断这个中位数出现的次数是否大于数组长度的一般
		 */
		int cnt = 0;
		for(int i : nums){
			if(i == result)
				cnt ++;
		}
		if(cnt <= (nums.length >> 1)){
			result = 0;
		}
		
		return result;
		
	}
	
	/*
	 * 	快排
	 */
	public static void quickSort(int[] nums, int start, int end){
		if(start < end){
			int mid = Partition(nums, start, end);
			quickSort(nums, start, mid - 1);
			quickSort(nums, mid + 1, end);
		}
	}
}
