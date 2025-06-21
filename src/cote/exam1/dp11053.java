package cote.exam1;
import java.util.*;

public class dp11053 {

	static int n;
	static Integer[] dp;
	static int[] A;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		A = new int[n + 1];     // 1-based index
		dp = new Integer[n + 1];

		for (int i = 1; i <= n; i++) {
			A[i] = sc.nextInt();
		}

		int result = 0;
		for (int i = 1; i <= n; i++) {
			result = Math.max(result, dfs(i));
		}
		System.out.println(result);
	}

	static int dfs(int i) {
		if (dp[i] != null) return dp[i];

		dp[i] = 1; // 자기 자신만 포함한 LIS

		for (int j = 1; j < i; j++) {
			if (A[j] < A[i]) {
				dp[i] = Math.max(dp[i], dfs(j) + 1);
				//dp[i]는 이전 j들에 대해서 더 크면 교환 아니면 유지
			}//모든 dp 배열에서 가장 큰 값에 1더하기
		}
		return dp[i];
	}
}
