package cote;

import java.io.*;
import java.util.*;

public class bfs2178 {
	static boolean[][] visited;
	static int M,N;
	static int[][] A;
	static int[][] directions = {
		{1,0},
		{0,1},
		{-1,0},
		{0,-1}
		
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		
		A = new int[N+1][M+1];
		visited = new boolean[N][M];
		
		for(int i=1; i<N+1; i++) {
			String line = br.readLine();
			for(int j=1; j<M+1; j++) {
				A[i][j] = Integer.parseInt(line.substring(j-1,j));
			}
		}
		
		BFS(1,1);
		System.out.println(A[N][M]);
	}

	static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		visited[x][y] = true;
		queue.offer(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int[] d : directions) {
				int nextX = now[0]+d[0];
				int nextY = now[1]+d[1];
				
				if(nextX>=0&&nextY>=0&&nextX<=N&&nextY<=M) {
					if(A[nextX][nextY]!=0&&visited[nextX][nextY]!=true) {
						visited[nextX][nextY]=true;
						queue.offer(new int[] {nextX, nextY});
						A[nextX][nextY] = A[now[0]][now[1]]+1;
					}
				}
			}
		}
		
	}
	

}
