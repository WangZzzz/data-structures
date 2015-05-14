package Offer;

import java.util.LinkedList;


/*
 * 约瑟夫问题，n个人围一圈，从第一个人开始报数，报数到m，退出，从下一个开始从新报数，报到m，退出
 * 	考虑使用循环链表
 */

public class JosephusProblemDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test(2, 9);
	}
	
	public static void Test(int m,int n){
		CircleLinkList<String> cll = new CircleLinkList<String>();
		for(int i = n; i > 0; i--){
			cll.addFirstNode("Person" + i);
		}
		cll.displayAllNodes1();
		System.out.println(cll.count);
		int cnt = 1;
		int index = 0;
		while(true){
			if(cnt == m){
				System.out.println("delete : " + cll.deleteByIndex(index));
				index--;
				cnt = 0;
			}else{
				cnt ++;
				index ++;
			}
			if(index == cll.count){
				index = 0;
			}
/*			if(cll.count == 15){
				break;
			}	*/	
			if(cll.count == 0){
				break;
			}
		}
		System.out.println("*************");
		cll.displayAllNodes1();
	}
}

class CircleLinkList<T> 
{
	public Node<T> head;//头结点
	public Node<T> tail;//尾节点
	public int count = 0;//节点总数
	class Node<T>{
		private T t;
		public Node<T> next;
		public Node(T t)
		{
			this.t = t;
		}
		public T getT() {
			return t;
		}
		public void setT(T t) {
			this.t = t;
		}		
	}
	
	public CircleLinkList(){
		head = null;
		tail = null;
	}
	
	public void clear(){//删除所有结点
		head.next = null;
		tail.next = null;
		head = null;
		tail = null;
	}
	//在头结点前面插入节点
	public void addFirstNode(T t)
	{
		Node<T> node = new Node<T>(t);
		if(head == null){//此时还没有元素
			head = node;
			tail = node;
			head.next = head;
			tail.next = tail;
			count ++;
		}else{		
			node.next = head;
			tail.next = node;
			head = node;
			count++;
		}
	}
	
	//删除头结点，并返回
	public T deleteFirstNode()
	{
		if(head == null){
			return null;
		}else{
			Node<T> tmpNode = head;
			head = head.next;
			tail.next = head;
			count--;
			return tmpNode.t;
		}
	}
	
	public void addLastNode(T data){//在尾部插入节点
		Node<T> node = new Node<T>(data);
		if(tail == null){
			tail = node;
			head = node;
			tail.next = tail;
			head.next = head;
			count ++;
		}else{
			tail.next = node;
			node.next = head;
			tail = node;
			count ++;
		}
	}
	
	
	//在指定位置插入节点
	public void addByIndex(int index, T t)
	{
		if(index < 0 || index > count-1)
		{
			throw new IndexOutOfBoundsException("插入越界");
		}
		if(index == 0){
			addFirstNode(t);
		}else if(index == count - 1){
			addLastNode(t);			
		}else{
			Node<T> node = new Node<T>(t);
			Node<T> current = head;
			Node<T> previous = head;
			int tmp = 0;
			while(tmp != index)
			{
				previous = current;
				current = current.next;
				tmp++;
			}
			previous.next = node;
			node.next = current;
			count++;
		}
	}
	
	//删除指定位置的节点
	public T deleteByIndex(int index)
	{
		if(index < 0 || index > count-1)
		{
			throw new IndexOutOfBoundsException("删除越界 : " + index);
		}else if(count == 1){//当只有一个元素时
			System.out.println("$$$");
			Node<T> node = head;
			head = null;
			tail = null;
			count --;
			return node.t;
		}else if(index == 0){//当删除的元素是第一个元素时
			return deleteFirstNode();
		}else{
			int tmp = 0;
			Node<T> current = head;//指向当前节点
			Node<T> previous = head;//指向当前节点的前一个节点
			while(tmp != index)
			{
				previous = current;
				current = current.next;
				tmp++;
			}
			previous.next = current.next;
			count--;
			return current.t;
		}
	}
	
	//根据索引查找节点
	public Node<T> findByIndex(int index)
	{
		if(index < 0 || index > count-1)
		{
			throw new IndexOutOfBoundsException("删除越界");
		}
		int tmp = 0;
		Node<T> current = head;
		while(tmp != index)
		{
			current = current.next;
			tmp++;
		}
		return current;
	}
	
	//根据数据查找节点的索引值
	public int IndexOf(T t)
	{
		Node<T> current = head;
		int index = 0;
		while(current.getT() != t)
		{
			if(current.next == null)
			{
				return -1;//查找到最后一个节点，没有查找到数据，返回-1
			}
			current = current.next;
			index++;			
		}
		return index;
	}
	
	//显示所有节点
	public void displayAllNodes1()
	{
		if(head != null){
			Node<T> current = head;
			while(true)
			{
				System.out.println(current.t);
				if(current.next == head){
					//最后一个节点了
					break;
				}
				current = current.next;
			}
		}	
	}
	
	/*
	 * 从尾节点开始打印链表的元素，思路：可以将遍历链表中的元素，
	 * 将元素使用offerFirst的方法存入LinkerList中，然后用pollFirst的方法取出,
	 * 实际上实现了一个栈的结构，后进先出
	 */
	public void displayAllNodes2(){
		if(head != null){
			Node<T> current = head;
			LinkedList<T> ll = new LinkedList<T>();
			while(true){
				ll.offerFirst(current.getT());
				if(current.next == head){
					break;
				}
				current = current.next;
			}
			T t = null;
			while((t = ll.pollFirst()) != null){
				System.out.println(t);
			}
		}
	}
	
	/*
	 * 还是从尾部打印元素，既然想到了栈，而递归本质上就是一个栈结构，当访问到一个结点时，
	 * 我们先递归输出他的后续节点
	 * 	注意：基于递归的代码看起来很简洁，但是有个问题，当链表非常长时，就会导致函数调用的
	 * 		层级很深，从而有可能导致调用栈溢出！第二种方法的鲁棒性要好一些。
	 */
	public void displayAllNodes3(Node<T> node){
		if(node != null){
			if(node.next != head){
				displayAllNodes3(node.next);
			}			
			System.out.println(node.getT());
		}
	}
}
