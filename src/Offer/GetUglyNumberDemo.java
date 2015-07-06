package Offer;
/**
 * 
 * @author WangZ
 *	面试题：34 丑数 182页
 *	题目：我们把只包含因子2、3和5的数称作丑数（Ugly Number)。求按从小到大的顺序的第1500个丑数，例如，6、8都是丑数，
 *	但是14不是，因为他包含因子7，习惯上把1当做第一个丑数
 */
public class GetUglyNumberDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(GetUglyNumber(1500));
	}
	
	/**
	 * 最直观的做法， 一个个的判断
	 */
	public static int GetUglyNumber(int index){
		if(index <= 0){
			return 0;
		}
		
		int cnt = 0;
		int i = 1;
		while(true){
			if(isUgly(i)){
				System.out.println(i);
				cnt++;
			}
			if(cnt == index){
				break;
			}
			i++;
		}
		
		return i;
		
	}
	
	public static boolean isUgly(int number){
		boolean isUgly = false;
		//看一个数是不是丑数，如果是丑数，则对2、3、5取余，肯定最后能到1
		int tmp  = number;
		while(number % 2 == 0){
			number = number / 2;
		}
		
		while(number % 3 == 0){
			number = number / 3;
		}
		
		while(number % 5 == 0){
			number = number / 5;
		}
		
		if(number == 1){
			isUgly = true;
//			System.out.println(tmp);
		}
		

		return isUgly;
		
	}

}
