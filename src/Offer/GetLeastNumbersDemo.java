package Offer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

/**
 * 
 * @author WangZ
 *	面试题30：最小的k个数		167页
 *		题目：输入n个整数，找出其中最小的k个数，例如输入4、5、1、6、2、7、3、8这8个数字，则最小的k个数字是1、2、3、4
 */
public class GetLeastNumbersDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,5,1,6,2,7,3,8};
		int k = 4;
		int[] output = new int[k];
		GetLeastNumbers(nums, output, k);
		System.out.println(Arrays.toString(output));

	}
	/*
	 * 	思路：基于Partition函数来解决这个问题，如果基于数组的第k个数字来调整，使得比第k个数字小的所有数字都位于数组的左边，
	 * 	比第k个数字大的所有数字都位于数组的右边，这样经过调整之后，位于数组中左边的k个数字就是最小的k个数字，这k个数字不一定是排序的
	 * 	O(n)的时间复杂度
	 * 	缺点是：会修改原数组
	 */
	public static void GetLeastNumbers(int[] nums, int[] output, int k){
		if(nums == null || nums.length <= 0 || output == null || k > nums.length || k <= 0){
			return;
		}
		
		int l = 0;
		int r = nums.length - 1;
		int index = Partition(nums, l, r);
		while(index != k - 1){
			if(index > k -1 ){
				//说明第k个值在index的左边，所以序列变为l到index之间
				r = index - 1;
				index = Partition(nums, l, r);
			}else{
				l = index + 1;
				index = Partition(nums, l, r);
			}
		}
		
		//将nums中前k个赋值给output
		for(int i = 0; i < k; i++){
			output[i] = nums[i];
		}
	}
	/*
	 * 	重点：O(nlogk)的算法，特别适合处理海量数据
	 * 	思路：创建一个大小为k的数据容器来存储最小的k个数字，接下来每次从输入的n个整数中读入一个数，如果容器中已有的数字少于k个，
	 * 		则直接把这次读入的整数放入容器之中，如果容器中已有k个数字了，也就是容器满了，则此时不能再插入新的数字而只能替换已有
	 * 	的数字，找出这已有的k个数字中的最大值，然后拿这次带插入的数字和最大值进行比较，如果插入的值比最大值小，则利用这个数字
	 * 	替换已有的最大值，如果待插入的值，比当前已有的最大值还要大，那么这个数不可能是最小的k个整数之一，于是可以抛弃这个数
	 * 	
	 * 	当容器满了之后，需要做3件件事情：
	 * 	1.在k个整数中找到最大数
	 * 	2.有可能在这个容器中删除最大数
	 * 	3.有可能要插入一个新的数字
	 * 	如果使用二叉树来实现这个数据容器，那么我们能在O(logk)时间内实现这三步操作，因此，对于n个输入数字而言，总的时间效率就是
	 * 	O(nlogk)
	 * 	
	 * 	我们可以选择用不同的二叉树来实现这个数据容器，由于每次都要找到k个整数中的最大的数字，很容易想到使用最大堆，在最大堆中，
	 * 	根节点的值总是大于它的子树中任意结点的值，于是，每次我们可以在O(1)的时间内找到k个数字中的最大值，但需要O(logk)时间完成
	 * 	删除及插入操作
	 * 
	 * 	java容器中的TreeSet是基于红黑树的，各种操作的时间复杂度为O(logn),符合要求
	 */
	public static void GetLeastNumbers2(int[] nums, TreeSet<Integer> leasetNumbers, int k){
		leasetNumbers.clear();
		
		if(nums == null || nums.length <= 0 || k <= 0 || k >= nums.length){
			return;
		}
		for(int i : nums){
			if(leasetNumbers.size() < k){
				leasetNumbers.add(i);
			}else{
				
			}
		}
	}
	
	public static int Partition(int[] nums, int l, int r){
		//随机选取一个轴
		Random random = new Random();
		int index = random.nextInt(r - l + 1) + l;
		
		int tmp = nums[l];
		nums[l] = nums[index];
		nums[index] = tmp;
		
		tmp = nums[l];
		
		while(l < r){
			while((l < r) && (nums[r] >= tmp))
				r--;
			nums[l] = nums[r];
			while((l < r) && (nums[l] <= tmp))
				l++;
			nums[r] = nums[l];
		}
		nums[l] = tmp;
		return l;
	}

}
