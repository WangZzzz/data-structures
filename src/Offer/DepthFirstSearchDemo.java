package Offer;

import java.util.LinkedList;

/**
 * 
 * @author WangZ
 * 	深度优先遍历，先从上到下打印完一个分支，在打印别的分支，使用栈来实现
 * 		！！！ 即为先序遍历
 *
 *
 */
public class DepthFirstSearchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.insertBST(8);
		bt.insertBST(6);
		bt.insertBST(10);
		bt.insertBST(5);
		bt.insertBST(7);
		bt.insertBST(9);
		bt.insertBST(11);
		DepthFirstSearch(bt.root);
		System.out.println("*****");
		PreOrder(bt.root);
	}
	
	public static void DepthFirstSearch(BinaryTreeNode root){
		LinkedList<BinaryTreeNode> ll = new LinkedList<BinaryTreeNode>();
		ll.offerFirst(root);
		
		while(!ll.isEmpty()){
			BinaryTreeNode tmpNode = ll.pollFirst();
			System.out.println(tmpNode.val);
			if(tmpNode.pRight != null){
				ll.offerFirst(tmpNode.pRight);
			}
			
			if(tmpNode.pLeft != null){
				ll.offerFirst(tmpNode.pLeft);
			}
		}
	}
	
	public static void PreOrder(BinaryTreeNode root){
		if(root != null){
			System.out.println(root.val);
			PreOrder(root.pLeft);
			PreOrder(root.pRight);
		}
	}

}
