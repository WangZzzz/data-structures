package Structures;
/*
 * 单链表测试程序
 */

public class LinkListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList<String> ll = new LinkList<String>();
		ll.addFirstNode("test1");
		ll.addFirstNode("test2");
		ll.addFirstNode("test3");
		ll.addFirstNode("test4");
		ll.displayAllNodes1();
		System.out.println("******");
		ll.displayAllNodes2();	
		System.out.println("******");
		ll.displayAllNodes3(ll.head);
		System.out.println("******");
		ll.clear();
		System.out.println("******");
		ll.displayAllNodes1();
		
		
/*		//删除指定索引位置的节点
		System.out.println("delete:"+ll.deleteByIndex(1).getT());		
		//在指定位置插入节点
		ll.addByIndex(2, "test5");
		ll.displayAllNodes();
		//根据数据查找节点索引
		System.out.println("index:"+ll.IndexOf("test5"));
		//根据索引查找节点
		System.out.println("data:"+ll.findByIndex(2).getT());*/
		
	}

}
