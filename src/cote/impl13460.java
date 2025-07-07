package cote;

import java.io.*;
import java.util.*;

public class impl13460 {
	
	static int N,M;
	static char[][] map;
	static int[][] directions = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	static int RX, RY, BX, BY, BC, RC;
	static boolean[][][][] visit;
	static int times;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken()); //행
		M = Integer.parseInt(st1.nextToken()); //열
		
		map = new char[N][M];
		visit = new boolean[N][M][N][M]; //두 구슬의 방문 처리
		
		for(int i=0; i<N; i++) {
			String st2 = br.readLine();
			char[] b = st2.toCharArray();
			for(int j=0; j<M; j++) {
				char a = b[j];
				map[i][j] = a;
				if(a == 'R') {
					RX = i;
					RY = j;
				}else if(a == 'B') {
					BX = i;
					BY = j;
				}
			}
		}//맵 담기
		
		Queue<State> queue = new LinkedList<>();
		State nst = new State(BX, BY, RX, RY, 0);
		visit[RX][RY][BX][BY] = true; //방문처리 방문하지 않은 위치 일때 queue에 추가
		queue.offer(nst);
		while(!queue.isEmpty()) {
			State st = queue.poll();
			
			if(st.depth>=10) {
				System.out.println("-1");
				break;
			}
			for(int[] d:directions) {
				int[] blue = move(st.bx, st.by, d);
				//이동후 파란구슬의 위치 및 이동 횟수
				BX = blue[0];
				BY = blue[1];
				BC = blue[2];
				if(map[BX][BY]=='O') {
					continue;
				}
				
				int[] red = move(st.rx, st.ry, d);
				RX = red[0];
				RY = red[1];
				RC = red[2];
				if(map[RX][RY]=='O') {
					//움직이는게 depth+1보다 먼저이므로 출력은 1을 추가해서 해야 함
					System.out.println(st.depth+1);
					return;
				}
				//겹칠때 이동 횟수가 더 큰 것 한칸 뒤로
				if(RX==BX&&RY==BY) {
					if(BC<RC) {
						RX = RX -d[0];
						RY = RY -d[1];
					}else {
						BX = BX -d[0];
						BY = BY -d[1];
					}
				}
				
				if(!visit[RX][RY][BX][BY]) {
					visit[RX][RY][BX][BY] = true;
					queue.offer(new State(BX, BY, RX, RY, st.depth+1));
				}
			}
		}
		System.out.println("-1");
	}
	
	static int[] move(int X, int Y, int[] d) {
		int nx = X+d[0];
		int ny = Y+d[1];
		int count = 0;
		while(map[X][Y]!='O'&&map[nx][ny]!='#') {
			X = X+d[0];
			nx = X+d[0];
			Y = Y+d[1];
			ny = Y+d[1];
			count++;
		}
		return new int[] {X,Y,count};
	}
	

	static class State{
		int bx;
		int by;
		int rx;
		int ry;
		int depth;
		
		public State(int bx, int by, int rx, int ry, int depth) {
			this.bx = bx;
			this.by = by;
			this.rx = rx;
			this.ry = ry;
			this.depth = depth;
		}
		
	}
}
