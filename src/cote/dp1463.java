package cote;

import java.io.*;
import java.util.*;

public class dp1463 {
	
	static int x;
	static Integer[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		x = Integer.parseInt(br.readLine());
		arr = new Integer[x+1];
		int r = dp(x);
		bw.write(String.valueOf(r));
		bw.flush();
		bw.close();
	}
	
	static int dp(int n) {
		if(n == 1) return 0;
		if(arr[n]!=null) return arr[n];
		arr[n] = dp(n-1) + 1;
		if(n%2==0) {
			if(dp(n/2)+1<arr[n]) {
				arr[n] = dp(n/2)+1;
			}
		}
		if(n%3==0) {
			if(dp(n/3)+1<arr[n]) {
				arr[n] = dp(n/3)+1;
			}
		}
		return arr[n];
	}

}
