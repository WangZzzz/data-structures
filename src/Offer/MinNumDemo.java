package Offer;

import javax.print.attribute.standard.NumberUpSupported;

/*
 * 面试题8：旋转数组的最小数字
 */
public class MinNumDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {1,0,1,1,1};
		System.out.println(method(data));
	}
	
	public static int method(int[] data){
		if(data == null || data.length <= 0){
			throw new RuntimeException("输入数组错误！");
		}
		int l = 0;
		int r = data.length - 1;
		int mid = l;
		while(data[l] >= data[r]){//当数组的第一个元素小于最后一个元素时，说明数组本身就是有序的,则第一个元素就是最小的，直接返回 
			if(r - l == 1){
				mid = r;
				break;
			}
			mid = (l + r) / 2;
			if(data[l] == data[mid] && data[mid] == data[r]){
				//当3个位置数字相等时，此部分只能顺序查找{0,1,1,1,1}的两个旋转数组
				//{1,0,1,1,1},{1,1,1,0,1},
				return MinInOrder(data, l, r);
			}
			if(data[mid] >= data[l]){
				l = mid;
			}else if(data[mid] <= data[r]){
				r = mid;
			}
		}
		return data[mid];
	}
	
	public static int MinInOrder(int[] data, int l, int r){
		int min = l;
		for(int i = l + 1; i <= r; i++){
			if(data[i] < data[min]){
				min = i;
			}
		}
		return data[min];
	}
}
