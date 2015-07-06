package Offer;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 二叉搜索树的搜索和其他元素操作的时间复杂度是O(logn)
 */
public class BinaryTree {
	BinaryTreeNode root;
	public BinaryTree(){
		root = null;
	}
	
	public void insertBT(int data){
		//完全二叉树中插入数据
		BinaryTreeNode node = new BinaryTreeNode(data);
		
		if(root == null){
			root = node;
		}else{
			LinkedList<BinaryTreeNode> ll = new LinkedList<BinaryTreeNode>();
			ll.offerFirst(root);
			while(!ll.isEmpty()){
				BinaryTreeNode temp = ll.pollLast();
				if(temp.pLeft == null){
					temp.pLeft = node;
					return;
				}else if(temp.pRight == null){
					temp.pRight = node;
					return;
				}else{
					ll.offerFirst(temp.pLeft);
					ll.offerFirst(temp.pRight);
				}
			}
		}
	}
	
	public void insertBST(int data){//在二叉搜索树中插入数据
		BinaryTreeNode node = new BinaryTreeNode(data);
		if(root == null){
			//此时没有元素
			root = node;
			root.pLeft = null;
			root.pRight = null;
		}else{
			BinaryTreeNode current = root;
			BinaryTreeNode parent = null;
			while(true){
				if(data < current.val){//左子树均小于它的根结点的值
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
}
