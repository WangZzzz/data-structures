package Offer;


public class BinaryTree {
	BinaryTreeNode root;
	public BinaryTree(){
		root = null;
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
