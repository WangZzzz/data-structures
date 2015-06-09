package Offer;


public class BinaryTree {
	BinaryTreeNode root;
	public BinaryTree(){
		root = null;
	}
	
	public void insertBST(int data){//�ڶ����������в�������
		BinaryTreeNode node = new BinaryTreeNode(data);
		if(root == null){
			//��ʱû��Ԫ��
			root = node;
			root.pLeft = null;
			root.pRight = null;
		}else{
			BinaryTreeNode current = root;
			BinaryTreeNode parent = null;
			while(true){
				if(data < current.val){//��������С�����ĸ�����ֵ
					parent = current;
					current = current.pLeft;
					if(current == null){//˵���ҵ����һ����
						parent.pLeft = node;
						break;
					}
				}else{//��������ֵ���Ǵ��ڵ������ĸ�����ֵ
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
