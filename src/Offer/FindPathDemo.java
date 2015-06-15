package Offer;
/**
 * 
 * @author WangZ
 *	������25���������к�Ϊĳһֵ��·��  143ҳ
 *		��Ŀ������һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·���������ĸ��ڵ㿪ʼ����һֱ��Ҷ�����������
 *	����γ�һ��·����
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
