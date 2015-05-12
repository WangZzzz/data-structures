package Sort;

public class QuickSortDemo {
	/*
	 * 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，
	 * 将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,
	 *此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
	 *	时间复杂度：O(nlog(n))
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {40,2,1,43,3,65,0,3,-1,58,42,4};
		quickSort(data,0,data.length-1);
		for(int i = 0; i < data.length; i++){
			System.out.println(data[i]);
		}
	}
	
	public static void quickSort(int[] data,int l,int r){
		if(l < r){
			int middle = partion(data, l, r);//得到一次的中间位置
			quickSort(data, l, middle-1);//中间位置左侧
			quickSort(data, middle+1, r);//中间位置右侧
		}		
	}
	
	public static int partion(int[]data, int l ,int r){
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

}
