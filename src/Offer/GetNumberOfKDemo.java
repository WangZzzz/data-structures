package Offer;
/**
 * 
 * @author WangZ
 *	面试题38：数字在排序数组中出现的次数 204页
 *	题目：统计一个数字在排序数组中出现的次数，例如输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，
 *	因此输出4
 *	利用折半查找找到排序数组中的第一个k和最后一个k的索引，那么就能知道有多少个数字了
 *	二分查找的时间复杂度O(logn)，GetFirstK和GetLastK都是用二分查找法在数组中查找一个合乎要求的数字，他们的时间复杂度都是O(logn),
 *	因此，这个算法的总的时间复杂度是O(logn)
 */
public class GetNumberOfKDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,3,3,3,4,5};
		System.out.println(GetNumberOfK(nums, 3));
	}
	
	public static int GetNumberOfK(int[] nums, int k){
		if(nums == null || nums.length <= 0){
			return 0;
		}
		
		int cnt = 0;
		int firstIndex = GetFirstK(nums, k, 0, nums.length - 1);
		System.out.println(firstIndex);
		int lastIndex = GetLastK(nums, k, 0, nums.length - 1);
		System.out.println(lastIndex);
		if(firstIndex > -1 && lastIndex > -1){
			cnt = lastIndex - firstIndex + 1;
		}
		
		return cnt;
		
	}
	
	/*
	 * 	找到第一个k，利用二分查找，如果中间的数字为k，且它的前一个数字不是k，那说明这个数字就是第一k，否则第一个k在前半段
	 */
	public static int GetFirstK(int[] nums, int k, int start, int end){
		if(start > end){
			return -1;
		}
		
		int middleIndex = (start + end) / 2;
		int middleData = nums[middleIndex];
		
		if(middleData == k){
			//说明此时middleIndex处的k就是第一个k
			/*
			 * 	两种情况：一是中间的数字为k且前一个数字不是k，第二种情况是index已经到了第一位
			 */
			if((middleIndex > 0 && nums[middleIndex - 1] != k) || middleIndex == 0){
				return middleIndex;
			}else{
				//说明第一个k在左边
				end = middleIndex - 1;
			}
		}else if(middleData > k){
			//说明k在左边
			end = middleIndex - 1;
		} else{
			//说明k在右边 
			start = middleIndex + 1;
		}
		
		return GetFirstK(nums, k, start, end);
	}
	
	//同理，得到最后一个k的索引
	public static int GetLastK(int[] nums, int k, int start, int end){
		if(start > end){
			return -1;
		}
		
		int middleIndex = (start + end) / 2;
		int middleData = nums[middleIndex];
		
		if(middleData == k){
			//说明此时middleIndex处的k就是最后一个k
			/*
			 * 	两种情况：一是中间的数字为k且后一个数字不是k，第二种情况是index已经到了最后一位
			 */
			if((middleIndex < nums.length - 1 && nums[middleIndex + 1] != k) || middleIndex == nums.length - 1){
				return middleIndex;
			}else{
				//说明最后一个k在右边
				start = middleIndex + 1;
			}
		}else{
			if(middleData > k){
				end = middleIndex - 1;
			}else{
				start = middleIndex + 1;
			}
		}
		
		return GetLastK(nums, k, start, end);
	}

}
