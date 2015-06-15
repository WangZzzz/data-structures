package Offer;

import java.util.Stack;

/*
 * 	面试题21：包含min函数的栈 第132页
 * 	题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数，在该栈
 * 		中，调用min、push、pop的时间复杂度都是O(1)
 * 	 使用辅助栈，辅助栈中始终存储最小值
 */
public class StackWithMinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackWithMin stackWithMin = new StackWithMin();
		stackWithMin.MyPush(3);
		stackWithMin.MyPush(4);
		stackWithMin.MyPush(2);
		stackWithMin.MyPush(1);
		System.out.println(stackWithMin.min());
		stackWithMin.MyPop();
		System.out.println(stackWithMin.min());
		stackWithMin.MyPop();
		System.out.println(stackWithMin.min());
		stackWithMin.MyPush(0);
		System.out.println(stackWithMin.min());
	}
	
	public static class StackWithMin{
		
		public Stack<Integer> m_data = new Stack<>();//数据栈
		public Stack<Integer> m_min = new Stack<>();//辅助栈
		
		public void MyPush(int value){
			m_data.push(value);
			if(m_min.size() == 0 || value < (int)m_min.peek()){
				m_min.push(value);
			}else{
				m_min.push((int) m_min.peek());
			}
		}
		
		public void MyPop(){
			assert(m_data.size() > 0 && m_min.size() > 0);
			
			m_data.pop();
			m_min.pop();
		}
		
		public int min(){
			//断言，如果断言错误，会终止程序
			assert(m_data.size() > 0 && m_min.size() > 0);
			
			return (int)m_min.peek();
		}
	}

}
