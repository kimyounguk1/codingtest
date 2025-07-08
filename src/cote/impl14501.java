package cote.exam1;

import java.util.*;

public class impl14501 {
	static int[] d;
	static int[] p;
	static int n;
	static Integer[] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			d = new int[n+1];
			p = new int[n+1];
			dp = new Integer[n+1];
			
			for(int i=1; i<=n; i++) {
				d[i] = sc.nextInt();
				p[i] = sc.nextInt();
			}
			
			System.out.println(dfs(1));
	}
	static int dfs(int day) {
		if(day>n) return 0;
		if(dp[day]!=null) return dp[day];
		if(day+d[day]-1>n) {
			return dfs(day+1);
		}else {
			dp[day] = Math.max(p[day]+dfs(day+d[day]), dfs(day+1));
		}
		return dp[day];
	}

}
