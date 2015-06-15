package Offer;

import java.util.Stack;

/**
 * 
 * @author WangZ
 * 面试题22：栈的压入、弹出序列  第134页
 * 	题目：输入两个整数数列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出序列，假设压入栈的所有数字均不相等。
 * 
 * 思路：
 * 用一个栈作辅助，顺序描述压入序列和弹出序列，如果当前位置上压入序列和弹出序列值相等，直接都向后移一个元素；
 * 比较栈顶元素和弹出序列当前值，如果相等，出栈，弹出序列后移一个元素；其余情况，将压入序列当前值压栈，压入序列后移一个元素。
 * 如果到最后，弹出序列都处理不完，说明弹出序列不合法。时间复杂度为O(n)。
 * 
 *
 */
public class IsPopOrderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pPush = {1,2,3,4,5};
		int[] pPop = {4,5,3,2,1};
//		int[] pPop = {4,3,5,1,2};
		System.out.println(isPopOrder(pPush, pPop));

	}
	
	public static boolean isPopOrder(int[] pPush, int[] pPop){
		if(pPush == null || pPop == null || pPush.length <= 0 || pPop.length <= 0){
			return false;
		}
		Stack<Integer> tmpStack = new Stack<Integer>();
		int i = 0, j = 0;
		int n1 = pPush.length;//压入序列的长度
		int n2 = pPop.length;//出栈序列的长度
		 // 检查每个出栈  
		while(j < n2){
			while(i < n1 && pPush[i] != pPop[j]){
				 // 如果不等，则一直进栈  
				tmpStack.push(pPush[i]);
				i++;
			}
			 //相等的元素没有进栈
			i++;
			j++;
			int top = 0;
			
			while(!tmpStack.isEmpty() && ((top = tmpStack.pop()) == pPop[j])){
				j++;
			}
			
			if(j < n2){
				tmpStack.push(top);
			}
			// 当已经找不到进栈元素时退出  
			if(i >= n1 && !tmpStack.isEmpty()){
				break;
			}
		}

		if(tmpStack.isEmpty()){
			return true;
		}else{
			return false;
		}
		
	}

}
