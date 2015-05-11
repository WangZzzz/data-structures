package Sort;

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
	}
}
