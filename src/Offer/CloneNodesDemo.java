package Offer;
/**
 * 
 * @author WangZ
 *	面试题26：复杂链表的复制 147页
 *		题目：复制一个复杂链表，在复杂链表中，每个结点除了有一个pNext指针指向下一个结点外，还有一个pSibling指向链表中的任意结点或者NULL
 */
public class CloneNodesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * 一共三步
	 */
	public static ComplexListNode Clone(ComplexListNode pHead){
		CloneNodes(pHead);
		ConnectSiblingNodes(pHead);
		return ReconnectNodes(pHead);
	}
	
	/*
	 * 第一步：根据原始链表的每个结点N创建对应的N`，把N`连接在N的后面
	 */
	public static void CloneNodes(ComplexListNode pHead){
		ComplexListNode pNode = pHead;
		while(pNode != null){
			ComplexListNode pCloned = new ComplexListNode();
			pCloned.val = pNode.val;
			pCloned.pNext = pNode.pNext;
			pCloned.pSibling = null;			
			
			pNode.pNext = pCloned;
			
			pNode = pCloned.pNext;
		}
	}
	
	/*
	 * 第二步：设置复制出来的结点的pSibling，假设原始链表上的N的pSibling指向结点S,
	 * 那么其对应复制出来的N`是N的pNext指向的结点，同样S`也是S的pNext指向的结点
	 */
	public static void ConnectSiblingNodes(ComplexListNode pHead){
		ComplexListNode pNode = pHead;
		while(pNode != null){
			ComplexListNode pCloned = pNode.pNext;
			if(pCloned.pSibling != null){
				pCloned.pSibling = pNode.pSibling.pNext;
			}
			
			pNode = pCloned.pNext;
		}
	}
	
	/*
	 * 第三步：拆分链表，把长链表拆分成两个链表，把奇数位置的结点用pNext链接起来就是原始链表，
	 * 把偶数位置的结点，用pNext链接起来就是复制出来的结点
	 */
	public static ComplexListNode ReconnectNodes(ComplexListNode pHead){
		ComplexListNode pNode = pHead;
		ComplexListNode pClonedHead = null;
		ComplexListNode pClonedNode = null;
		if(pNode != null){
			pClonedNode = pClonedHead = pHead.pNext;
			//跳过中间的Clone的结点
			pNode.pNext = pClonedNode.pNext;
			pNode = pNode.pNext;
		}
		/*
		 * pNode一直在pCloned的后面
		 */
		while(pNode != null){
			pClonedNode.pNext = pNode.pNext;
			pClonedNode = pClonedNode.pNext;
			pNode.pNext = pClonedNode.pNext;
			pNode = pNode.pNext;
		}
		
		return pClonedHead;
	}
}

class ComplexListNode{
	int val;
	ComplexListNode pNext;
	ComplexListNode pSibling;
	
	public ComplexListNode(){
		
	}
}
