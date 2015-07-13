package Offer;
/**
 * 
 * @author WangZ
 *	面试题41：和为S的两个数字VS和为s的连续正数列
 *		题目一：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和刚好是s，如果有多对数字的和等于s，输出任意一对即可
 *	例如输入数组{1,2,4,7,11,15}和数字15，由于4+11=15，因此输出4和11
 *	思路：
 *		方法一：现在数组中固定一个数字，再判断数组中的其余的n-1个数字与它的和是不是等于s，O(n^2)的时间复杂度
 *		方法二：头尾双指针，如果大于s，那么移动尾指针向前，如果小于s，那么移动头指针向后,从两边向中间扫描，时间复杂度为O(n)
 */
public class FindNumbersWithSumDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,4,7,11,15};
		FindNumbersWithSum(nums, 15);

	}
	
	public static void FindNumbersWithSum(int[] nums, int s) {
		if(nums == null || nums.length <= 0){
			return;
		}
		
		int i = 0;
		int j = nums.length - 1;
		while(i < j){
			if(nums[i] + nums[j] == s){
				System.out.println("两个数为： " + nums[i] + "和" + nums[j]);
				return;
			}else if((nums[i] + nums[j]) > s){
				j--;
			}else{
				i++;
			}
		}
		
		System.out.println("没有找到结果");
	}


}
