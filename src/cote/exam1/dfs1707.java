package cote.exam1;
import java.util.*;

public class dfs1707 {
	
	static int k;
	static int V,E;
	static int[] check;
	static boolean[] visited;
	static boolean bin;
	static List<Integer>[] A;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		k = sc.nextInt();
		for(int q=0; q<k; q++) {
			bin = true;
			V = sc.nextInt();
			E = sc.nextInt();
			check = new int[V+1];
			visited =new boolean[V+1];
			A = new ArrayList[V+1];
			for(int i=1; i<=V; i++) {
				A[i] = new ArrayList<>();
			}
			for(int i=0; i<E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				A[a].add(b);
				A[b].add(a);
			}
			for(int i=1; i<=V; i++) {
				if(!visited[i]) {
					dfs(i);
				}
			}
			if(bin) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	static void dfs(int start) {
		visited[start] = true;
		for(int d:A[start]) {
			if(visited[d]) {
				if(check[d] == check[start]) {
					bin = false;
					return;
				}
			}else {
				check[d]=(check[start]+1)%2;
				dfs(d);
			}
		}
	}
}
