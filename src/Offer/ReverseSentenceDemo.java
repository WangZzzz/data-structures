package Offer;

import java.util.Arrays;

/**
 * 
 * @author WangZ
 *	面试题42：反转单词顺序 VS 左旋字符串 218页
 *	题目一：输入一个英文句子，反转句子中单词的顺序，但单词内字符的顺序不变，为了简单起见，标点符号和普通字母一样处理，例如输入字符串：
 *	“I am a student”，则输出“student. a am I”
 *
 *	题目二：字符串的坐旋转操作是把字符串前面的若干的字符转移到字符串的尾部，请定义一个函数实现字符串左旋操作的功能，比如输入字符串
 *		“abcdefg”和数字2，该函数将返回左旋转2位得到的结果“cdefgab”
 */
public class ReverseSentenceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str = "I am a student.".toCharArray();
/*		Reverse(str, 0, str.length - 1);
		System.out.println(Arrays.toString(str));*/
		ReverseSentence(str);
		System.out.println(str);
		
		char[] str2 = "abcdefg".toCharArray();
		LeftRoateString(str2, 2);
		System.out.println(str2);
	}
	
	//思路：先反转整个句子，再翻转句子中的每个单词，使用空格标识一个单词
	public static void ReverseSentence(char[] str){
		if(str == null){
			return;
		}
		
		int begin = 0;
		int end = str.length - 1;
		//反转整个句子
		Reverse(str, begin, end);
		
		//反转句子中的每个单词
		for(int i = 0, j = 0; i < str.length; i++){
			if(str[i] == ' '){
//				System.out.println("@@");
				Reverse(str, j, i - 1);
				j = i + 1;
			}
		}
	}
	
	//反转字符串
	public static void Reverse(char[] str, int begin, int end){
		if(str == null || str.length <= 0 || begin > end || begin < 0 || end >= str.length){
			return;
		}
		
		while(begin < end){
			char tmp = str[begin];
			str[begin] = str[end];
			str[end] = tmp;
			
			begin++;
			end--;
		}
	}
	
	//题目二。可以借助上面的反转字符串，先分别反转两部分，然后反转整个字符串
	public static void LeftRoateString(char[] str, int n){
		if(str == null || str.length <= 0 || n < 1 || n > str.length){
			return;
		}
		
		//前后两部分字符串
		char[] tmp1 = new char[n];
		char[] tmp2 = new char[str.length - n];
		//把原数组分别赋值到两个新数组
		int i = 0;
		for(i = 0; i < n; i++){
			tmp1[i] = str[i];
		}
		
		for(int j = 0; i < str.length; i++,j++){
			tmp2[j] = str[i];
		}
		
		//分别反转两个数组
		Reverse(tmp1, 0, tmp1.length - 1);
		Reverse(tmp2, 0, tmp2.length - 1);
		
		//再把两个数组合并回原数组
		for(i = 0; i < n; i++){
			str[i] = tmp1[i];
		}
		
		for(int j = 0; j < tmp2.length; j++,i++){
			str[i] = tmp2[j];
		}
		
		//反转整个数组
		Reverse(str, 0, str.length - 1);
		
	}

}
