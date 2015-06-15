package Offer;

import java.util.Queue;
import java.util.LinkedList;

import javax.swing.text.html.StyleSheet;

import Offer.MyBinaryTree.Node;

/**
 * 
 * @author WangZ
 *	������23���������´�ӡ������ ��137ҳ
 *	��Ŀ���������´�ӡ����������ÿ����㣬ͬһ��Ľ�㰴�մ����ҵ�˳���ӡ
 *	˼·��ÿһ��ʹ�ö���
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
		 * LinkedList :���У�offerFirst --- pollLast
		 *  ջ��offerFirst --- pollFirst
		 */
		//ģ�����
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
		if(node == null){//����
			return;
		}else{
			System.out.println(node.val);
			preOrder(node.pLeft);
			preOrder(node.pRight);
		}
	}
}
