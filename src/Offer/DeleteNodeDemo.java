package Offer;


/*
 * 	第99页
 * 	面试题13：在O(1)的事件删除链表结点：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)
 * 		时间删除该结点
 *	思路：我们很容易找到要删除结点的下一个结点，将这个结点的值复制给要删除的结点，同时让要删除
 *		的结点指向下一个结点的下一个结点即可，但是得考虑特殊情况：
 *			1.只有一个结点
 *			2.要删除的是尾结点，它的下一个结点为空
 */
public class DeleteNodeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.addFirst(1);
		ll.addFirst(2);
		ll.addFirst(3);
		ll.addFirst(4);
		ll.addFirst(5);
	}
	
	public static void DeleteNode(ListNode head, ListNode Delete){
		if(head == null || Delete == null){
			return;
		}
		
		if(head == Delete){
			//链表只有一个头结点
			head = null;
			Delete = null;
		}else if(Delete.next == null){
			//此时链表中有多个结点，而要删除的结点是尾结点
			//这种情况只能使用顺序查找
			ListNode current = head;
			while(current.next != Delete){
				current = current.next;
			}
			//此时current.next == Delete;
			//要删除尾结点。只需要让current.next = null;
			current.next = null;
			Delete = null;
		}else if(Delete.next != null){
			//要删除的结点不是尾结点
			ListNode tmp = Delete.next;
			Delete.val = tmp.val;
			Delete.next = tmp.next;			
			tmp = null;
		}						
	}

}

