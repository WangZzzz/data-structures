package Offer;

/*
 * 	面试题20：顺时针打印矩阵 第127页
 * 	题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 */
public class PrintMatrixClockwiselyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		PrintMatrixClockwisely(arr);
	}
	
	@SuppressWarnings("unused")
	public static void PrintMatrixClockwisely(int[][] nums){
//		System.out.println(nums[1].length);
		if(nums == null && nums.length <= 0){
			//特殊情况
			return;
		}		
		int columns = nums[0].length - 1;
		int rows = nums.length - 1;
		int startX = 0;
		int startY = 0;
		while(startX <= rows && startY <= columns){
			PrintMatrixInCircle(nums, startX, startY, rows, columns);
			startX++;
			startY++;
			rows--;
			columns--;
		}
	}
	
	public static void PrintMatrixInCircle(int[][] nums, int startX, int startY, int rows, int columns){
		
	}

}
