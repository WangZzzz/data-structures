package Sort;

public class SelectionSortDemo {
	/*
	 * 在要排序的一组数中，选出最大的一个数与最后一个位置的数交换；
			然后在剩下的数当中再找最大的与倒数第二个位置的数交换，
			如此循环到第二个数和第一个数比较为止
				O(n^2)
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {40,2,1,43,3,65,0,-1,58,3,42,4};
		selectionSort(data);
		for(int i = 0; i < data.length; i++){
			System.out.println(data[i]);
		}
	}
	
	public static void selectionSort(int[] data){
		if(data == null || data.length < 0){
			return;
		}
		int n = data.length;
		int max = 0;
		int i,j;
		for(i = 0; i < n; i++){
			max = 0;
			for(j = 1; j < n - i; j++){
				if(data[j] > data[max]){
					max = j;
				}
			}
			swap(data,n-1-i,max);//交换每趟的最后一个元素和max
		}
	}
	
	private static void swap(int[] data,int i ,int j){
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
}
