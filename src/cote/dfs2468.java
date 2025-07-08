package cote.exam1;

import java.io.*;
import java.util.*;

public class dfs2468 {
	
	static boolean[][] visited;
	static int M;
	static int[][] A;
	static int[][] directions = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	static int result=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		int max=0;
		A = new int[M][M];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				A[i][j]=sc.nextInt();
				max = Math.max(max, A[i][j]);
			}
		}
		
		for(int k=0; k<max; k++) {
			visited = new boolean[M][M];
			int big = 0;
			for(int i=0; i<M; i++) {
				for(int j=0; j<M; j++) {
					if(!visited[i][j]&&A[i][j]>k) {
						big++;
						dfs(i,j,k);
					}
					
				}
			}
			result = Math.max(result, big);
		}
		System.out.println(result);
		
	}
	private static void dfs(int i, int j, int k) {
		if(visited[i][j]||A[i][j]<=k) return;
		
		visited[i][j]=true;
		int now[] = {i,j};
		for(int[] d:directions) {
			int nx = now[0]+d[0];
			int ny = now[1]+d[1];
			if(nx>=0&&nx<M&&ny>=0&&ny<M&&!visited[nx][ny]
					&&A[nx][ny]>k) {
				dfs(nx,ny,k);
			}
		}
	}

}
