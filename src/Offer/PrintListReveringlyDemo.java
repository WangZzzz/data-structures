package Offer;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * @author WangZ
 *	面试题5：从尾到头打印链表 51页
 *		题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值
 *	可以利用栈来实现，同样的，递归就是基于栈的，也可以利用递归来实现
 */
public class PrintListReveringlyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		display(node1);
		System.out.println("*****");
		PrintListReveringly(node1);
		System.out.println("*****");
		PrintListReveringly2(node1);
	}
	//正着遍历
	public static void display(ListNode node){
		if(node == null){
			return;
		}
		ListNode current = node;
		while(current != null){
			System.out.println(current.val);
			current = current.next;
		}
	}
	
	//利用栈
	public static void PrintListReveringly(ListNode node){
		if(node == null){
			return;
		}
		
		ListNode current = node;
		LinkedList<ListNode> ll = new LinkedList<ListNode>();
		while(current != null){
			ll.offerFirst(current);
			current = current.next;
		}
		
		while(!ll.isEmpty()){
			ListNode tmp = ll.pollFirst();
			System.out.println(tmp.val);
		}
	}
	
	//利用递归，本质上也是栈
	public static void PrintListReveringly2(ListNode node){
		if(node == null){
			return;
		}
		
		if(node.next != null)
			PrintListReveringly2(node.next);
		System.out.println(node.val);
	}

}
