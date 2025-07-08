package cote;

import java.io.*;
import java.util.*;

public class back1182 {
	
	static int N,S;
	static boolean[] visited;
	static int[] A;
	static int count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			
			N = sc.nextInt();
			visited = new boolean[N];
			A = new int[N];
			S = sc.nextInt();
			
			for(int i=0; i<N; i++) {
				A[i] = sc.nextInt();
			}
			
			dfs(0);
			if(S==0) {
				System.out.println(count-1);
			}else {
				System.out.println(count);				
			}

			
	}
	static void dfs(int depth) {
		
		if(depth == N) {
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(visited[i]) {
					sum += A[i];
				}
			}
			if(sum == S) {
				count++;
				return;
			}
			return;
		}
		
		visited[depth] = true;
		dfs(depth+1);
		visited[depth] = false;
		dfs(depth+1);
	}

}
