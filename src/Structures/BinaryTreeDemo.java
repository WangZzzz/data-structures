package Structures;

import java.util.Queue;


public class BinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {20,15,6,18,3,1,9,33,30,36};
		BinaryTree bst = new BinaryTree();
		for(int i : arr){
			bst.insertBST(i);
		}
		bst.PreOrderTraverse(bst.root);
		System.out.println("************");
	/*	bst.inOrderTraverse(bst.root);
		System.out.println("************");
		bst.AftOrderTraverse(bst.root);*/
		System.out.println("NodeNum : " + bst.getNodeNum(bst.root));
		System.out.println("Depth : " + bst.GetDepth(bst.root));
	}

}


class BinaryTree{
	class Node{
		int data;
		Node pLeft;
		Node pRight;
		public Node(int data){
			this.data = data;
			pLeft = null;
			pRight = null;
		}
	}
	
	public Node root;//根节点 
	
	public void insertBST(int data){//在二叉搜索树中插入数据
		Node node = new Node(data);
		if(root == null){
			//此时没有元素
			root = node;
			root.pLeft = null;
			root.pRight = null;
		}else{
			Node current = root;
			Node parent = null;
			while(true){
				if(data < current.data){//左子树均小于它的根结点的值
					parent = current;
					current = current.pLeft;
					if(current == null){//说明找到最后一层了
						parent.pLeft = node;
						break;
					}
				}else{//右子树的值总是大于等于它的根结点的值
					parent = current;
					current = current.pRight;
					if(current == null){
						parent.pRight = node;
						break;
					}
				}
			}
		}
	}
	
	public void PreOrderTraverse(Node node){//前序遍历--即先根遍历,通过递归方式
		if(node == null){//出口
			return;
		}
		System.out.println(node.data);
		PreOrderTraverse(node.pLeft);
		PreOrderTraverse(node.pRight);
	}
	
	public void inOrderTraverse(Node node){//中序遍历,通过递归方式
		if(node == null){//出口
			return;
		}
		inOrderTraverse(node.pLeft);
		System.out.println(node.data);
		inOrderTraverse(node.pRight);
	}
	
	public void AftOrderTraverse(Node node){//后序遍历,通过递归方式
		if(node == null){//出口
			return;
		}
		AftOrderTraverse(node.pLeft);
		AftOrderTraverse(node.pRight);
		System.out.println(node.data);
	}
	
	public void LevelTraverse(Node node){//宽度优先遍历，顺序为从上往下，从左往右
		
	}
	
	/*
	 * 	 求二叉树中的节点个数:
	 * 	思路：（1）如果二叉树为空，节点个数为0
				（2）如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
	 */
	public int getNodeNum(Node node){
		if(node == null){//递归出口
			return 0;
		}
		return getNodeNum(node.pLeft) + getNodeNum(node.pRight) + 1;
	}
	
	/*
	 * 求二叉树的深度：
	 * 	1.如果二叉树为空，深度为0
	 *	2.如果二叉树不为空，深度为max(左子树深度，右子树深度)+1
	 */
	public int GetDepth(Node node){
		if(node == null){//递归出口
			return 0;
		} 
		int depthLeft = GetDepth(node.pLeft);
		int depthRight = GetDepth(node.pRight);
		
		return Math.max(depthLeft, depthRight) + 1;
	}
	
	/*
	 * 非递归实现前序遍历
	 */
}