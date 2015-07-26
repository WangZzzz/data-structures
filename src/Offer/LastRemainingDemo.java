package Offer;

/**
 * 
 * @author WangZ
 *	������45��ԲȦ�����ʣ�µ����� 229ҳ
 *	��Ŀ��0,1,...,n-1��n�������ų�һ��ԲȦ��������0��ʼÿ�δ����ԲȦ���޳���m�����֣�������ԲȦ��ʣ�µ����һ������
 *	˼·�������뵽��˼·��ʹ��ѭ������,�����㷨��ʱ�临�Ӷ�ΪO(mn)��ͬʱ����Ҫһ�����������ռ临�Ӷ�ΪO(n)
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
		
		//��β����ӽ��
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
					//ɾ����ǰ��㣬����ɾ��������һ�����
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
