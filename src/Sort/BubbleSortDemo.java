package Sort;

public class BubbleSortDemo {

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
