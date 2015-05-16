package Sort;

import java.util.Arrays;

/*
 * �鲢���򣺹鲢��Merge�������ǽ����������������ϣ������ϲ���һ���µ������
 * ���Ѵ��������з�Ϊ���ɸ������У�ÿ��������������ġ�Ȼ���ٰ����������кϲ�Ϊ�����������С�
 *	ʱ�临�Ӷ�����ΪO(n)
 *	1.�ϲ������������飺
 *		����ǳ��򵥣�ֻҪ�ӱȽ϶������еĵ�һ������˭С����ȡ˭��ȡ�˺���ڶ�Ӧ������ɾ���������
 *		Ȼ���ٽ��бȽϣ����������Ϊ�գ���ֱ�ӽ���һ�����е���������ȡ�����ɡ�
 *	2.�鲢���򣺽�����ֳɶ���A��B�������������ڵ����ݶ�������ģ���ô�Ϳ��Ժܷ���Ľ���������ݽ�������
 *		�����������������������ˣ�
 *		���Խ�A��B������ٷֳɶ��顣�������ƣ����ֳ�����С��ֻ��һ������ʱ��������Ϊ���С�������Ѿ��ﵽ������
 *		Ȼ���ٺϲ����ڵĶ���С��Ϳ����ˡ�����ͨ���ȵݹ�ķֽ����У��ٺϲ����о�����˹鲢����
 *
 *	�鲢�����Ч���ǱȽϸߵģ������г�ΪN�������зֿ���С����һ��ҪlogN����ÿ������һ���ϲ��������еĹ��̣�
 *	ʱ�临�Ӷȿ��Լ�ΪO(N)����һ��ΪO(N*logN)����Ϊ�鲢����ÿ�ζ��������ڵ������н��в��������Թ鲢������O(N*logN)
 *	�ļ������򷽷����������򣬹鲢����ϣ�����򣬶�����Ҳ��Ч�ʱȽϸߵġ�
 */
public class MergeSortDemo {
	public static void main(String[] args){
		int[] data = {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		mergeSort(data, 0, data.length-1);
		System.out.println(Arrays.toString(data));
	}
	
	/*
	 * 	�ϲ������������У�data[low~mid],data[mid~high]
	 */
	public static void merge(int[] data, int low, int mid, int high){
		int[] tmp = new int[high - low + 1];
		int i = low;//��ָ�룬����low~mid��ߵ�����
		int j = mid + 1;//��ָ�룬����mid+1~high��ߵ�����
		int k = 0;//����������

		System.out.println("left side : ");
		for(int m = low; m <= mid; m++){
			System.out.print(data[m] + " ");
		}
		System.out.println();
		System.out.println("right side : ");
		for(int m = mid + 1; m <= high; m++){
			System.out.print(data[m] + " ");
		}
		System.out.println();
		//�Ƚ����������н�С�����Ƶ���ʱ����
		while(i <= mid && j <= high){
			if(data[i] < data[j])
			{
				tmp[k] = data[i];
				i++;
				k++;
			}else{
				tmp[k++] = data[j++];
			}
		}
		
		//�����ʣ������Ƶ���ʱ����
		while(i <= mid){
			tmp[k++] = data[i++];
		}
		
		//���ұ�ʣ������Ƶ���ʱ����
		while(j <= high){
			tmp[k++] = data[j++];
		}
		
		//����ʱ�����ֵ����ԭ���飬ע�⣬���Ǵ�0��ʼ���Ǵ�low��ʼ
		for(int m = 0; m < tmp.length; m++){
			data[m + low] = tmp[m];
		}
	}
	public static void mergeSort(int[] data, int low, int high){
		int mid = (low + high) / 2;
		if(low < high){
			//���
			mergeSort(data, low, mid);
			//�ұ�
			mergeSort(data, mid + 1, high);
//			//�������������ҹ鲢
			merge(data, low, mid, high);
		}
	}
}

