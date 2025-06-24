package cote;

import java.io.*;
import java.util.*;

public class impl14503 {
	
	static int M;
	static int N;
	static int x;
	static int y;
	static int[][] map;
	static boolean visit[][];
	static int count=1;
	static int[][] directions = {
			{-1, 0}, // 북
		    {0, 1},  // 동
		    {1, 0},  // 남
		    {0, -1}  // 서
	};
	static int D;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		x = sc.nextInt();
		y = sc.nextInt();
		
		D = sc.nextInt(); //이동방향
		
		map = new int[M][N];
		visit = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs();
		System.out.println(count);
	}
	
	static void dfs() {
		visit[x][y] = true;
		boolean work = false;
		for(int[] d:directions) {
			int nx = x+d[0];
			int ny = y+d[1];
			if(nx>=0&&ny>=0&&nx<M&&ny<N&&!visit[nx][ny]&&map[nx][ny]!=1) {
				work = true;
				for(int i=0; i<4; i++) {
					D = (D+3)%4;//반시계 회전 지금 이걸 4방향에 대해서 해야함
					int[] di = directions[D];
					int dx = x+di[0];//앞으로 한칸 이동
					int dy = y+di[1];
					if(dx>=0&&dy>=0&&dx<M&&dy<N&&!visit[dx][dy]&&map[dx][dy]!=1) {
						visit[dx][dy] = true;
						x = dx;
						y = dy;
						count++;
						dfs();
					}
				}
			}
		}
		if(!work) {
			int[] di = directions[D];
			int nx = x-di[0];
			int ny = y-di[1];
			if(map[nx][ny]!=1&&nx>=0&&ny>=0&&nx<M&&ny<N) {
				x = nx;
				y = ny;
				dfs();
			}else {
				return;
			}
			
		}
		
	}

}
