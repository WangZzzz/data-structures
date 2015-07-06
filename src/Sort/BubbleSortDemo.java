package Sort;

public class BubbleSortDemo {
	/*
	 * 基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，
	 * 自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
	 * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
	 * 	O(n^2)
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {40,2,1,43,3,65,0,-1,58,3,42,4};
		bubbleSort(data);
		for(int i = 0; i < data.length; i++){
			System.out.println(data[i]);
		}
	}
	
	public static void bubbleSort(int[] data){
		if(data == null || data.length < 0){
			return;
		}
		int tmp = 0;
		int n = data.length;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n-i-1; j++){
				if(data[j] > data[j+1]){
					tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
				}
			}
		}
	}

}
