package Offer;
/**
 * 
 * @author WangZ
 *	������37����������ĵ�һ��������� 193ҳ
 *		��Ŀ���������������ҳ����ǵĵ�һ���������
 *		˼·�����ȱ������������������k1��k2������k1>k2����ô�ڶ��α�����ʱ��
 *		����1����ָ������k1-k2����Ȼ��һ���ߣ��غϵĵ����Ҫ�ҵĵ�
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
		int diff = Math.abs(length1 - length2);//��ֵ
		
		ListNode pHeadLong = pHead1;//ָ��ϳ�������
		ListNode pHeadShort = pHead2;//ָ��϶̵�����
		
		if( length2 > length1 ){
			pHeadLong = pHead2;
			pHeadShort = pHead1;
		}
		//���ó����߼���
		for(int i = 0; i < diff; i++){
			pHeadLong = pHeadLong.next;
		}
		
		while(pHeadLong != null && pHeadShort != null && pHeadLong != pHeadShort){
			pHeadLong = pHeadLong.next;
			pHeadShort = pHeadShort.next;
		}
		//���˳�ѭ��ʱ����������غ�
		
		ListNode pFirstCommonNode = pHeadLong;
		return pFirstCommonNode;
	}
	
	//�õ������ȵķ���
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
