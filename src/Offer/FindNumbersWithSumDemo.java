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
 *		
 *		题目二：输入一个正数s，打印出所有和为s的连续正数数列（至少含有两个数）。例如输入15，由于1+2+3+4+5=4+5+6=7+9=15，
 *		所以结果打印出3个连续序列1~5,4~6和7~8
 */
public class FindNumbersWithSumDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,4,7,11,15};
		FindNumbersWithSum(nums, 15);
		FindContinousSequence(9);
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
	
	//题目二的思路，与题目一相同，两个指针，small，big，small首先指向1，big指向2，然后判断small+big的值，如果大于s，那么big向右移动1，
	//如果小于s，那么small向右移动，同时序列要保证至少要有两个数字，我们一直增加small到（1+s)/2为止,因为如果大于这个数，那么两个数相加，
	//的和肯定大于s
	public static void FindContinousSequence(int sum){
		if(sum < 3){
			//两个数，1+2，那么序列值最小是3
			return;
		}
		
		int small = 1;
		int big = 2;
		int middle = (sum + 1)/2;
		//小技巧，使用currentSum保存当前求和的值，不需要重复求和
		int currentSum = small + big;
		while(small < big){
			if(currentSum == sum){
				PrintSequence(small, big);
			}
			//当当前和大于sum时，并且small小于(s+1)/2
			while(currentSum > sum && small < middle){
				//此时，需要将small向右移动，并且从currentSum中减去
				currentSum = currentSum - small;
				small++;
				if(currentSum == sum){
					PrintSequence(small, big);
				}
			}
			big++;
			currentSum = currentSum + big;
		}		
	}
	
	//打印序列
	public static void PrintSequence(int small, int big){
		for(int i = small; i <= big; i++){
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
