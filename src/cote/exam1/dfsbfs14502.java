package cote.exam1;
import java.io.*;
import java.util.*;
public class dfsbfs14502 {
	
	static int M,N;
	static int max=0;
	static int[][] A;
	static int[][] directions = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			M = sc.nextInt();
			A = new int[N][M];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					A[i][j] = sc.nextInt();
				}
			}
			
			back(0);
			System.out.println(max);
	}
	private static void back (int depth) {
		if(depth == 3) {
			virus();
			return;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(A[i][j]==0) {
					A[i][j] = 1;
					back(depth+1);
					A[i][j] = 0;
				}
			}
		}
	}
	private static void virus() {
		int count = 0;
		int[][] copy = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[i][j] = A[i][j];
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copy[i][j] == 2) {
					Queue<int[]> queue = new LinkedList<>();
					int[] now = {i,j};
					queue.offer(new int[] {i,j});
					while(!queue.isEmpty()) {
						int[] next = queue.poll();
						for(int[] d:directions) {
							int nx = next[0] + d[0];
							int ny = next[1] + d[1];
							if(nx>=0&&nx<N&&ny>=0&&ny<M&&copy[nx][ny]==0) {
								copy[nx][ny] = 2;
								queue.offer(new int[] {nx,ny});
							}
						}
					}
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copy[i][j]==0) {
					count++;
				}
			}
		}
		max = Math.max(count, max);
	}

}
