package Sort;

/*
 * 直接插入排序：将左边的视为已经排好序的，将右边的依次插入
 */
public class InsertionSortDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {40,2,1,43,3,65,0,-1,58,3,42,4};
		insertionSort(data);
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
}
