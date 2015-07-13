package Offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 
 * @author WangZ
 *	面试题35：第一个只出现一次的字符 186页
 *	题目：在字符串中找出第一个只出现一次的字符，如输入"abaccdeff"，则输出"b"
 *	使用哈希表
 *	首先：遍历字符串，如果这个字符存在于哈希表中，则更新val为val+1，如果不存在，则存入哈希表，val为1
 *	然后，再次遍历字符串，查找每个字符在哈希表中存储的val，如果val为1，则返回这个字符。
 *	在哈希表中更新一个字符出现的次数的时间O(1)，如果字符串长度为n,那么遍历一次的时间复杂度为O(n)
 */
public class FirstNotRepeatingCharDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abaccdeff";
		System.out.println(FirstNotRepeatingChar(str));
		System.out.println(FirstNotRepeatingChar2(str));
	}
	
	/*
	 * 此种解法得借助HashMap
	 */
	public static char FirstNotRepeatingChar(String str){
		if(str == null){
			return '\0';
		}
		char res = '\0';
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for(int i = 0; i < str.length(); i++){
			if(hm.containsKey(str.charAt(i))){
				int val = hm.get(str.charAt(i));
				hm.put(str.charAt(i), (val + 1));
			}else{
				hm.put(str.charAt(i), 1);
			}
		}
		
		for(int i = 0; i < str.length(); i++){
			if(hm.get(str.charAt(i)) == 1){
				res = str.charAt(i);
				break;
			}
		}
		
		return res;
	}
	
	/*
	 * 	字符char是一个长度为8的数据类型，因此共有256种可能，可以创建一个长度为256的数组，每个字母根据其ASCII码值作为其数组下标(0~255)，
	 * 	数组中存储的是每个字符出现的次数，同样也是两次遍历
	 * 	
	 *
	 */
	public static char FirstNotRepeatingChar2(String str){
		if(str == null){
			return '\0';
		}
		int[] hashtable = new int[256];
		//初始化
		for(int i = 0; i < hashtable.length; i++){
			hashtable[i] = 0;
		}
		//第一次遍历，赋值
		for(int i = 0; i < str.length(); i++){
			hashtable[(int)str.charAt(i)]++;
		}
		//第二次遍历
		for(int i = 0; i < str.length(); i++){
			if(hashtable[(int)str.charAt(i)] == 1){
				return str.charAt(i);
			}
		}
		
		return '\0';
	}

}
