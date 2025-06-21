package cote.exam1;
import java.util.Scanner;
public class dp2579 {

		static Integer[] dp;
		static int[] A;
		static int n;

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			dp = new Integer[n+1];
			A = new int[n+1];
			for(int i=1; i<=n; i++) {
				A[i] = sc.nextInt();
			}
			System.out.println(dfs(n));
		}
		static int dfs(int start) {
			if(start <= 0) return 0;
			if(start == 1) return A[1];
			if(start == 2) return A[1]+A[2];
			if(dp[start]!=null) return dp[start];
			dp[start] = Math.max(dfs(start-2)+A[start],
						dfs(start-3)+A[start-1]+A[start]);
			return dp[start];
		}

	}



