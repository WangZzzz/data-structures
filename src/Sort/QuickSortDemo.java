package Sort;

import java.util.Arrays;
import java.util.Random;


public class QuickSortDemo {
	/*
	 * ����˼�룺ѡ��һ����׼Ԫ��,ͨ��ѡ���һ��Ԫ�ػ������һ��Ԫ��,ͨ��һ��ɨ�裬
	 * ���������зֳ�������,һ���ֱȻ�׼Ԫ��С,һ���ִ��ڵ��ڻ�׼Ԫ��,
	 *��ʱ��׼Ԫ�������ź�������ȷλ��,Ȼ������ͬ���ķ����ݹ�����򻮷ֵ������֡�
	 *	ʱ�临�Ӷȣ�O(nlog(n))
	 *	�����������Ѿ�������߷���ʱ�临�Ӷ�O(n^2)
	 *	��õ�����£�����ֵ��������ֲ���O(nlogn);
	 *	ƽ���㷨ʱ�临�Ӷȣ�O(n^2)
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		quickSort(data,0,data.length-1);
		System.out.println(Arrays.toString(data));
	}
	
	public static void quickSort(int[] data,int l,int r){
		if(l >= r){
			return;
		}
		int middle = partion(data, l, r);//�õ�һ�ε��м�λ��
		quickSort(data, l, middle-1);//�м�λ�����
		quickSort(data, middle+1, r);//�м�λ���Ҳ�	
	}
	
	public static int partion(int[]data, int l ,int r){
		if(data == null || data.length <= 0 || l < 0 || r >= data.length){
			throw new RuntimeException("�������");
		}		
		Random random = new Random();
		int ranNum = random.nextInt(r - l + 1) + l;//��һ�����⣬��Զȡ�����ұ߽�
		swap(data,l,ranNum);

		int tmp = data[l];
		while(l < r){
			while((l < r) && (data[r] >= tmp))
				r--;
			data[l] = data[r];
			while((l < r) && (data[l] <= tmp))
				l++;
			data[r] = data[l];
		}
		//��l=rʱ�����λ�þ���tmp��λ��
		data[l] = tmp;
		return l;//���м��λ�÷���
	}
	
	private static void swap(int[] data,int i, int j){
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
}
