package Offer;

import java.awt.SystemTray;

/*
 * 	面试题17：合并两个排序的链表 第114页
 * 	题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
 */
public class MergeTwoLinkedListDemo {
	public static void main(String[] arg){
		LinkedList ll1 = new LinkedList();
		ll1.addFirst(15);
		ll1.addFirst(11);
		ll1.addFirst(9);
		ll1.addFirst(6);
		ll1.addFirst(3);
		displayAllNodes(ll1.head);
		LinkedList ll2 = new LinkedList();
		ll2.addFirst(22);
		ll2.addFirst(18);
		ll2.addFirst(13);
		ll2.addFirst(7);
		ll2.addFirst(4);
		ll2.addFirst(1);
		displayAllNodes(ll2.head);
		System.out.println("**************");		
		displayAllNodes(Merge2(ll1.head, ll2.head));
	}
	
	/*
	 * 	递归实现
	 */
	public static ListNode Merge(ListNode head1, ListNode head2){
		if(head1 == null && head2 == null){
			return null;
		}
		if(head1 == null && head2 != null){
			return head2;
		}
		if(head1 !=null && head2 == null){
			return head1;
		}
		ListNode newNode;
		if(head1.val < head2.val){
			newNode = head1;
			newNode.next = Merge(head1.next, head2);
		}else{
			newNode = head2;
			newNode.next = Merge(head1, head2.next);
		}
		return newNode;
	}
	/*
	 * 非递归实现
	 */
	public static ListNode Merge2(ListNode head1, ListNode head2){
		if(head1 == null && head2 == null){
			return null;
		}
		if(head1 == null && head2 != null){
			return head2;
		}
		if(head1 !=null && head2 == null){
			return head1;
		}
		ListNode newHead = new ListNode(0);
		newHead.next = null;
		ListNode newNode = newHead;//尾指针
		while(head1 != null && head2 != null){
			if(head1.val < head2.val){
				newNode.next = head1;
				newNode = newNode.next;
				head1 = head1.next;
			}else{
				newNode.next = head2;
				newNode = newNode.next;
				head2 = head2.next;
			}
		}
		if(head1 == null){
			newNode.next = head2;
		}else{
			newNode.next = head1;
		}
		return newHead.next;
	}
	
	public static void displayAllNodes(ListNode head){
		ListNode current = head;
		while(current != null){
			System.out.println(current.val);
			current = current.next;
		}
	}
}
