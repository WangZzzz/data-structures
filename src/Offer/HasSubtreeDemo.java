package Offer;

import org.omg.CORBA.PUBLIC_MEMBER;

/*
 * 	面试题18：树的子结构 第117页
 * 	题目：输入两颗二叉树A和B,判断B是不是A的子结构
 * 
 * 	思路：第一步在树A中找到和树B的根节点的值一样的结点R；
 * 第二步，再判断树A中以R为结点的子树是不是包含和树B一样的结构
 */
public class HasSubtreeDemo {
	public static void main(String[] args){
		BinaryTree bt1 = new BinaryTree();
		bt1.insertBST(5);
		bt1.insertBST(8);
		bt1.insertBST(3);
		bt1.insertBST(10);
		bt1.insertBST(6);
		bt1.insertBST(1);
		preOrder(bt1.root);
		BinaryTree bt2 = new BinaryTree();
		bt2.insertBST(8);
		bt2.insertBST(10);
		bt2.insertBST(6);
		preOrder(bt2.root);
		System.out.println(HasSubtree(bt1.root, bt2.root));
	}
	
	public static boolean HasSubtree(BinaryTreeNode root1, BinaryTreeNode root2){
		boolean result = false;
		if(root1 != null && root2 != null){
		
			if(root1.val == root2.val)
				result = DoesTree1HaveTree2(root1, root2);		
			if(!result)
				result = HasSubtree(root1.pLeft, root2);
			if(!result)
				result = HasSubtree(root1.pRight, root2);
		}
		return result;
	}
		
	public static boolean DoesTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2){
		if(root2 == null){
			return true;
		}
		if(root1 == null){
			return false;
		}
		if(root1.val != root2.val){
			return false;
		}
		
		return DoesTree1HaveTree2(root1.pLeft, root2.pLeft) && DoesTree1HaveTree2(root1.pRight, root2.pRight);
	}
	
	public static void preOrder(BinaryTreeNode node){
		if(node == null){
			return;
		}
		System.out.println(node.val);
		preOrder(node.pLeft);
		preOrder(node.pRight);
	}
	
}
