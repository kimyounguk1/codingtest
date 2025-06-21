package cote.exam1;

import java.util.*;
import java.io.*;

public class dijkstra2211 {
	
	static int N,M;
	static List<Node>[] A;
	static int[] dist;
	static int[] prev;
	
	public static class Node implements Comparable<Node>{
		int end;
		int cost;
		public Node(int end, int cost) {
			this.end =end;
			this.cost =cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		A = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			A[i] = new ArrayList<>();
		}
		
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		prev = new int[N+1];
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			A[a].add(new Node(b,c));
			A[b].add(new Node(a,c));
		}
		
		dijkstra(1);
		System.out.println(N-1);
		
		List<String> result = new ArrayList<>();
		for(int i=2; i<=N; i++) {
			result.add(prev[i]+" "+i);
		}
	
	for(int i=0; i<result.size(); i++) {
		System.out.println(result.get(i));
	}
}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(1,0));
		dist[start]= 0;
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			if(now.cost>dist[now.end])continue;
			for(Node d:A[now.end]) {
				int ne = d.end;
				int nc = d.cost;
				
				if(dist[ne]>now.cost+nc) {
					dist[ne] = now.cost+nc;
					queue.offer(new Node(ne,nc+now.cost));
					prev[ne] = now.end;
				}
			}
		}
	}

}
