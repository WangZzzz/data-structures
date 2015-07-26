package Offer;
/*
 * 面试题9：斐波那契数列  73页
 */
public class FibonacciDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Fibonacci(9));
		System.out.println(Fibonacci2(9));
		System.out.println(climbStairs(9));
		System.out.println(climbStairs2(9));
	}
	
	/*
	 * 此种解法效率低下，会出现很多重复的节点
	 */
	public static long Fibonacci(int n){
		if(n <= 0){
			return 0;
		}
		
		if(n == 1){
			return 1;
		}
		
		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}
	
	/*
	 * 利用循环的方式，从最小的开始计算
	 * 	0 	1 	1 	2 	3 	5 	8 	13 	21 	34
	 * 	f1	f2	f
	 * 		f1	f2	f
	 * 			f1	f2	f
	 * 				f1	f2	f 
	 */
	public static long Fibonacci2(int n){
		int[] result = {0,1};
		if(n < 2){
			return result[n];
		}
		long fib1 = 0;
		long fib2 = 1;
		long fib = 0;
		for(int i = 2; i <= n; i++){
			fib = fib1 + fib2;
			fib1 = fib2;
			fib2 = fib;
		}
		
		return fib;
	}
	
	/*
	 * 	面试题：一只青蛙一次可以跳上一级台阶，也可以跳上2级，
	 * 请问，该青蛙跳上n级的台阶总共有多少种跳法
	 * 	n = 1, 1种
	 * 	n = 2, [1,1] [2]  2种
	 * 	n = 3, [1,1,1] [1,2] [2,1]  3种
	 * 	n = 4, [1,1,1,1] [1,1,2] [1,2,1] [2,1,1] [2,2] 5种
	 * 	n = 5, [1,1,1,1,1] [2,2,1] [2,1,2] [1,2,2] [1,1,1,2] [1,1,2,1] [1,2,1,1] [2,1,1,1] 8种
	 * 	斐波那契数列
	 */
	
	public static long climbStairs(int n){
		int[] result = {1,2};
		if(n <= 2){
			return result[n-1];
		}
		
		int f1 = result[0];
		int f2 = result[1];
		int f = 0;
		for(int i = 3; i <= n; i++){
			f = f1 + f2;
			f1 = f2;
			f2 = f;
		}
		return f;
	}
	
	public static long climbStairs2(int n)//递归方式,斐波那契数列，只不过出口不一样
	{
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		
		return climbStairs(n - 1) + climbStairs(n - 2);
	}
}

