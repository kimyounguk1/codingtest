package cote;

import java.util.*;
import java.io.*;

public class dp1149 {
	
	static Integer[][] dp;
	static Integer[][] cost;
	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dp = new Integer[3][n+1];
		cost = new Integer[3][n+1];
		
		
		for(int i=1; i<n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dp[0][i] = Integer.parseInt(st.nextToken()); //빨
			dp[1][i] = Integer.parseInt(st.nextToken()); //초
			dp[2][i] = Integer.parseInt(st.nextToken()); //파 비용
		}
		
		int result = Math.min(dfs(2,n), Math.min(dfs(0,n), dfs(1,n)));
		System.out.println(result);
	}
	static int dfs(int c, int i) {
		if(i == 1) return dp[c][1];
		if(cost[c][i]!=null) return cost[c][i];
		if(c == 0) cost[c][i] = Math.min(dfs(1,i-1), dfs(2,i-1))+dp[c][i];
		if(c == 1) cost[c][i] = Math.min(dfs(0,i-1), dfs(2,i-1))+dp[c][i];
		if(c == 2) cost[c][i] = Math.min(dfs(0,i-1), dfs(1,i-1))+dp[c][i];
		return cost[c][i];
		
		
	}

}
