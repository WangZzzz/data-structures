package Structures;

import java.util.Arrays;

import javax.naming.InitialContext;

//最小堆
public class HeapDemo {
	public static void main(String[] args){
		int[] nums = {49,38,65,97,76,13,27,0,78};
		for(int i = (nums.length/2 - 1); i >= 0; i--){
			Heapfy(nums, i, nums.length);
		}
		System.out.println(Arrays.toString(nums));
		
		//堆排序 注意使用最小堆排序后是递减数组，要得到递增数组，可以使用最大堆。 n * logn
		for(int i = nums.length - 1; i >= 1; i--){
			swap(nums, 0, i);
			Heapfy(nums, 0, i);
		}
		System.out.println(Arrays.toString(nums));

	}
	
	
	//在堆中删除数据，将最后一个结点换到跟结点，重新堆化
	public static void delteNumber(int[] nums){
		if(nums == null || nums.length <= 0){
			return;
		}
		swap(nums, 0, nums.length - 1);
		Heapfy(nums, 0, nums.length - 1);//重新堆化
	}
	
	private static void swap(int[] data,int i, int j){
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	
	//小根堆化
	public static void Heapfy(int[] nums, int i, int n){
		if(nums == null || nums.length <= 0 || i >= n) {
			return;
		}
		int tmp = nums[i];
		int j = 2 * i + 1;
		while(j < n){
			//找到左右结点中较小的结点
			if(j + 1 < n && nums[j + 1] < nums[j]){
				j++;
			}
			
			if(tmp <= nums[j]){
				//此种情况下不需要交换，已经满足最小堆的性质
				break;
			}
			
			nums[i] = nums[j];
			i = j;
			j = 2 * i + 1;
		}
		
		nums[i] = tmp;//已经把j赋给i了，所以是给i赋tmp的值
	}
}
