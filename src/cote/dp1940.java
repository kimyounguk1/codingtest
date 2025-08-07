package cote;

import java.io.*;
import java.util.*;

public class dp1940 {
	
	static int[][] state;
	static int n,m;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		state = new int[n][m+1];
		
		for(int i=0; i<n; i++) {
			Arrays.fill(state[i], -1);
		}
		
		int result = dp(0,0);
		
		System.out.println(result);
	}
	
	public static int dp(int start, int sum) {
		if(start>=n) return 0;
		if(sum==m) return 1;
		if(sum>m) return 0;
		if(state[start][sum]!=-1) return state[start][sum];
		state[start][sum] = 0;
		for(int i=start; i<n; i++) {
			state[start][sum] += dp(i+1, sum+arr[i]);
		}
		return state[start][sum];
	}

}
