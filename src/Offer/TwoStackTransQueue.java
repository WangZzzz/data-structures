package Offer;

import java.util.Stack;
/*
 * 	剑指offer 59页
 * 	题目：使用两个栈实现一个队列，队列的声明如下，请实现他的两个函数appendTail和
 * 		deleteHead，分别在对了尾部插入节点和在队列头部删除节点的功能
 * 	原理：两个栈s1，s2，添加元素时添加到s1中，删除元素时，先把s1中的全部元素移到s2中，然后从
 * 		s2中取出，再一次取的时候，s1已经是空的了，直接从s2中取下一个元素 
 */

public class TwoStackTransQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue<Integer> mq = new MyQueue<Integer>();
		mq.appendTail(1);
		mq.appendTail(2);
		mq.appendTail(3);
		mq.appendTail(4);
		System.out.println(mq.deleteHead());
		mq.appendTail(5);
		System.out.println(mq.deleteHead());
		System.out.println(mq.deleteHead());
		System.out.println(mq.deleteHead());
		System.out.println(mq.deleteHead());
	}

}

class MyQueue<T>{
	private Stack<T> s1 = new Stack<T>();
	private Stack<T> s2 = new Stack<T>();
	public MyQueue(){};
	
	public void appendTail(T data){
		s1.push(data);
	}
	
	public T deleteHead(){
		if(s2.size() <= 0){//当s2有内容时，说明已经进行过此步操作了，直接从s2中取出元素即可
			while(s1.size() > 0){
				T data = s1.pop();							
				s2.push(data);
			}

			if(s2.size() == 0){
				throw new RuntimeException("queue is empty");
			}
		}
				
		T head = s2.pop();
		return head;				
	}
}