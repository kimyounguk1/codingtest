package cote.exam1;

import java.util.*;
import java.io.*;

public class bfs7576 {
	
	static int N,M;
	static int[][] A;
	static Queue<int[]> queue = new LinkedList<>();
	static int[][] directions = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		A = new int[N][M];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(A[i][j]==1) {
					queue.offer(new int[] {i,j});
				}
			}
		}
		bfs();
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(A[i][j]==0) {
					bw.write("-1");
					bw.flush();
					bw.close();
					return;
				}
				max = Math.max(A[i][j], max);
			}
		}
		if(max == 1) {
			bw.write("0");
			bw.flush();
			bw.close();
			return;
		}
		bw.write(String.valueOf(max-1));
		bw.flush();
		bw.close();
		return;
	}
	private static void bfs() {
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int[] d:directions) {
				int nx = now[0]+d[0];
				int ny = now[1]+d[1];
				
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&A[nx][ny]==0) {
					queue.offer(new int[] {nx,ny});
					A[nx][ny]=A[now[0]][now[1]]+1;
				}
			}
		}
	}
	
}
