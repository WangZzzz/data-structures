package Leetcode;

import java.util.Arrays;

public class productExceptSelfDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4};
		productExceptSelf(nums);
	}
	
	public static void productExceptSelf(int[] nums){
		if(nums == null || nums.length <= 0){
	        return;
	    }
		int i, cnt = 1;
		for(i = 0; i < nums.length; i++){
			cnt = cnt * nums[i];
		}
		for(i = 0; i < nums.length; i++){
			nums[i] = cnt / nums[i];
		}
		System.out.println(Arrays.toString(nums));
	}

}
