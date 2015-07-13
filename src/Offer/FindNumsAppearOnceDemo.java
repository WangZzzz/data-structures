package Offer;
/**
 * 
 * @author WangZ
 *	面试题40：数组中只出现一次的数字 211页
 *	题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次，请些程序找出这两个只出现一次的数字，要求时间复杂度是O(n)，空间复杂度是O(1)
 *	例如输入数组{2,4,3,6,3,2,5,5} ，因为只有4、6这两个数字只出现了一次，其他的数字都出现了两次，所以输出4、6
 *	考虑题目“一个数组中只有一个数字出现了一次”，使用异或的性质，0异或任何数，为那个数本身，两个相同的数，进行异或操作，为0，
 *		所以将数组元素从头到尾进行异或运算，最后的结果就是那个只出现一次的数字
 *	思路：考虑把原数组分成两个数组，分别进行异或运算，那么如何划分？
 *		先对原数组进行一次异或运算，得到一个结果，根据结果的第n为是不是1，（比如找到最右边的第一个1），将原数组分成两部分，两个出现一次的数肯定被分在两个数组，
 *		同时，相同的数肯定被分在同一个数组
 */
public class FindNumsAppearOnceDemo {

	public static int tmp1 = 0;
	public static int tmp2 = 0;
	
	public static void main(String[] args){
		int[] nums = {2,4,3,6,3,2,5,5};
		FindNumsAppearOnce(nums);
		System.out.println(tmp1);
		System.out.println(tmp2);
	}
	
	public static void FindNumsAppearOnce(int[] nums){
		if(nums == null || nums.length < 2){
			return;
		}
		
		int result = 0;
		for(int i = 0; i < nums.length; i++){
			result = result ^ nums[i];
		}
		int indexOf1 = FindFirstBitIs1(result);
		//将数组的两部分分别做异或运算，求出那两个出现一次的数
		for(int i = 0; i < nums.length; i++){
			if(isBit1(nums[i], indexOf1)){
				tmp1 = tmp1 ^ nums[i];
			}else{
				tmp2 = tmp2 ^ nums[i];
			}
		}
		
	}
	
	//找到异或结果二进制中的第一个1
	public static int FindFirstBitIs1(int num){
		int indexBit = 0;
		while((num & 1) == 0){
			num = num >> 1;
			indexBit++;
		}
		System.out.println("index : " + indexBit);
		return indexBit;
	}
	
	//判断一个数字的第n位二进制数字是不是1
	public static boolean isBit1(int num, int n){
/*		int index = 0;
		boolean res = false;
		while(true){
			if(index == n){
				if((n & 1) == 1){
					res = true;
				}
				break;
			}else{
				index++;
				n = n >> 1;
			}
		}
		return res;*/
	
		//直接位移n位
		num = num >> n;
		return (num & 1) == 1;
	}
}
