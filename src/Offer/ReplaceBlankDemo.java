package Offer;

/*
 * 	要求：将字符串中的每个空格替换成"%20"
 */
public class ReplaceBlankDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "We are happy.";		
		System.out.println(ReplaceBlank(str));
	}
	
	/*
	 *  时间复杂度O(n) + O(n) = O(n)
	 */
	public static String ReplaceBlank(String str){
		if(str == null || str.length() <= 0){
			return null;
		}
		int i = 0, j = 0;
	 	int n = str.length();
	 	int cnt = 0;
	 	for(i = 0; i < n; i++){
	 		if(str.charAt(i) == ' '){
	 			cnt++;
	 		}
	 	}
	 	int newLength = n + 2 * cnt;
	 	char[] arr = new char[newLength];
	 	for(i = n - 1, j = arr.length - 1; i >= 0;){
	 		if(str.charAt(i) != ' '){
	 			arr[j--] = str.charAt(i--);
	 		}else{
	 			arr[j--] = '0';
	 			arr[j--] = '2';
	 			arr[j--] = '%';
	 			i--;
	 		}
	 	}
	 	
	 	return new String(arr);
	}

}
