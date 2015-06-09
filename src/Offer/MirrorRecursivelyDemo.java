package Offer;

import javax.xml.soap.Node;

/*
 *	面试题19：二叉树镜像 第125页
 *	题目：请完成一个函数，输入一个二叉树，该函数输出他的镜像
 *	镜像：左右相反
 *	思路：在遍历树的同时，交换非叶节点的左右子节点
 *	叶节点：没有子节点的结点 
 *	先前序遍历这棵树的每个结点，如果遍历到的结点有子结点，就交换它的两个子节点，
 *		当交换完所有非叶子结点之后，就得到了树的镜像
 */
public class MirrorRecursivelyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.insertBST(5);
		bt.insertBST(8);
		bt.insertBST(3);
		bt.insertBST(10);
		bt.insertBST(6);
		bt.insertBST(1);
		preOrder(bt.root);
		System.out.println("***********");
		MirrorRecursively(bt.root);		
		preOrder(bt.root);
	}
	
	public static void preOrder(BinaryTreeNode node){
		if(node == null){
			return;
		}
		System.out.println(node.val);
		preOrder(node.pLeft);
		preOrder(node.pRight);
	}
	
	public static void MirrorRecursively(BinaryTreeNode node){
		if(node == null)
			return;
		if(node.pLeft == null && node.pRight == null){
			//如果一个结点的左右子结点均为null,则为叶节点，不需要交换
			return;
		}
		
		//临时结点保存数据
		BinaryTreeNode tmpNode = node.pLeft;
		node.pLeft = node.pRight;
		node.pRight = tmpNode;
		
		if(node.pLeft != null){//遍历左子结点
			MirrorRecursively(node.pLeft);
		}
		
		if(node.pRight != null){//遍历右子结点
			MirrorRecursively(node.pRight);
		}
		
	}
}
