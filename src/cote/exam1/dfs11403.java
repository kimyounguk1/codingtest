package cote.exam1;
import java.util.*;
import java.io.*;

public class dfs11403 {

    static boolean[] visit;
    static int N;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1][N + 1];

        // 인접행렬 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 정점에서 DFS 수행
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            for (int j = 1; j <= N; j++) {
                if (A[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int x, int y) {
        visit[y] = true;
        for (int i = 1; i <= N; i++) {
            if (A[y][i] == 1 && !visit[i]) {
            	A[x][i] = 1;
                dfs(x, i);
            }
        }
    }
}
