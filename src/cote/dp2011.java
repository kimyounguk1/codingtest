package cote;

import java.io.*;
import java.util.*;

public class dp2011 {
	
	static int n;
	static Integer[] ar;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		n = s.length(); //문자열 길이
		
		ar = new Integer[n+1];
		
		int result = dp(0, s);
		
		System.out.println(result);
	}
	
	static int dp(int i, String s) {
		if(i == n) return 1;
		if(ar[i]!=null) return ar[i];
		if(s.charAt(i) == '0') return 0;
		int res = dp(i+1, s); 
		
		if(i+1<n) {
			int digit = Integer.parseInt(s.substring(i,i+2));
			if(digit >=10 && digit<=26) {
				res = res + dp(i+2, s);
			}
		}
		ar[i] = res % 1000000;
		return ar[i];
	}

}
