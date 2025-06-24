package cote;

import java.util.*;
import java.io.*;

public class impl14499 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//맵 크기
		int M = sc.nextInt();
		int N = sc.nextInt();
		//시작 위치
		int x = sc.nextInt();
		int y = sc.nextInt();
		//이동 횟수
		int T = sc.nextInt(); 
		
		int[][] map = new int[M][N];
		int[] dice = new int[7];
		Arrays.fill(dice, 0);
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<T; i++) {
			int move = sc.nextInt();
			switch(move) {
			case 1:
				if(y<N-1) {
					int tmp1 = dice[6];
					dice[6] = dice[4];
					dice[4] = dice[3];
					dice[3] = dice[2];
					dice[2] = tmp1;
					y = y+1;
					if(map[x][y]==0) {
						map[x][y] = dice[6];
					}else {
						dice[6] = map[x][y];
						map[x][y] = 0;
					}
					System.out.println(dice[3]);
					break;
				}else {
					break;
				}
			case 2:
				if(y>0) {
					int tmp2 = dice[2];
					dice[2] = dice[3];
					dice[3] = dice[4];
					dice[4] = dice[6];
					dice[6] = tmp2;
					y = y-1;
					if(map[x][y]==0) {
						map[x][y] = dice[6];
					}else {
						dice[6] = map[x][y];
						map[x][y] = 0;
					}
					System.out.println(dice[3]);
					break;
				}else {
					break;
				}
			case 3:
				if(x>0) {
					int tmp3 = dice[6];
					dice[6] = dice[1];
					dice[1] = dice[3];
					dice[3] = dice[5];
					dice[5] = tmp3;
					x = x-1;
					if(map[x][y]==0) {
						map[x][y] = dice[6];
					}else {
						dice[6] = map[x][y];
						map[x][y] = 0;
					}
					System.out.println(dice[3]);
					break;
				}else {
					break;
				}
			case 4:
				if(x<M-1) {
					int tmp4 = dice[1];
					dice[1] = dice[6];
					dice[6] = dice[5];
					dice[5] = dice[3];
					dice[3] = tmp4;
					x = x+1;
					if(map[x][y]==0) {
						map[x][y] = dice[6];
					}else {
						dice[6] = map[x][y];
						map[x][y] = 0;
					}
					System.out.println(dice[3]);
					break;
				}else {
					break;
				}
			}
		}
		

	}

}
