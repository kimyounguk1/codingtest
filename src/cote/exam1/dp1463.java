package cote.exam1;
import java.util.*;
public class dp1463 {
	
	static int x;
	static Integer[] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		dp = new Integer[x+1];
		System.out.println(dfs(x));

	}
	
	static int dfs(int x) {
		if(x == 1) return 0;
		if(dp[x]!=null) return dp[x];
		dp[x] = dfs(x-1)+1;
		if(x%2==0) {
			dp[x] = Math.min(dfs(x/2)+1, dp[x]);
		}
		if(x%3==0) {
			dp[x] = Math.min(dp[x], dfs(x/3)+1);
		}
		return dp[x];
	}

}
