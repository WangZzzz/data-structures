package Sort;

import java.util.Arrays;
import java.util.Random;


public class QuickSortDemo {
	/*
	 * 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，
	 * 将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,
	 *此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
	 *	时间复杂度：O(nlog(n))
	 *	最坏情况：序列已经排序或者反序，时间复杂度O(n^2)
	 *	最好的情况下：序列值满足随机分布，O(nlogn);
	 *	平均算法时间复杂度：O(n^2)
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		quickSort(data,0,data.length-1);
		System.out.println(Arrays.toString(data));
	}
	
	public static void quickSort(int[] data,int l,int r){
		if(l >= r){
			return;
		}
		int middle = partion(data, l, r);//得到一次的中间位置
		quickSort(data, l, middle-1);//中间位置左侧
		quickSort(data, middle+1, r);//中间位置右侧	
	}
	
	public static int partion(int[]data, int l ,int r){
		if(data == null || data.length <= 0 || l < 0 || r >= data.length){
			throw new RuntimeException("输入错误！");
		}		
		Random random = new Random();
		int ranNum = random.nextInt(r - l + 1) + l;//有一个问题，永远取不到右边界
		swap(data,l,ranNum);

		int tmp = data[l];
		while(l < r){
			while((l < r) && (data[r] >= tmp))
				r--;
			data[l] = data[r];
			while((l < r) && (data[l] <= tmp))
				l++;
			data[r] = data[l];
		}
		//当l=r时，这个位置就是tmp的位置
		data[l] = tmp;
		return l;//将中间的位置返回
	}
	
	private static void swap(int[] data,int i, int j){
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
}
