package Offer;

import java.util.Arrays;

/**
 * 
 * @author WangZ
 * 	面试题28：字符串的排列  154页
 * 		题目：输入一个字符串，打印出该字符串中的字符的所有序列，例如，输入字符串abc，则打印出由字符a、b、c所能排列出来的
 * 		所有字符串abc、acb、bac、bca、cab和cba 
 * 	实际就是全排列
 *
 */
public class PermutationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		Permutation(str);
	}
	
	public static void Permutation(String str){
		if(str == null){
			return;
		}
		char[] pStr = str.toCharArray();
		/*
		 * 将String转换成char型数组，在进行全排列
		 */
		perm(pStr, 0, pStr.length - 1);
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
