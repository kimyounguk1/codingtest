package cote.exam1;

import java.io.*;
import java.util.*;

public class dfs1012 {
	
	static int M,N,K;
	static boolean[][] visited;
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
		
		int T = sc.nextInt();
		
		for(int q=0; q<T; q++) {
			int count = 0;
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			A = new int[M][N];
			visited = new boolean[M][N];
			for(int i=0; i<K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				A[x][y] = 1;
			}
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]&&A[i][j]==1) {
						count++;
						DFS(i,j);
					}
				}
			}
			System.out.println(count);
		}
		
	}
	private static void DFS(int i, int j) {
		if(visited[i][j]) return;
		
		visited[i][j]=true;
		int[] now = {i,j};
		for(int[] d:directions) {
			int nx = now[0]+d[0];
			int ny = now[1]+d[1];
			
			if(nx>=0&&nx<M&&ny>=0&&ny<N&&A[nx][ny]!=0&&!visited[nx][ny]) {
				DFS(nx,ny);
			}
		}
	}

}
