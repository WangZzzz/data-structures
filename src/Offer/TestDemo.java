package Offer;

import javax.xml.bind.ValidationEvent;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.addFirst(4);
		ll.addFirst(3);
		ll.addFirst(2);
		ll.addFirst(1);
//		ll.disPlay();
		ListNode node = Test(ll.head);
		System.out.println(node.val);
		System.out.println(node.next.val);
		System.out.println(node.next.next.val);
		System.out.println(node.next.next.next.val);
	}

/*	public static ListNode Test(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode current = head;
		while (current != null && current.next != null) {
			ListNode tmp = current.next;
			if (current.val == tmp.val) {
				current.next = tmp.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}*/

	public static ListNode Test(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode newHead = head;

		ListNode current = head;
		ListNode previous = null;

		while (current != null && current.next != null) {
			if(previous != null){
				previous.next = current;
			}
			ListNode tmpNode = current.next;
			if(current == head){
				newHead = tmpNode;
			}
			current.next = tmpNode.next;
			tmpNode.next = current;
			previous = current;
			current = current.next;
		}
		return newHead;
	}

}
