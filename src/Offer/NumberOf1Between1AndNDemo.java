package Offer;
/**
 * 	
 * @author WangZ
 *	面试题32：从1到n整数中1出现的次数 174页
 *	题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数，例如，输入12，从1到12中包含1的数字有1,10，11,12，一共出现了5次
 */
public class NumberOf1Between1AndNDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(NumberOf1Between1AndN(12));
	}
	
	/*
	 * 	思路：累加从1到n中每个整数1出现的次数，可以通过对10取余来判断整数的个位数字是不是1，如果这个数字大于10，可以除以10之后，
	 * 	再判断个位数字是不是1、
	 * 	时间复杂度：对于输入数字n，n有O(logn)位，需要判断每一位是不是1，一共有n个数字，那么他的时间复杂度是O(nlogn)
	 * 
	 * 	当输入的n非常大时，需要大量的运算，运算效率不高。
	 */
	public static int NumberOf1Between1AndN(int n){
		int number = 0;
		for(int i = 1; i <= n; i++){
			number += NumberOf1(i);
		}
		return number;
	}
	
	public static int NumberOf1(int n){
		System.out.println("$" + n);
		int number = 0;
		while(n != 0){
			System.out.println("@" + n);
			if( n % 10 == 1){
				number++;
			}
			n = n/10;
		}
		return number;
	}
}
