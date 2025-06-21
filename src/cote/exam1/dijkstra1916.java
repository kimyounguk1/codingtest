package cote.exam1;
import java.io.*;
import java.util.*;

public class dijkstra1916 {
	static int N;
	static int M;
	
	static int[] dist;
	static List<Node>[] list;
	
	static class Node implements Comparable<Node> {
		int end;
		int cost;
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);	
		N = sc.nextInt(); //도시수
		M = sc.nextInt(); //노선수
		list = new ArrayList[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int k = sc.nextInt();
			list[x].add(new Node(y,k));
		}
		int start = sc.nextInt();
		int end = sc.nextInt();
		daijkstra(start);
		System.out.println(dist[end]);
	}
	private static void daijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		dist[start] = 0;
		queue.offer(new Node(start,0));
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			int nowCity = now.end;
			int nowCost = now.cost;
			if(dist[nowCity]<nowCost) {continue;}
			for(Node n:list[nowCity]) {
				int nextCity = n.end;
				int nextCost = n.cost;
				if(dist[nextCity]>nextCost+nowCost) {
					dist[nextCity] = nextCost+nowCost;
					queue.offer(new Node(nextCity, nextCost+nowCost));
				}
			}
		}
	}

}
