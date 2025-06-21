package cote.exam1;

import java.util.*;
import java.io.*;

public class bfs5427 {
	
	static char[][] map;
	static boolean[][] fireVisit;
	static boolean[][] humanVisit;
	static int[][] fireDist;
	static int[][] humanDist;
	static String result;
	static int F,M,N;
	
	static int[][] directions = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	static int[] start;
	static List<int[]> fire;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		F = Integer.parseInt(br.readLine());
		
		for(int u=0; u<F; u++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			System.out.println(N+" "+M);
			
			map = new char[M+1][N+1];
			fireVisit = new boolean[M+1][N+1];
			humanVisit = new boolean[M+1][N+1];
			fireDist = new int[M+1][N+1];
			humanDist = new int[M+1][N+1];
			result = "IMPOSSIBLE";
			
			for(int i=1;i<=M;i++) {
				char[] a = br.readLine().toCharArray();
				for(int j=1; j<=N; j++) {
					map[i][j] = a[j-1];
				}
				
			}
			fire = new ArrayList<>();
			for(int i=1; i<=M; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j]=='@') {
						start = new int[] {i,j};
					}
					if(map[i][j]=='*') {
						fire.add(new int[] {i,j});
					}
				}
			}
			firebfs();
			humanbfs();
			System.out.println(result);
		}
		
	}
	
	static void firebfs(){
		Queue<int[]> queue = new LinkedList<>();
		for(int[] f:fire) {
			queue.offer(new int[] {f[0],f[1]});
			fireVisit[f[0]][f[1]] = true;
		}
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			for(int[] d:directions) {
				int nx = x+d[0];
				int ny = y+d[1];
				if(nx>0&&ny>0&&nx<=M&&ny<=N&&!fireVisit[nx][ny]) {
					if(map[nx][ny]=='.'||map[nx][ny]=='@') {
						queue.offer(new int[] {nx,ny});
						fireDist[nx][ny] = fireDist[x][y]+1;
						fireVisit[nx][ny] = true;
					}
				}
			}
		}
	}
	
	static void humanbfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {start[0],start[1]});
		humanVisit[start[0]][start[1]] = true;

		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			for(int[] d:directions) {
				int nx = d[0]+x;
				int ny = d[1]+y;
				if(nx>0&&ny>0&&nx<=M&&ny<=N&&!humanVisit[nx][ny]&&map[nx][ny]=='.') {
					if(humanDist[nx][ny]<fireDist[nx][ny]) {
						queue.offer(new int[] {nx,ny});
						humanVisit[nx][ny] = true;
						humanDist[nx][ny] = humanDist[x][y] + 1;
						if(nx==1||nx==M||ny==1||ny==N) {
							result = String.valueOf(humanDist[nx][ny] + 1);
							return;
						}
					}
				}
			}
		}

	}

}
