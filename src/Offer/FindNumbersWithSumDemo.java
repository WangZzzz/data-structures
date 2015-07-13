package Offer;
/**
 * 
 * @author WangZ
 *	������41����ΪS����������VS��Ϊs������������
 *		��Ŀһ������һ����������������һ������s���������в�����������ʹ�����ǵĺ͸պ���s������ж�����ֵĺ͵���s���������һ�Լ���
 *	������������{1,2,4,7,11,15}������15������4+11=15��������4��11
 *	˼·��
 *		����һ�����������й̶�һ�����֣����ж������е������n-1�����������ĺ��ǲ��ǵ���s��O(n^2)��ʱ�临�Ӷ�
 *		��������ͷβ˫ָ�룬�������s����ô�ƶ�βָ����ǰ�����С��s����ô�ƶ�ͷָ�����,���������м�ɨ�裬ʱ�临�Ӷ�ΪO(n)
 */
public class FindNumbersWithSumDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,4,7,11,15};
		FindNumbersWithSum(nums, 15);

	}
	
	public static void FindNumbersWithSum(int[] nums, int s) {
		if(nums == null || nums.length <= 0){
			return;
		}
		
		int i = 0;
		int j = nums.length - 1;
		while(i < j){
			if(nums[i] + nums[j] == s){
				System.out.println("������Ϊ�� " + nums[i] + "��" + nums[j]);
				return;
			}else if((nums[i] + nums[j]) > s){
				j--;
			}else{
				i++;
			}
		}
		
		System.out.println("û���ҵ����");
	}


}
