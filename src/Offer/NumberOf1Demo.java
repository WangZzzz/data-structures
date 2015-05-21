package Offer;

/*
 * 第78页
 * 面试题10：二进制中1的个数：
 * 	题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数
 * 
 * 注意：不要把n = n >> 1，换成n = n/2，因为位运算符效率高
 */
public class NumberOf1Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(NumberOf12(0xFFFFFFFF));
	}
	
	public static int NumberOf1(int n){
		//此种方法，对于0x80000000会陷入死循环，
		//因为如果数字原先为负数时，右移n位，最左边要补n个1
		int count = 0;
		while(n != 0){
			if((n & 1) == 1){
				count ++;
			}
			n = n >>> 1;
		}
		return count;
	}
	
	/*
	 * 思路：上一中方法是将n右移，我们可以将与n比较的数，一次左移一位，
	 * 这样，每次都能判断n的其中一位是不是1
	 */
	public static int NumberOf12(int n){
		int count = 0;
		int flag = 1;
		while(flag != 0){
			if((n & flag) == 1)
				count ++;
			flag = flag << 1;//左移一位
		}
		
		return count;
	}
	/*
	 * 
	 */
	public static int NumberOf13(int n){
		int count = 0;
		while(n != 0){
			++count;
			n = (n - 1) & n;
		}
		
		return count;
	}

}
