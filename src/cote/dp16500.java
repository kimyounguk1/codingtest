package cote;

import java.io.*;
import java.util.*;

public class dp16500 {
	
	static String s;
	static Set<String> A;
	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		s = br.readLine();
		
		n = Integer.parseInt(br.readLine());
		
		A = new HashSet<>();
		
		for(int i=0; i<n; i++) {
			A.add(br.readLine());
		}
		
		boolean[] dp = new boolean[s.length() + 1]; //원본 문자열 배열
		dp[0] = true;
		
		for(int i=1; i<=s.length(); i++) {
			for(int j=0; j<i; j++) {
				if(dp[j]&&A.contains(s.substring(j,i))) {
					dp[i] = true;
					break;
				}
			}
		}
		if(dp[s.length()]) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}

}
