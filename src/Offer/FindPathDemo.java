package Offer;
/**
 * 
 * @author WangZ
 *	面试题25：二叉树中和为某一值得路径  143页
 *		题目：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径，从树的根节点开始往下一直到叶结点所经过的
 *	结点形成一条路径。
 */

public class FindPathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.insertBST(10);
		bt.insertBST(5);
		bt.insertBST(4);
		bt.insertBST(7);
		bt.insertBST(12);
		preOrder(bt.root);
	}
	
	private static void preOrder(BinaryTreeNode root){
		if(root != null){
			System.out.println(root.val);
			preOrder(root.pLeft);
			preOrder(root.pRight);
		}
	}
}
