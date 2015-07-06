package Sort;
/*
 * 希尔排序，插入排序的改进型，实质就是分组插入排序
 * 该方法的基本思想是：先将整个待排元素序列分割成若干
 * 个子序列（由相隔某个“增量”的元素组成的）分别进行直接插入排序，
 * 然后依次缩减增量再进行排序，待整个序列中的元素基本有序（增量足够小）时，
 * 再对全体元素进行一次直接插入排序。因为直接插入排序在元素基本有
 * 序的情况下（接近最好情况），效率是很高的，因此希尔排序在时间效率
 * 上会很高
 * 
 * 时间复杂度：O(n^2)到O(nlog2(n))之间,控件复杂度O(1)
 * 	O(n^1.5)
 */
public class ShellSortDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		shellSort(data);
		for(int i = 0; i < data.length; i++){
			System.out.println(data[i]);
		}
	}
	
	public static void shellSort(int[] data){
		if(data == null || data.length <= 0){
			return;
		}
		int n = data.length;
		int gap,i,j,k,tmp;
		for(gap = n/2; gap > 0; gap = gap / 2){
			for(i = 0;i<gap;i++){
				insertionSort(data, gap,i);
			}			
		}
	}
	
	/*
	 * 希尔排序，分块之后使用的还是插入排序，只不过，步长不再是1了
	 */
	private static void insertionSort(int[] data,int gap,int m){
		if(data == null || data.length < 0){
			return;
		}
		int n = data.length;  
		int i,j,k,tmp;;
		for(i = m + gap; i< n; i = i + gap){
			tmp = data[i];
			//寻找插入位置
			for(j = i-gap; j >= 0 && tmp < data[j]; j = j - gap){
				data[j+gap] = data[j]; 
			}
			data[j+gap] = tmp;
		}
	}
}
