package Other;

import java.util.Stack;

/**
 * 
 * @author WangZ
 * 括号匹配：
 * 输入一个字符串，仅包含括号
 * 合法：() {} [] ([]) {[()]}
 * 不合法：(] ([)]
 * 思路：使用栈来解决
 *
 */
public class BracketsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "{[())]}";
		System.out.println(isValid(str));
	}
	
	public static boolean isValid(String str){
		if(str == null){
			return false;
		}
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < str.length(); i++){
			if(stack.isEmpty()){
				//如果栈是空的  
				stack.push(str.charAt(i));
			}else if((stack.peek() == '(' && str.charAt(i) == ')') || (stack.peek() == '[' && str.charAt(i) == ']') 
						|| (stack.peek() == '{' && str.charAt(i) == '}')){
				//说明此时栈中字符不是空的,并且合法，弹出栈顶元素，并且i++
				stack.pop();
			}else{
				//说明字符串是[()]此种混合类型的
				stack.push(str.charAt(i));
			}
		}
		
		if(stack.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
}
