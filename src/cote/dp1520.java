package cote;
import java.io.*;
import java.util.*;
public class dp1520 {
	
	static int[][] map;
	static int n,m;
	static int[][] directions = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	static Integer[][] state;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); 
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		state = new Integer[n][m];
		for(int i=0; i<n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] =  Integer.parseInt(st2.nextToken()); 
			}
		}
		int result = dfs(0,0);
		System.out.println(result);
	}
	
	static int dfs(int x, int y) {
		if(x==n-1 && y==m-1) return 1;
		if(state[x][y]!=null) return state[x][y];
		state[x][y] = 0;
		for(int[] d:directions) {
			if(x+d[0]>=0&&y+d[1]>=0&&x+d[0]<n&&y+d[1]<m&&map[x][y]>map[x+d[0]][y+d[1]]) {
				state[x][y]+=dfs(x+d[0],y+d[1]);
			}
		}
		return state[x][y];
	}

}
