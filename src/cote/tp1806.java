package cote;

import java.io.*;
import java.util.*;

public class tp1806 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		int len = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		int sum = 0;
		
		while(end <= n) {
			if(sum>=s) {
				len = Math.min(len, end-start);
				sum = sum - arr[start++];
			}else if(sum<s) {
				sum = sum + arr[end++];
			}
		}
		if(len == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(len);
		}
	}

}
