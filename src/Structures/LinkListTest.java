package Structures;
/*
 * ��������Գ���
 */

public class LinkListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList<String> ll = new LinkList<String>();
		ll.addFirstNode("test1");
		ll.addFirstNode("test2");
		ll.addFirstNode("test3");
		ll.addFirstNode("test4");
		ll.displayAllNodes();		
		//ɾ��ָ������λ�õĽڵ�
		System.out.println("delete:"+ll.deleteByIndex(1).getT());		
		//��ָ��λ�ò���ڵ�
		ll.addByIndex(2, "test5");
		ll.displayAllNodes();
		//�������ݲ��ҽڵ�����
		System.out.println("index:"+ll.IndexOf("test5"));
		//�����������ҽڵ�
		System.out.println("data:"+ll.findByIndex(2).getT());
		
	}

}
