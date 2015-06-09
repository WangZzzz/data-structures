package Offer;

import java.util.Arrays;

/*	面试题6：第55页,前序遍历序列{1,2,4,7,3,5,6,8} 中序遍历{4,7,2,1,5,3,8,6}
 * 	根据前序遍历和中序遍历的结果，重建二叉树
 * 	1.前序遍历的第一个值，一定是根节点的值
 * 	2.中序遍历中，1中找到的根节点的值得左侧，是左子树中序遍历的值，右侧是右子树中序遍历的值
 * 	3.递归  
 */
public class RebuildBinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		int[] preOrder = {1,2,4,7,3,5,6,8};
		int[] inOrder = {4,7,2,1,5,3,8,6};*/
		int[] preOrder = {1,2,3,4};
		int[] inOrder = {4,3,2,1};
		MyBinaryTree.Node root = MyBinaryTree.rebuildBinaryTree(preOrder, inOrder, preOrder.length);
		MyBinaryTree.preOrder(root);
		System.out.println("*******");
		MyBinaryTree.inOrder(root);
		System.out.println("*******");
		MyBinaryTree.aftOrder(root);
	}

}

class MyBinaryTree{
	static class Node{
		int data;
		Node left;
		Node right;
		Node(){
		}
		Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	public Node root;//根节点
	public MyBinaryTree() {
		// TODO Auto-generated constructor stub
		root = null;
	}
	
	/*
	 * 根据前序遍历和中序遍历的结果，重建二叉树 
	 * 	递归解法：
	 *	1.如果前序遍历为空或中序遍历为空或节点个数小于等于0，返回NULL。
	 *	2.创建根节点。前序遍历的第一个数据就是根节点的数据，在中序遍历中找到根节点的位置，可分别得知左子树和右子树的前序和中序遍
	 *	历序列，重建左右子树
	 */
	public static Node rebuildBinaryTree(int[] preOrder, int[] inOrder, int nodeNum){
		if(preOrder == null || inOrder == null || nodeNum <= 0){
			return null;
		}
	/*	for(int i : preOrder){
			System.out.print(i + "");
		}
		System.out.println();
		for(int i : inOrder){
			System.out.print(i + "");
		}
		System.out.println();*/
		Node root = new Node();
		root.data = preOrder[0];//前序遍历的第一个值为根节点的值
		root.left = null;
		root.right = null;
		int rootPositionInOrder = -1;//根节点在中序遍历中的位置
		for(int i = 0; i < inOrder.length; i++){
			if(inOrder[i] == preOrder[0]){
				rootPositionInOrder = i;
				break;
			}
		}
		
		if(rootPositionInOrder == -1){
			throw new RuntimeException("输入序列错误！");
		}
		
		int nodeNumLeft = rootPositionInOrder;//左子树的节点个数，中序遍历数组中根节点左边的数字个数
		//从原先序遍历中截取左子树的先序遍历
		int[] preOrderLeft = Arrays.copyOfRange(preOrder, 1, rootPositionInOrder + 1);
		//从原中序遍历中截取左子树的中序遍历
		int[] inOrderLeft = Arrays.copyOfRange(inOrder, 0, rootPositionInOrder);
		root.left = rebuildBinaryTree(preOrderLeft, inOrderLeft, nodeNumLeft);
		
		int nodeNumRight = nodeNum - rootPositionInOrder - 1;//右子树的节点个数
		//从原先序遍历中截取右子树的先序遍历
		int[] preOrderRight = Arrays.copyOfRange(preOrder, nodeNum - rootPositionInOrder - 1, nodeNum);
		//从原中序遍历中截取右子树的中序遍历
		int[] inOrderRight = Arrays.copyOfRange(inOrder, rootPositionInOrder + 1, nodeNum);
		root.right = rebuildBinaryTree(preOrderRight, inOrderRight, nodeNumRight);
		
		return root;
	}

	public static void preOrder(Node node){
		if(node == null){//出口
			return;
		}else{
			System.out.println(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public static void inOrder(Node node){
		if(node == null){//出口
			return;
		}else{
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}
	
	public static void aftOrder(Node node){
		if(node == null){//出口
			return;
		}else{
			aftOrder(node.left);
			aftOrder(node.right);
			System.out.println(node.data);
		}
	}
}
