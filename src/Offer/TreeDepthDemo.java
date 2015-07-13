package Offer;
import java.util.DuplicateFormatFlagsException;

/**
 * 
 * @author WangZ
 *	面试题39：二叉树的深度 207页
 *	题目一：输入一颗二叉树的根节点，求该树的深度，从根结点到叶结点一次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 *
 *	题目二：输入一颗二叉树的根结点，判断该树是不是平衡二叉树，如果某二叉树中任意结点的左右子树的深度相差不超过１，那么他就是一颗平衡二叉树，
 *	
 *	平衡二叉树：左右子树的深度相差不超过1
 */
public class TreeDepthDemo {

	public static int pDepth = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode root = new BinaryTreeNode(10);
		BinaryTreeNode node1 = new BinaryTreeNode(5);
		BinaryTreeNode node2 = new BinaryTreeNode(13);
		BinaryTreeNode node3 = new BinaryTreeNode(2);
		BinaryTreeNode node4 = new BinaryTreeNode(1);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		
		root.pLeft = node1;
		node1.pLeft = node2;
		node1.pRight = node3;
		node2.pLeft = node4;
		node4.pLeft = node5;
		preOrder(root);
		System.out.println("***********");
		System.out.println(TreeDepth(root));
		System.out.println("***********");
		System.out.println(IsBalanced(root));
	}
	
	
	public static void preOrder(BinaryTreeNode node){
		if(node == null){
			return;
		}
		System.out.println(node.val);
		preOrder(node.pLeft);
		preOrder(node.pRight);
	}
	
	//题目一：求二叉树的深度 
	public static int TreeDepth(BinaryTreeNode pRoot){
		if(pRoot == null){
			return 0;
		}
		
		int nLeft = TreeDepth(pRoot.pLeft);//左边
		int nRight = TreeDepth(pRoot.pRight);//右边	
		
		return (nLeft > nRight) ? (nLeft + 1) : (nRight + 1);
	}
	
	//题目二：判断是不是平衡二叉树，借助于求二叉树的深度
	public static boolean IsBalanced(BinaryTreeNode pRoot){
		if(pRoot == null){
			return true;
		}
		
		int left = TreeDepth(pRoot.pLeft);
		int right = TreeDepth(pRoot.pRight);
		
		int diff = left - right;
		if(diff > 1 || diff < -1){
			return false;
		}		
		return IsBalanced(pRoot.pLeft) && IsBalanced(pRoot.pRight);
	}
	
	/*
	 * 	上面这种遍历方式，一个结点会被重复遍历多次,可以利用后续遍历，后续遍历：左结点、右结点、根结点，
	 * 	在遍历一个结点之前我们就已经便利了它的左右子树，只要在遍历每个结点的时候记录它的深度（某一结点的深度等于它到叶结点的路径的长度，
	 * 	），我们就可以一边遍历一边判断每个结点是不是平衡的
	 */
		
}
