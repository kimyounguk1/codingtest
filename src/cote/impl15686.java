package cote.exam1;
import java.util.*;
import java.io.*;
public class impl15686 {
	static int[][] map;
	static int N;
	static int M;
	static List<int[]> chicken;
	static List<int[]> home;
	static boolean[] visit;
	static int[] choice;
	static int[] minDist;
	static int totalDist;
	static int finalTotal=Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		map = new int[N][N];
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int a = Integer.parseInt(st2.nextToken());
				map[i][j] = a;
				if(a==1) home.add(new int[] {i,j});
				if(a==2) chicken.add(new int[] {i,j});
			}
		}

		visit = new boolean[chicken.size()];
		choice = new int[M];
		
		
		bfs(0);
		System.out.println(finalTotal);
	}
	static void bfs(int depth) {
		if(depth == M) {
			totalDist = 0;
			for(int[] house:home) {
				int minDist = Integer.MAX_VALUE;
				for(int c:choice) {
					int[] chickenloc = chicken.get(c);
					int dist = Math.abs(house[0]-chickenloc[0])+Math.abs(house[1]-chickenloc[1]);
					if(dist<minDist) minDist = dist;
				}
				totalDist += minDist;
			}
			if(totalDist<finalTotal) {
				finalTotal = totalDist;
			}
			return;
		}
		for(int i=0; i<chicken.size(); i++) {
			if(!visit[i]) {
				visit[i] = true;
				choice[depth] = i;
				bfs(depth+1);
				visit[i] = false;
				choice[depth] = 0;
			}
		}
	}
}
