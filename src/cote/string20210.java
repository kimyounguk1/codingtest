package cote;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class string20210 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		List<String> list = new ArrayList<>();
		
		int n = Integer.parseInt(br.readLine());
		//배열 저장
		for(int i=0; i<n; i++) {
			list.add(br.readLine());
		}
		//정렬 기준 정의
		Collections.sort(list, (a,b)->{
			int i=0, j=0;
			while(i<a.length()&&j<b.length()) {
				char ca = a.charAt(i);
				char cb = b.charAt(j);
				
				if(Character.isDigit(ca)&&Character.isDigit(cb)) {
					int ia = i;
					int ib = j;
					while(ia<a.length()&&Character.isDigit(a.charAt(ia))) {
						ia++;
					}
					while(ib<b.length()&&Character.isDigit(b.charAt(ib))) {
						ib++;
					}
		            String sa = a.substring(i, ia);
		            String sb = b.substring(j, ib);
		            
		            BigInteger na = new BigInteger(sa);
		            BigInteger nb = new BigInteger(sb);
		            
		            int cmp = na.compareTo(nb);
		            if (cmp != 0) return cmp; //숫자일때 다르면 숫자 크기로 정렬
					if(sa.length()!=sb.length()) return sa.length()-sb.length(); 
					//숫자가 같은데 앞에 0의 갯수가 다르면 길이순으로 정렬
					
					i = ia;
					j = ib;
					
				} else {
					if (ca != cb) {
						if (Character.toLowerCase(ca) != Character.toLowerCase(cb)) {
							return Character.toLowerCase(ca) - Character.toLowerCase(cb);
						} else {
							return ca - cb;  // 같은 알파벳이면 대문자가 먼저
						}
					}
					// 문자가 같으면 인덱스 이동
					i++;
					j++;
				}
			}
			return a.length() - b.length();
		});
		
		for(String s:list) {
			System.out.println(s);
		}
		
	}

}
