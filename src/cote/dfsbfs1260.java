package cote.exam1;

import java.util.*;
import java.io.*;

public class dfsbfs1260 {
	
	static int N,M;
	static boolean[] visited;
	static boolean[] bfsvisited;
	static List<Integer>[] list;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			
			N = sc.nextInt();
			M = sc.nextInt();
			visited = new boolean[N+1];
			bfsvisited = new boolean[N+1];
			int V = sc.nextInt();
			list = new ArrayList[N+1];
			for(int i=1; i<=N; i++) {
				list[i] = new ArrayList<>();
			}
			for(int i=0; i<M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				list[x].add(y);
				list[y].add(x);
			}
			System.out.print(V + " ");
			dfs(V);
			System.out.println();
			System.out.print(V + " ");
			bfs(V);
			
	}
	
	static void dfs(int v) {
		if(visited[v])return;
		
		visited[v] = true;
		Collections.sort(list[v]);
		for(int i:list[v]) {
			if(!visited[i]) {
				System.out.print(i + " ");
				dfs(i);
			}
		}
	}
	
	static void bfs(int V) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);
		bfsvisited[V] = true;
		while(!queue.isEmpty()) {
			int s = queue.poll();
			for(int d:list[s]) {
				if(!bfsvisited[d]) {
					bfsvisited[d] = true;
					System.out.print(d + " ");
					queue.offer(d);
				}
			}
		}
	}

}
