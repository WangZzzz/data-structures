package Leetcode;

import java.awt.List;
import java.util.ArrayList;

/*
 * 	144题：给一个二叉树，返回线序遍历的结果
 */
public class preorderTraversalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

}

class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
}
class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        //题目：返回先序遍历的结果
        ArrayList<Integer> al = new ArrayList<Integer>();
        pre(al,root);//使用递归的方法先序遍历，传入ArrayList存储数据
        
        return al;
    }
    
    public void pre(ArrayList<Integer> al,TreeNode node){
        if(node == null){
            return;
        }
        al.add(node.val);
        pre(al,node.left);
        pre(al,node.right);
    }
}