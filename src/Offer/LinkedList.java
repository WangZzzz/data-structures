package Offer;
class LinkedList{
	public ListNode head;
	public LinkedList(){
		head = null;
	}
	public void addFirst(int val){
		ListNode node = new ListNode(val);
		if(head == null){
			head = node;
		}else{
			node.next = head;
			head = node;
		}
	}
	
	public void disPlay(){
		if(head == null){
			return;
		}
		ListNode current = head;
		while(current != null){
			System.out.println(current.val);
			current = current.next;
		}
	}
}
