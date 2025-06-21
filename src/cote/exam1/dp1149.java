package cote.exam1;

import java.util.Scanner;

public class dp1149 {
	
	static Integer[][] dp;
	static int[][] A;
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new Integer[n][3];
		A = new int[n][3];
        for (int i = 0; i < n; i++) {
            A[i][0] = sc.nextInt(); // 빨강
            A[i][1] = sc.nextInt(); // 초록
            A[i][2] = sc.nextInt(); // 파랑
        }
		int answer = Math.min(dfs(n-1,0),
				Math.min(dfs(n-1,1), dfs(n-1,2)));
		System.out.println(answer);
	}
	static int dfs(int i, int color) {
		if(dp[i][color]!=null) return dp[i][color];
		if(i==0) return dp[i][color] = A[0][color];
		if(color==0) {
			dp[i][0]=A[i][0]+Math.min(dfs(i-1,1), dfs(i-1,2));
		}else if(color==1) {
			dp[i][1]=A[i][1]+Math.min(dfs(i-1,0), dfs(i-1,2));
		}else {
			dp[i][2]=A[i][2]+Math.min(dfs(i-1,0),dfs(i-1,1));
		}
		return dp[i][color];
	}

}
