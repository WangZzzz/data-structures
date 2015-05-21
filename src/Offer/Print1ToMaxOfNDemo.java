package Offer;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 	第94页
 * 	面试题12：输入数字n，按顺序打印出从1到最大的n位进制数，如输入3，则打印1，3，3.....999
 */
public class Print1ToMaxOfNDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Print1ToMaxOfN_2(3);
	}
	
	/*
	 * 最直观的解法：先求出10^n次方，然后循环打印，这种情况没有考虑到n很大时，溢出的问题
	 */
	public static void Print1ToMaxOfN_1(int n){
		int max = 1;
		for(int i = 1; i <= n; i++){
			max = max * 10;
		}
		for(int i = 1; i < max; i++){
			System.out.println(i);
		}
	}
	
	/*
	 * 改进：使用ArrayList集合存储数据
	 */
	public static void Print1ToMaxOfN_2(int n) {
        // 用nlist表示数n,nlist[0]表示n的最低位
        ArrayList<Integer> nlist = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            nlist.add(0);//把每一位都置零
        }
        increment(nlist);
    }
 
    // 使数字每次+1然后输出
    public static void increment(ArrayList<Integer> nlist) {
        int carrybit = 0;//进位
        boolean end = false;
        while (true) {
            for (int i = nlist.size() - 1; i >= 0; i--) {
                int digit = nlist.get(i);
//                System.out.println("digit" + i + ": " + digit);
                int sum = digit + carrybit;
                if (i == (nlist.size() - 1)) {
                    sum += 1;
                }
                System.out.println("sum : " + sum);
                if (sum >= 10) {
                    // 最高位产生进位，达到最大值，停止输出
                    if (i == 0) {
                    	//此时是最高位了，需要退出
                        end = true;
                    }
                    sum = sum - 10;
                    carrybit = 1;
                } else {
                    carrybit = 0;
                }
                nlist.set(i, sum);
            }
            output(nlist);
            if (end) {
                break;
            }
        }
    }
 
    // 输出数字，将高位的0舍掉
    public static void output(ArrayList<Integer> nlist) {
        Iterator<Integer> ite = nlist.iterator();
        int num;
        // 找到第一个为0的位置
        boolean first = false;
        while (ite.hasNext()) {
            if (first) {
                System.out.print(ite.next());
                continue;
            }
            if ((num = ite.next()) != 0) {
                first = true;
                System.out.print(num);
            }
        }
        System.out.println();
    }
	
}
