package Offer2;

import Offer.BinaryTreeNode;

/**
 * 
 * @author WangZ
 *	根据前序遍历和中序遍历重建二叉树
 *	中序遍历序列和后序遍历序列，类似的方法可重建二叉树，但前序遍历序列和后序遍历序列不同恢复一棵二叉树，
 */
public class ConstructBinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preOrder = {1,2,4,7,3,5,6,8};
		int[] midOrder = {4,7,2,1,5,3,8,6};
		BinaryTreeNode root = ConstructBinaryTree(preOrder, midOrder);
	}

	public static BinaryTreeNode ConstructBinaryTree(int[] preOrder, int[] midOrder){
		if(preOrder == null || midOrder == null){
			return null;
		}
		
		//前序遍历的第一个值就是根节点的值
		BinaryTreeNode root = new BinaryTreeNode(preOrder[0]);
		root.pLeft = null;
		root.pRight = null;
//		System.out.println(root.val);
		// 查找根节点在中序遍历中的位置，中序遍历中，根节点左边为左子树，右边为右子树  
		int rootPositionInMidOrder = -1;
		for(int i = 0; i < midOrder.length; i++){
			System.out.println(midOrder[i]);
			if(midOrder[i] == root.val){
				rootPositionInMidOrder = i;
				break;
			}
		}
		
		//如果中序遍历中没有前序遍历中的根节点的值，那么输入错误
		if(rootPositionInMidOrder == -1){
			throw new RuntimeException("输入错误！");
		}
		
		
		//重建左子树
		//左子树结点数量
		int nodeNumLeft = rootPositionInMidOrder;
		//左子树前序遍历的序列
		int[] preOrderLeft = new int[nodeNumLeft];
		for(int i = 1, j = 0; i < nodeNumLeft + 1; i++, j++){
			preOrderLeft[j] = preOrder[i];
		}
		//左子树中序遍历的序列
		int[] midOrderLeft = new int[nodeNumLeft];
		for(int i = 0; i < nodeNumLeft; i++){
			preOrderLeft[i] = preOrder[i];
		}
		root.pLeft = ConstructBinaryTree(preOrderLeft, midOrderLeft);
		
		//重建右子树
		//右子树结点数量
		int nodeNumRight = preOrder.length - nodeNumLeft - 1;
		//右子树前序遍历的序列
		int[] preOrderRight = new int[nodeNumRight];
		for(int j = 0, i = nodeNumRight; i < preOrder.length; i++,j++){
			preOrderRight[j] = preOrder[i];
		}
		//右子树中序遍历的序列
		int[] midOrderRight = new int[nodeNumRight];
		for(int i = rootPositionInMidOrder + 1, j = 0; i < preOrder.length; j++, i++){
			midOrderRight[j] = midOrder[i];
		}
		
		root.pRight = ConstructBinaryTree(preOrder, midOrder);
		
		return root;
	}
}
