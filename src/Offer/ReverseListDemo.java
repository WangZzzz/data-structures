package Offer;


/*
 * 	第112页
 * 		面试题16：反转链表
 * 		题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转链表的头结点
 * 
 * 	思路：需要三个指针，当前结点，前一个结点，后一个结点
 */
public class ReverseListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.addFirst(1);
		ll.addFirst(2);
		ll.addFirst(3);
		ll.addFirst(4);
		ll.addFirst(5);	
		disPlay(ll.head);
				
		disPlay(ReverseList(ll.head));
	}
	
	public static ListNode ReverseList(ListNode head){
		if(head == null){//没有结点
			return null;
		}
		
		if(head.next == null){
			//只有一个结点
			return head;
		}
		
		ListNode previous = null;//头结点的前一个结点是null
		ListNode current = head;
		ListNode ReverseHead = null;//反转后的结点头部
		while(current != null){
			ListNode pNext = current.next;
			if(pNext == null){
				//说明到最后一个结点了
				ReverseHead = current;
			}		
			current.next = previous;//当前结点指向前一个结点
			previous = current;//前一个结点设置为当前结点
			current = pNext;//当前结点设置为刚才保留的下一个结点
		}		
		return ReverseHead;
	}
	

	public static void disPlay(ListNode node){
		ListNode current = node;
		if(current == null){
			return;
		}else{
			while(current != null){
				System.out.println(current.val);
				current = current.next;
			}
		}
	}
}
