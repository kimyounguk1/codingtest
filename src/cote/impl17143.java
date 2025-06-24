package cote;

import java.io.*;
import java.util.*;

public class impl17143 {
	
	static int R,C; //행,열
	static int M; //상어수
	static List<Shark> list; //상어 리스트
	static int[][] directions = {
			{-1,0}, //북
			{1,0}, //남
			{0,1}, //동
			{0,-1} //서
	};
	static Shark[][] map;
	static int total; //전체 사이즈
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		M = sc.nextInt();
		
		list = new LinkedList<>();
		
		map = new Shark[R][C];
		
		for(int i=0; i<M; i++) {
			int r = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			int s = sc.nextInt();
			int d = sc.nextInt();
			int z = sc.nextInt();
			Shark sh = new Shark(r,c,s,d,z);
			list.add(sh);
			map[r][c] = sh;
		}
		
		for(int i=0; i<C; i++) { //열이 한칸 갈때마다 상어 이동 처리
			for(int j=0; j<R; j++) { //행
				if(map[j][i]!=null) { //후에 break;
					list.remove(map[j][i]);
					total += map[j][i].z;
					map[j][i] = null;
					break;
				}
			}
			List<Shark> removelist = new LinkedList<>();
			Shark[][] newmap = new Shark[R][C]; 
				//상어 이동
				for(Shark s:list) {
					
					int speed = s.s;
					
					if(s.d == 1 || s.d == 2) {
						speed %= (R-1)*2;
						}else {
							speed %= (C-1)*2;
						}
					
					for(int k=0; k<speed; k++) { //상어 속력만큼 이동
						//근데 다음이 벽이면 진행 방향 수정
						int nx = s.r + directions[s.d-1][0]; //행 이동
						int ny  = s.c + directions[s.d-1][1]; //열 이동
						if(nx<0||ny<0||nx>=R||ny>=C) {
							if(s.d == 1) {
								s.d = 2;
							}else if(s.d == 2) {
								s.d = 1;
							}else if(s.d == 3) {
								s.d = 4;
							}else if(s.d == 4) {
								s.d = 3;
							}
							nx = s.r + directions[s.d-1][0];
							ny = s.c + directions[s.d-1][1];
						}
						s.r = nx;
						s.c = ny;
					}//이동 완료 후 좌표 변환
					
					if(newmap[s.r][s.c]==null) {
						newmap[s.r][s.c] = s;
					}else {//겹치면 큰 것이 잡아 먹기
						if(s.z>newmap[s.r][s.c].z) {
							removelist.add(newmap[s.r][s.c]);
							newmap[s.r][s.c] = s;
						}else {
							removelist.add(s);
						}
					}
				}
				map = newmap;
				list.removeAll(removelist);
				//실행중인 s를 list에서 삭제하면 오류 발생 removelist 생성후 removeAll로 제거
		}
		System.out.println(total);
		
	}
	
	static class Shark{
		int r; //x
		int c; //y
		int s; //속력
		int d; //이동 방향
		int z; //크기
		
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

}

