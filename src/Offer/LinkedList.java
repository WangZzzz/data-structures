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
}
