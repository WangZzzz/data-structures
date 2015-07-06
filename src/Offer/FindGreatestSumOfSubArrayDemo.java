package Offer;
/**
 * 
 * @author WangZ
 *	面试题31：连续子数组的最大和 171页
 *		题目：输入一个整数数组，数组里有正数也有负数，数组中一个或者连续的多个整数数组组成一个子数组，求所有子数组
 *		的和的最大值，要求时间复杂度为O(n)
 *	
 */
public class FindGreatestSumOfSubArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,-2,3,10,-4,7,2,-5};
		System.out.println(FindGreatestSumOfSubArray(arr));
	}
	
	public static int FindGreatestSumOfSubArray(int[] nums){
		if(nums == null || nums.length <= 0){
			return -1;
		}
		
		int sum = 0;
		int max = 0;
		//整型的最大边界
		int Border = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++){
			sum = sum + nums[i];
			//如果加完当前值之后，还不如当前值大，那么sum重新置为当前值
			if(sum < nums[i]){
				sum = nums[i];
			}
			//使用一个变量记录最大值，如果sum比max大，说明出现新的最大值
			if(sum > max){
				max = sum;
			}
			
			if(max > Border){
				max = Border;
			}
		}
		return max;	
	}

}
