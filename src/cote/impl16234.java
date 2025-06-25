package cote;

import java.io.*;
import java.util.*;

public class impl16234 {
	
	static int N,L,R;
	static int[][] map;
	static boolean[][] visit;
	static boolean work = true;
	static int[][] directions = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	static List<int[]> union;
	static int times = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st1.nextToken());
		L = Integer.parseInt(st1.nextToken());
		R = Integer.parseInt(st1.nextToken());
		
		map = new int[N][N];
		while(work) { //일단 연합이 생기면 계속 진행
			visit = new boolean[N][N];
			work = false;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visit[i][j]) { //이미 연합에 속하면 bfs 하지 않아도 됨
						union = new LinkedList<>(); 
						
						bfs(i,j);
						if(union.size()>1) {
							work = true;
						}
						int total = 0;
						int avg = 0;
						for(int[] u:union) {
							total = total+map[u[0]][u[1]];
						}
						avg = total/union.size();
						for(int[] u:union) {
							map[u[0]][u[1]] = avg;
						}
						
					}
				}
			}
			if(work) {
				times++;
			}
		}
		System.out.println(times);
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		visit[x][y] = true;
		queue.offer(new int[] {x,y});
		union.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowx = now[0];
			int nowy = now[1];
			for(int[] d:directions) {
				int nx = nowx+d[0];
				int ny = nowy+d[1];
				if(nx>=0&&ny>=0&&nx<N&&ny<N&&!visit[nx][ny]) { 
					if(L<=Math.abs(map[nowx][nowy]-map[nx][ny])&&Math.abs(map[nowx][nowy]-map[nx][ny])<=R) {
						queue.offer(new int[] {nx,ny});
						visit[nx][ny] = true;
						union.add(new int[] {nx,ny});
					}
				}
			}
		}
	}

}
