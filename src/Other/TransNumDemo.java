package Other;

import java.awt.SystemTray;

public class TransNumDemo {
	public static void main(String[] args){
		transNum(5030005);
	}
	
	public static void transNum(int num){
		final String[] ch_num = {"零","一","二","三","四","五","六","七","八","九"};
		final String[] ch_unit = {"","十","百","千","万","十万","百万","千万","亿"};
		int tmp = 0;
		StringBuilder sb = new StringBuilder();
		int[] data = new int[10];
		int cnt = 0;
		while(true){
			tmp = num % 10;
			num = num/10;
			data[cnt] = tmp;
			if(num == 0){
				break;
			}
			cnt++;
		}

		for(int i = cnt; i >= 0; i--){
//			System.out.println(ch_num[data[i]]);
			String unit = null;
			if(data[i] == 0){
				unit = "";
			}else{
				unit = ch_unit[i];
			}
			sb.append(ch_num[data[i]] + unit);
		}
		System.out.println(sb.toString());
	}

}
