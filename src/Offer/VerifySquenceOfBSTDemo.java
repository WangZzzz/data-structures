package Offer;

/**
 * 
 * @author WangZ
 *  面试题24：二叉搜索树的后序遍历序列 第140页
 *  	题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后续遍历的结果，是返回true，否返回false
 *	思路：根节点肯定是最后一个，然后从左往右遍历，找到第一个比根节点大的值，则前面的值，为左子树的值，后面的值，
 *		只能比根节点小，而不能比根节点大
 */
public class VerifySquenceOfBSTDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {5,7,6,9,11,10,8};
		System.out.println(VerifySquenceOfBST(arr1, arr1.length));
		
		int[] arr2 = {7,4,6,5};
		System.out.println(VerifySquenceOfBST(arr2, arr2.length));
	}
	
	public static boolean VerifySquenceOfBST(int[] sequence, int length){
		if(sequence == null || sequence.length <= 0){
			return false;
		}
		
		//根节点永远是最后一个结点
		int root = sequence[length - 1];
		
		//在二叉搜索树中左子树的结点小于根节点
		int i = 0;
		for(i = 0; i < length - 1; i++){
			if(sequence[i] > root){
				//找到了第一个比根节点大的值，左边为左子树的值
				break;
			}
		}
		
		int j = i;
		for(; j < length -1; j++){
			if(sequence[j] < root){
				//找到了第一个比根节点大的值，那么他的右侧的值，应该都比根节点大
				return false;
			}
		}
		//递归调用判断左子树是不是二叉树的值
		boolean left = true;
		if(i > 0)
			left = VerifySquenceOfBST(sequence, i);
		boolean right = true;
		if(i < length - 1)
			//右侧长度：length - (i + 1)
			right = VerifySquenceOfBST(sequence, length - (i + 1));
		
		return left && right;
	}

}
