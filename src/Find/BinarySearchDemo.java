package Find;

import javax.print.attribute.standard.RequestingUserName;

public class BinarySearchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {0,5,9,10,15,18,22,35,66,80,85,99,105,109,125,113,135,155,167,180,187,190,195,200};
		System.out.println(binarySearch(data,70));
	}
	
	public static int binarySearch(int[] data,int value){
		if(data == null || data.length <= 0){
			return -1;
		}
		int low = 0 , high = data.length - 1;
		int middle = 0;
		while(low <= high){
			middle = (low + high)/2;
			if(value < data[middle]){
				high = middle - 1;
			}else if(value > data[middle]){
				low = middle + 1;
			}else{
				return middle;
			}
		}
		return -1;
	}

}
