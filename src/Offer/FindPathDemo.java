package Offer;

import java.util.Stack;

/**
 * 
 * @author WangZ 面试题25：二叉树中和为某一值得路径 143页
 *         题目：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径，从树的根节点开始往下一直到叶结点所经过的 结点形成一条路径。
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
		// preOrder(bt.root);

		FindPath(bt.root, 22);
	}

	private static void FindPath(BinaryTreeNode root, int expectedSum) {
		if (root == null) {
			return;
		}

		Stack<Integer> path = new Stack<Integer>();
		int currentSum = 0;// 当前的和
		FindPath(root, expectedSum, path, currentSum);
	}

	private static void FindPath(BinaryTreeNode root, int expectedSum,
			Stack<Integer> path, int currentSum) {
		currentSum = currentSum + root.val;
		path.push(root.val);

		// 如果是叶节点且路径上结点的和等于输入的值
		// 打印出这条路径
		boolean isLeaf = ((root.pLeft == null) && (root.pRight == null));
		if (isLeaf && currentSum == expectedSum) {
			System.out.print("A path is found : ");
			for (int i : path) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}

		// 如果不是叶结点，则遍历他的子节点
		if (root.pLeft != null) {
			FindPath(root.pLeft, expectedSum, path, currentSum);
		}
		if (root.pRight != null) {
			FindPath(root.pRight, expectedSum, path, currentSum);
		}

		// 在返回父节点之前，在路径上删除当前结点
		path.pop();
	}

	private static void preOrder(BinaryTreeNode root) {
		if (root != null) {
			System.out.println(root.val);
			preOrder(root.pLeft);
			preOrder(root.pRight);
		}
	}
}
