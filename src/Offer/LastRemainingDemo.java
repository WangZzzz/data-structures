package Offer;

/**
 * 
 * @author WangZ
 *	面试题45：圆圈中最后剩下的数字 229页
 *	题目：0,1,...,n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里剔除第m个数字，求出这个圆圈里剩下的最后一个数字
 *	思路：最先想到的思路是使用循环链表,此种算法的时间复杂度为O(mn)，同时还需要一个辅助链表，空间复杂度为O(n)
 */

public class LastRemainingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LastRemaining(5, 3));
	}

	public static int LastRemaining(int n, int m){
		CircledList cll = new CircledList();
		
		for(int i = 0; i < n; i++){
			cll.insert(i);
		}
		cll.displayAll();
		return cll.Josephuse(m);
	}
	
	public static class CircledList{
		class Node{
			int val;
			Node next;
			
			Node(int val){
				this.val = val;
				this.next = null;
			}
		}
		
		private Node pHead;
		private Node pTail;
		public int size = 0;
		
		public CircledList(){
			pHead = pTail = null;
		}
		
		//在尾部添加结点
		public void insert(int val){
			Node node = new Node(val);
			if(pHead == null){
				pHead = node;
				pTail = node;
				pTail.next = pHead;
				size++;
			}else{
				node.next = pHead;
				pTail.next = node;
				pTail = node;
				size++;
			}
		}
		
		public void displayAll(){
			Node current = pHead;
			while(true){
//				System.out.println(current.val);
				current = current.next;
				if(current == pHead){
					break;
				}
			}
		}
		
		public int Josephuse(int m){
			int res = 0;
			int cnt = 0;
			Node current = pHead;
			while(size != 0){
				if(cnt == (m - 1)){
					cnt = 0;
//					System.out.println(current.val);
					if(size == 1){
						res = current.val;
					}
					//删除当前结点，可以删除它的下一个结点
					Node tmp = current.next;
					current.val = tmp.val;
					current.next = tmp.next;
					size--;
					tmp.next = null;
				}else{
					current = current.next;
					cnt++;
				}
			}
			return res;
		}
		
	}
}
