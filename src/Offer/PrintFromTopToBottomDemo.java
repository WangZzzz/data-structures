package Offer;

import java.util.Queue;
import java.util.LinkedList;

import javax.swing.text.html.StyleSheet;

import Offer.MyBinaryTree.Node;

/**
 * 
 * @author WangZ
 *	面试题23：从上往下打印二叉树 第137页
 *	题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印
 *	思路：每一层使用队列
 */
public class PrintFromTopToBottomDemo {

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
		preOrder(bt.root);
		System.out.println("*************");
		PrintFromTopToBottom(bt.root);
	}

	private static void PrintFromTopToBottom(BinaryTreeNode root){
		if(root == null){
			return;
		}
		/*
		 * LinkedList :队列：offerFirst --- pollLast
		 *  栈：offerFirst --- pollFirst
		 */
		//模拟队列
		LinkedList<BinaryTreeNode> ll = new LinkedList<BinaryTreeNode>();
		ll.offerFirst(root);
		while(!ll.isEmpty()){
			BinaryTreeNode node = ll.pollLast();
			System.out.println(node.val);
			if(node.pLeft != null){
				ll.offerFirst(node.pLeft);
			}
			if(node.pRight != null){
				ll.offerFirst(node.pRight);
			}
		}
	}
	
	public static void preOrder(BinaryTreeNode node){
		if(node == null){//出口
			return;
		}else{
			System.out.println(node.val);
			preOrder(node.pLeft);
			preOrder(node.pRight);
		}
	}
}
