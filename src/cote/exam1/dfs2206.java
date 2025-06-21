package cote.exam1;
import java.util.*;

public class dfs2206 {
	
	static boolean[][] visit;
	static int[][] A;
	static int N, M;
	static int[][] directions = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		A = new int[N+1][M+1];
		sc.nextLine();
		for(int i=1; i<=N; i++) {
			String a = sc.nextLine();
			for(int j=1; j<=M; j++) {
				A[i][j] = Integer.parseInt(a.substring(j-1,j));
			}
		}
		A[1][1] = 1;
		
		bfs(1,1);
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(A[i][j]==1) {
					back(i,j);
				}
			}
		}
		
		if(min ==  Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}

	}

	private static void back(int i, int j) {
		// TODO Auto-generated method stub
		
		A[i][j] = 0;
		bfs(1,1);
		A[i][j] = 1;
	}
	
	private static void bfs(int i, int j) {
		int[][] copy = new int[N+1][M+1];
		for(int l=1; l<=N; l++) {
			for(int m=1; m<=M; m++) {
				copy[l][m] = A[l][m];
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		visit = new boolean[N+1][M+1];
		queue.offer(new int[] {i,j});
		visit[i][j] = true;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int[] d:directions) {
				int nx = now[0]+d[0];
				int ny = now[1]+d[1];
				if(nx>0&&nx<=N&&ny>0&&ny<=M&&copy[nx][ny]==0&&!visit[nx][ny]) {
					visit[nx][ny] = true;
					copy[nx][ny] = copy[now[0]][now[1]]+1;
					queue.offer(new int[] {nx,ny});
				}
			}
		}
		if(copy[N][M]>0) {
			min = Math.min(min, copy[N][M]);
		}

	}
	
}
