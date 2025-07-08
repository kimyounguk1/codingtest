package cote;

import java.io.*;
import java.util.*;

public class bfs11403 {
	
	static int M;
	static int[][] A;
	static boolean[] visit;
	static int[][] result;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		A = new int[M][M];
		result = new int[M][M];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<M; i++) {
			bfs(i);
		}
		for (int i = 0; i < M; i++) {
		    for (int j = 0; j < M; j++) {
		        System.out.print(result[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	
	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(v);
		visit = new boolean[M];
		
		while(!queue.isEmpty()) {
			int s = queue.poll();
			for(int i=0; i<M; i++) {
				if(A[s][i] == 1) {
					if(!visit[i]) {
					visit[i] = true;
					result[v][i] = 1;
					queue.offer(i);
					}
				}
			}
		}
	}
//나중에 플루이드 와셜로 풀어보기
}
