package Other;
/**
 * 
 * @author WangZ
 *	全排列算法的java实现
 */
public class AllSortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = "abc".toCharArray();
		perm(arr, 0, arr.length - 1);
	}

	
	public static void perm(char[] buf, int start, int end) {
        if (start == end) {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
            System.out.println(buf);
        } else {// 多个字母全排列
            for (int i = start; i <= end; i++) {
                char temp = buf[start];// 交换数组第一个元素与后续的元素
                buf[start] = buf[i];
                buf[i] = temp;
                	
                perm(buf, start + 1, end);// 后续元素递归全排列
 
                temp = buf[start];// 将交换后的数组还原
                buf[start] = buf[i];
                buf[i] = temp;
            }
        }
    }
}
