package cote.exam1;

import java.io.*;
import java.util.*;

public class dfs2667 {
	
	static int N;
	static boolean[][] visited;
	static int[][] A;
	static int num;
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
		A = new int[N][N];
		visited = new boolean[N][N];
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
		    String line = sc.next();
		    for(int j=0; j<N; j++) {
		        A[i][j] = line.charAt(j) - '0';
		    }
		}
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]&&A[i][j]==1) {
					num = 1;
					dfs(i,j);
					list.add(num);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
		    System.out.println(list.get(i));
		}

	}
	static void dfs(int i, int j) {
		if(visited[i][j])return;
		
		visited[i][j] = true;
		int[] now = {i,j};
		for(int[] d:directions) {
			int nx = now[0]+d[0];
			int ny = now[1]+d[1];
			if(nx>=0&&nx<N&&ny>=0&&ny<N&&A[nx][ny]!=0&&!visited[nx][ny]) {
				num++;
				dfs(nx,ny);
			}
		}
	}

}
