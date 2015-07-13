package Offer;
/**
 * 
 * @author WangZ
 *	面试题37：两个链表的第一个公共结点 193页
 *		题目：输入两个链表，找出它们的第一个公共结点
 *		思路：首先遍历两个链表，算出长度k1，k2，假设k1>k2，那么第二次遍历的时候，
 *		先让1链表指针先走k1-k2步，然后一起走，重合的点就是要找的点
 */
public class FindFirstCommonNodeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(6);
		ListNode node5 = new ListNode(7);
		
		ListNode node6 = new ListNode(4);
		ListNode node7 = new ListNode(5);

		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		
		node6.next = node7;
		node7.next = node4;
		
		System.out.println(FindFirstCommonNode(node1, node6).val);
	}
	
	public static void display(ListNode pHead){
		if(pHead == null){
			return;
		}
		ListNode node = pHead;
		while(node != null){
			System.out.println(node.val);
			node = node.next;
		}
	}
	
	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2){
		int length1 = GetListLength(pHead1);
		int length2 = GetListLength(pHead2);
		int diff = Math.abs(length1 - length2);//差值
		
		ListNode pHeadLong = pHead1;//指向较长的链表
		ListNode pHeadShort = pHead2;//指向较短的链表
		
		if( length2 > length1 ){
			pHeadLong = pHead2;
			pHeadShort = pHead1;
		}
		//先让长的走几步
		for(int i = 0; i < diff; i++){
			pHeadLong = pHeadLong.next;
		}
		
		while(pHeadLong != null && pHeadShort != null && pHeadLong != pHeadShort){
			pHeadLong = pHeadLong.next;
			pHeadShort = pHeadShort.next;
		}
		//当退出循环时，两个结点重合
		
		ListNode pFirstCommonNode = pHeadLong;
		return pFirstCommonNode;
	}
	
	//得到链表长度的方法
	public static int GetListLength(ListNode pHead){
		int length = 0;
		ListNode node = pHead;
		while(node != null){
			length++;
			node = node.next;
		}
		
		return length;
	}
}
