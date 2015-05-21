package Offer;
/*
 * 	第107页
 * 	面试题15：链表中倒数第k个结点
 * 		题目：输入一个链表，输入该链表中倒数第k个及诶单。为了符合大多数人的习惯，
 * 	本题从1开始计数，即链表的尾结点是倒数第一个结点
 */
public class FindKthToTailDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll1 = new LinkedList();		
		ll1.addFirst(15);
		ll1.addFirst(12);
		ll1.addFirst(9);
		ll1.addFirst(7);
		ll1.addFirst(2);
		
		System.out.println(FindKthToTail(ll1.head, 2).val);
	}
	/*
	 * 思路：倒数第k个结点和倒数第一个结点之间，相差k-1个结点，所以可以定义两个指针，同时
	 * 	指向链表头部，第一个指针先移动k-1步，此时两个指针同时移动，当第一个指针指向尾指针时，两个结点
	 * 	相差k-1步，此时第二个指针所指的结点就是所求结点
	 */
	public static ListNode FindKthToTail(ListNode head, int k){
		if(head == null || k == 0){
			return null;
		}
		
		ListNode pAhead = head;
		ListNode pBehind = null;
		for(int i = 0; i < k - 1; i++){
			if(pAhead.next != null){//特殊情况，没有链表结点总数小于k，如果不判断，会发生空指针异常
				pAhead = pAhead.next;
			}else{
				return null;
			}
		}
		
		pBehind = head;
		while(pAhead.next != null){//当pAhead.next为空时，说明已经指向了最后一个结点
			pAhead = pAhead.next;
			pBehind = pBehind.next;
		}
		
		return pBehind;		
	}
}