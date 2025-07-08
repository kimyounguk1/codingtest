package cote.exam1;

import java.io.*;
import java.util.*;

public class bfs2206v2 {
	
	static int N,M;
	static boolean [][][] visit; //벽 상태까지 저장하는 방문 배열
	static char[][] miro; //원본 미로
	static int[][] dist; //최단 거리
	static int[][] directions = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		miro = new char[N+1][M+1];
		dist = new int[N+1][M+1];
		visit = new boolean[2][N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			char[] k = br.readLine().toCharArray();
			for(int j=1; j<=M; j++) {
				miro[i][j] = k[j-1];
			}
			
		}
		
		int result = bfs();
		System.out.println(result);
	}
	
	static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0,1,1}); //벽,행,열
		visit[0][1][1] = true; //벽,행,열
		dist[1][1] = 1;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int crashed = now[0];
			int x = now[1];
			int y = now[2];
			if(x==N&&y==M) {
				return (dist[x][y]);
			}
			for(int[] d:directions) {
				int nx = x+d[0];
				int ny = y+d[1];
				
				if(nx>0&&nx<=N&&ny>0&&ny<=M) {
					if(miro[nx][ny]=='0'&&!visit[crashed][nx][ny]) {
						dist[nx][ny] = dist[x][y]+1;
						visit[crashed][nx][ny] = true;
						queue.offer(new int[] {crashed,nx,ny});
						
					}else if(miro[nx][ny]=='1'&&!visit[1][nx][ny]&&crashed==0) {
						visit[1][nx][ny] = true;
						dist[nx][ny] = dist[x][y]+1;
						queue.offer(new int[] {1,nx,ny});
					}
				}
			}
			
		}
		return -1;
	}

}
