package cote.exam1;
import java.util.*;

public class dp11726 {

    static int[] dp = new int[1001]; // 메모이제이션 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(tile(n));
    }

    static int tile(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        // 이미 계산된 값이 있다면 반환
        if (dp[n] != 0) return dp[n];

        // 계산하지 않았다면 점화식대로 계산
        dp[n] = (tile(n - 1) + tile(n - 2)) % 10007;
        return dp[n];
    }
}
