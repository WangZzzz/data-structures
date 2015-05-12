package Sort;

public class QuickSortDemo {
	/*
	 * ����˼�룺ѡ��һ����׼Ԫ��,ͨ��ѡ���һ��Ԫ�ػ������һ��Ԫ��,ͨ��һ��ɨ�裬
	 * ���������зֳ�������,һ���ֱȻ�׼Ԫ��С,һ���ִ��ڵ��ڻ�׼Ԫ��,
	 *��ʱ��׼Ԫ�������ź�������ȷλ��,Ȼ������ͬ���ķ����ݹ�����򻮷ֵ������֡�
	 *	ʱ�临�Ӷȣ�O(nlog(n))
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		quickSort(data,0,data.length-1);
		for(int i = 0; i < data.length; i++){
			System.out.println(data[i]);
		}
	}
	
	public static void quickSort(int[] data,int l,int r){
		if(l < r){
			int middle = partion(data, l, r);//�õ�һ�ε��м�λ��
			quickSort(data, l, middle-1);//�м�λ�����
			quickSort(data, middle+1, r);//�м�λ���Ҳ�
		}		
	}
	
	public static int partion(int[]data, int l ,int r){
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

}