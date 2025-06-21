package cote.exam1;

import java.util.*;
import java.io.*;

public class bfs6593 {
	
	static int[][] directions = {
			{1,0,0},
			{0,1,0},
			{-1,0,0},
			{0,-1,0},
			{0,0,1},
			{0,0,-1}
	};
	
	static int L,R,C; //층,행,열
	static int[] start; //시작 좌표
	static int[] end; //종료 좌료
	static int[][][] A;
	static boolean[][][] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		
		while(!(L==0&&R==0&&C==0)) {
			A = new int[L][R][C];
			visited = new boolean[L][R][C];
			for(int i=0; i<L; i++) {
				for(int j=0; j<R; j++) {
					String w = sc.next();
					for(int k=0; k<C; k++) {
						String e = w.substring(k,k+1);
						if(e.equals("S")) {
							start = new int[] {i,j,k};
							A[i][j][k] = 0;
						}
						if(e.equals("E")) {
							end = new int[] {i,j,k};
							A[i][j][k] = 0;
						}
						if(e.equals(".")) {
							A[i][j][k] = 0;
						}
						if(e.equals("#")) {
							A[i][j][k] = 1;
						}
					}
				}
			}
			
			bfs(start[0],start[1],start[2]);
			if(A[end[0]][end[1]][end[2]]==0) {
				System.out.println("Trapped!");
			}else {
				System.out.println("Escaped in " + A[end[0]][end[1]][end[2]] + " minute(s)");
			}
			L = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
		}
	}
	
	private static void bfs(int k, int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		visited[k][i][j] = true;
		queue.offer(new int[] {k,i,j});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int[] d:directions) {
				int nk = now[0] + d[0];
				int ni = now[1] + d[1];
				int nj = now[2] + d[2];
				if(nk>=0&&nk<L&&ni>=0&&ni<R&&nj>=0&&nj<C
						&&!visited[nk][ni][nj]&&A[nk][ni][nj]==0) {
					visited[nk][ni][nj] = true;
					queue.offer(new int[] {nk, ni, nj});
					A[nk][ni][nj] = A[now[0]][now[1]][now[2]]+1;
				}
			}
		}
	}

}
