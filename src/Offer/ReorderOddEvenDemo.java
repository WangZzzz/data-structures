package Offer;

import java.util.Arrays;

/*
 *	第102页
 *	面试题14：调整数组顺序使奇数位于偶数前面
 *		题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于
 *		数组的前半部分，所有偶数位于数组的后半部分 
 */
public class ReorderOddEvenDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		ReorderOddEven(nums);
		System.out.println(Arrays.toString(nums));
	}

	/*
	 * 	思路：双指针，一个指向左边，一个指向右边，左边指针右移，当找到偶数时，右边指针找奇数，
	 * 	当找到奇数时，进行交换
	 */
	public static void ReorderOddEven(int[] nums){
		if(nums == null || nums.length <= 0){
			return;
		}
		//双指针
		int l = 0;
		int r = nums.length - 1;
		/*
		 * 	判断偶数还是奇数，实际是就是判断二进制的最后一位是1还是0
		 * 	因此，可以和0x1进行&运算，判断是否为0，比取余数要快很多
		 */
		while(l < r){
			//找到左边第一个偶数
			while((l <= r) && ((nums[l] & 0x1) != 0)){
				l++;
			}
			//找到右边第一个奇数
			while((l <= r) && ((nums[r] & 0x1) == 0)){
				r--;
			}                                                                                    
			
			if(l < r){
				int tmp = nums[l];
				nums[l] = nums[r];
				nums[r] = tmp;
			}			
		}
	}
}
