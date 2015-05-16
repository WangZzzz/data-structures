package Find;

/*
 *  折半查找---二分查找
 */

public class BinarySearchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {0,5,9,10,15,18,22,35,66,80,85,99,105,109,125,113,135,155,167,180,187,190,195,200};
		System.out.println(binarySearch(data,200,0,data.length-1));
	}
	
	public static int binarySearch(int[] data,int value){//非递归实现
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
	
	public static int binarySearch(int[] data,int value,int l, int r){//递归实现
		if(l > r){//递归出口
			return -1;
		}else{
			int mid = (l + r)/2;
			if(value == data[mid]){//递归出口
				return mid;
			}
			if(value > data[mid]){
				l = mid + 1;
				return binarySearch(data,value,l, r);
			}else{
				r = mid -1;
				return binarySearch(data,value,l, r);
			}
		}
	}
}
