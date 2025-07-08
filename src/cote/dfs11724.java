package cote.exam1;

import java.util.*;
import java.io.*;

public class dfs11724 {
	
	static int M,N;
	static boolean[] visited;
	static int[][] A;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int count = 0;
		M = sc.nextInt();
		N = sc.nextInt();
		visited = new boolean[M+1];
		list = new ArrayList[M+1];
		for(int i=1; i<M+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<N; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i=1; i<=M; i++) {
			if(!visited[i]) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}
	static void dfs(int s) {
		if(visited[s])return;
		
		visited[s]=true;
		for(int d:list[s]) {
			if(!visited[d]) {
				dfs(d);
			}
		}
	}
		
	
}
