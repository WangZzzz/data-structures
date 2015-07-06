package Offer;
/*
 * 	面试题27：二叉搜索树与双向链表	151页
 * 	题目：输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表，要求不能创建任何新的结点，
 * 	只能调整树中结点指针的指向
 * 	中序遍历：先左结点，根结点、右结点，正好从小到大
 * 递归解法：
 *	（1）如果二叉树查找树为空，不需要转换，对应双向链表的第一个节点是NULL，最后一个节点是NULL
 *	（2）如果二叉查找树不为空：
 *		如果左子树为空，对应双向有序链表的第一个节点是根节点，左边不需要其他操作；
 *		如果左子树不为空，转换左子树，二叉查找树对应双向有序链表的第一个节点就是左子树转换后双向有序链表的第一个节点,同时将根节点和左子树转换后的双向有序链 表的最后一个节点连接；
 *		如果右子树为空，对应双向有序链表的最后一个节点是根节点，右边不需要其他操作；
 *		如果右子树不为空，对应双向有序链表的最后一个节点就是右子树转换后双向有序链表的最后一个节点，同时将根节点和右子树转换后的双向有序链表的第一个节点连接
 *
 *	在转换成排序双向链表时，原先指向左子结点的指针调整为链表中指向前一个结点的指针，
 *		原先指向右子结点的指针调整为链表中指向下一个结点的指针
 */
public class ConvertDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.insertBST(10);
		bt.insertBST(6);
		bt.insertBST(14);
		bt.insertBST(4);
		bt.insertBST(8);
		bt.insertBST(12);
		bt.insertBST(16);
		
		MidOrder(bt.root);
		System.out.println("**********");
		BinaryTreeNode node = Convert(bt.root);
		BinaryTreeNode current = node;
		while(current != null){
			System.out.print(current.val + " ");
			current = current.pLeft;
		}
		
	}
	/*
	 * 中序遍历
	 */
	public static void MidOrder(BinaryTreeNode node){
		if(node != null){
			MidOrder(node.pLeft);
			System.out.println(node.val);
			MidOrder(node.pRight);
		}
	}
	
	public static BinaryTreeNode Convert(BinaryTreeNode pRootOfTree){
		BinaryTreeNode pLastNodeInList = null;
		ConvertNode(pRootOfTree, pLastNodeInList);
		
		//pLastNodeInList指向双向链表的尾结点
		//我们需要返回头结点
		BinaryTreeNode pHeadOfList = pLastNodeInList;
		while(pHeadOfList != null && pHeadOfList.pLeft != null){
			pHeadOfList = pHeadOfList.pLeft;
		}
		return pHeadOfList;
	}
	
	public static void ConvertNode(BinaryTreeNode pNode, BinaryTreeNode pLastNodeInList){
		if(pNode == null)
			return;
		
		BinaryTreeNode pCurrent = pNode;
		
		if(pCurrent.pLeft != null){
			ConvertNode(pCurrent.pLeft, pLastNodeInList);
		}
		
		pCurrent.pLeft = pLastNodeInList;
		if(pLastNodeInList != null){
			pLastNodeInList.pRight = pCurrent;
		}
		
		pLastNodeInList = pCurrent;
		
		if(pCurrent.pRight != null){
			ConvertNode(pCurrent.pRight, pLastNodeInList);
		}		
	}
}
