package Sort;

public class QuickSortDemo {
	/*
	 * 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，
	 * 将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,
	 *此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {40,2,1,43,3,65,0,-1,58,3,42,4};
		quickSort(data);
		for(int i = 0; i < data.length; i++){
			System.out.println(data[i]);
		}
	}
	
	public static void quickSort(int[] data){
		
	}

}
