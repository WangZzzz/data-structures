package Offer;
/*
 * 	第90页
 * 	面试题11：实现函数double Power(double base, int exponent),求base的exponent次方。
 * 	不得使用库函数，同时不需要考虑大数问题 
 */
public class PowerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Power2(5, 32));
	}
	/*
	 * 此种解法没有考虑到底数为0，指数小于0的情况，不合格
	 */
	public static double Power(double base, int exponent){
		double result = 1.0;
		for(int i = 1; i <= exponent; i++){
			result = result * base;
		}
		return result;
	}
	
	/*
	 * 充分考虑各种情况，当指数是负数时，需要将指数取绝对值，然后求次方，再求倒数
	 * 	此时，如果底数是0，就会求0的倒数，会出错，所以得考虑到
	 */
	public static double Power2(double base, int exponent){
		if(equal(base, 0.0) && exponent < 0){
			//此时，底数是0，指数是负数，
			throw new RuntimeException("Invalid Input");
		}
		
		int absExponent = exponent < 0?(-exponent):exponent;//取指数的绝对值
		double result = PowerWithUnsignedExponent2(base, absExponent);
		
		if(exponent < 0){
			return 1.0 / result;
		}
		return result;
	}
	
	public static double PowerWithUnsignedExponent(double base, int exponent){
		//上面函数内部调用的方法， 取指数的绝对值后，求次方
		double result = 1.0;
		for(int i = 1; i <= exponent; i++){
			result = result * base;
		}
		return result;
	}
	
	/*
	 * 计算机在表示小数时会有误差（float,double），不能直接用==去判断是否等于一个数
	 * 	判断两个小数是否相等，只能判断他们之差的绝对值是不是在一个很小的范围内，如果
	 * 	两个小数相差很小，就可以认为他们相等
	 */
	public static boolean equal(double num1, double num2){
		if((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
			return true;
		else {
			return false;
		}
	}
	
	/*
	 * 	全面又高效的解法：例如：求一个数的32次方，在前面的PowerWithUnsignedExponent中，
	 * 	我们需要做31次乘法，
	 * 	可以考虑换一种思路：我们只需要在16次方的基础上再平方就可以了，
	 * 	16次方又是8次方的平方，8次方又是四次方的平方，因此，有如下公式：	
	 * 	a^n = a^(n/2) * a^(n/2) n为偶数
	 * 	    = a^((n-1)/2) * a((n-1)/2) * a n为奇数
	 */
	
	public static double PowerWithUnsignedExponent2(double base, int exponent){
		if(exponent == 0){//出口
			return 1;
		}
		
		if(exponent == 1){ //出口
			return base;
		}
		//exponent >>> 1 表示 exponent = exponent / 2，使用位运算效率高
		double result = PowerWithUnsignedExponent2(base, exponent >>> 1);
		result = result * result;//乘方
		if((exponent & 0x1) == 1){//说明exponent一直除2，最后余1，是奇数，根据公式，得再乘以base
			result = result * base;//这里没有使用%符号判断，而是使用位运算符，效率高
		}
		
		return result;
	}
}
