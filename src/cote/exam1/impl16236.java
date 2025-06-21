package cote.exam1;
import java.util.*;

public class impl16236 {
	
	static int[][] map;
	static int[][] dist;
	static boolean[][] visit;
	static int[] start;
	static int size = 2;
	static int count = 0;
	static int M;
	static boolean lop = true;
	static int result;
	static int[][] directions = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	static int[] loc;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		
		//배열 초기화
		
		map = new int[M][M];
		start = new int[2];
		loc = new int[2];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==9) {
					start = new int[] {i,j};
				}
			}
		}

		
		while(lop) {
			lop = bfs();
		}
		System.out.println(result);
		
		
		
		
	}
	
	static boolean bfs() {
		dist = new int[M][M];
		visit = new boolean[M][M];
		for (int i = 0; i < M; i++) {
		    Arrays.fill(dist[i], -1);
		}
		
		int minDist = Integer.MAX_VALUE;
		
		List<int[]> candidate = new ArrayList<>(); //후보 배열
		Queue<int[]> queue = new LinkedList<>();
		
		int X = start[0];
		int Y = start[1];
		visit[X][Y] = true;
		dist[X][Y] = 0;
		queue.offer(new int[] {X,Y});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			
			 
			for(int[] d:directions) {
				int nx = x+d[0];
				int ny = y+d[1];
				
				if (dist[x][y] > minDist) {
		            break;  // 더 먼 거리는 볼 필요 없음
		        }
				
				if(nx>=0&&nx<M&&ny>=0&&ny<M&&!visit[nx][ny]&&map[nx][ny]<=size) {
					visit[nx][ny] = true;
					dist[nx][ny] = dist[x][y]+1;
					if(map[nx][ny]!=0 && map[nx][ny]<size) {
						if(dist[nx][ny]<minDist) {//최솟값보다 더 작은 거리면 리스트 초기화 및 갱신
							candidate.clear();
							candidate.add(new int[] {nx,ny});
							minDist = dist[nx][ny];
						}else if(dist[nx][ny]==minDist) {
							candidate.add(new int[] {nx,ny});
						}
					}
					queue.offer(new int[] {nx,ny});
				}
			}
		}
		if(candidate.isEmpty()) return false;
		// 가장 위, 가장 왼쪽 고르기
	    candidate.sort(Comparator.<int[]>comparingInt(a -> a[0])
	                               .thenComparingInt(a -> a[1]));

	    int[] target = candidate.get(0);
	    map[start[0]][start[1]] = 0;
	    start = target;
	    map[start[0]][start[1]] = 9;
	    result += minDist;
	    count++;
	    

	    if (count == size) {
	        size++;
	        count = 0;
	    }

	    return true;
	}
}
