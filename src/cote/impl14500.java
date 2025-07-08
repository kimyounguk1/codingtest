package cote.exam1;

import java.io.*;
import java.util.*;

public class impl14500 {
	
	static int[][] map;
	static int M,N;
	static int[][] directions = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	static boolean[][] visit;
	static int max=0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); //행
		N = sc.nextInt(); //열
		
		map = new int[M][N];
		visit = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				dfs(i,j,0,map[i][j]);
			}
		}
		for(int x=0; x<M-1; x++) {
			for(int y=0; y<N-2; y++) {
				int hap = map[x][y] + map[x][y+1] + map[x][y+2] + map[x+1][y+1];
				max = Math.max(hap, max);
			}
		} //ㅜ 모양
		for(int x=1; x<M; x++) {
			for(int y=0; y<N-2; y++) {
				int hap = map[x][y] + map[x][y+1] + map[x][y+2] + map[x-1][y+1];
				max = Math.max(hap, max);
			}
		} //ㅗ 모양
		for(int x=0; x<M-2; x++) {
			for(int y=1; y<N; y++) {
				int hap = map[x][y] + map[x+1][y] + map[x+2][y] + map[x+1][y-1];
				max = Math.max(hap, max);
			}
		} //ㅓ 모양
		for(int x=0; x<M-2; x++) {
			for(int y=0; y<N-1; y++) {
				int hap = map[x][y] + map[x+1][y] + map[x+2][y] + map[x+1][y+1];
				max = Math.max(hap, max);
			}
		} //ㅏ 모양
		System.out.println(max);
	}
	
	static void dfs(int x, int y, int depth, int sum) {
		int plus = sum; 
		if(depth == 3) {
			max = Math.max(sum, max);
			return;
		}
		visit[x][y] = true;
		for(int[] d:directions) {
			int nx = x+d[0];
			int ny = y+d[1];
			if(nx>=0&&ny>=0&&nx<M&&ny<N&&!visit[nx][ny]) {

				dfs(nx,ny,depth+1,plus+map[nx][ny]);

			}
		}
		visit[x][y] = false;
	}

}
