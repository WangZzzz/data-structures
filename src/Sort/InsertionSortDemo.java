package Sort;

/*
 * 直接插入排序：将左边的视为已经排好序的，将右边的依次插入
 * 
 * 基本思想：在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排
 *	好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
 *		也是排好顺序的。如此反复循环，直到全部排好顺序。
 *	特点：1.基本有序的序列，直接插入排序最快
 *			2.记录个数很少的无序序列，直接出入也很快
 *		O(n^2)
 */
public class InsertionSortDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {40,2,1,43,3,65,0,-1,58,3,42,4};
		insertionSort2(data);
		for(int i = 0; i < data.length; i++){
			System.out.println(data[i]);
		}
	}
	
	public static void insertionSort(int[] data){
		if(data == null || data.length < 0){
			return;
		}
		int n = data.length;
		int i,j,k,tmp;;
		for(i = 1; i< n; i++){
			//寻找插入位置
			for(j = 0; j <= i - 1; j++){
				if(data[j] > data[i])
					break;
			}
			tmp = data[i];
			//依次向后移动，将位置j留给data[i]这个值
			for(k = i - 1; k >= j; k--){
				data[k+1] = data[k];
			}
			data[j] = tmp;
		}
	}
	
	/*
	 * 此种插入排序，把寻找插入位置和后移元素一起进行了。
	 */
	public static void insertionSort2(int[] data){
		if(data == null || data.length < 0){
			return;
		}
		int n = data.length;
		int i,j,k,tmp;;
		for(i = 1; i< n; i++){
			tmp = data[i];
			//寻找插入位置 
			for(j = i-1; j >= 0 && tmp < data[j]; j--){
				data[j+1] = data[j]; 	
			}
			data[j+1] = tmp;
		}
	}
}
