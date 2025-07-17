package cote;

import java.util.*;
import java.io.*;

public class dp1695 {
	static int[] ar;
	static int[][] state;
	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ar = new int[n];
		state = new int[n][n];
		
		for(int i=0; i<n; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = dp(0, n-1);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				state[i][j] = -1;
			}
		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
	static int dp(int st, int ed) {
		int start = ar[st];
		int end = ar[ed];
		if(st>=ed) return 0;
		if(state[st][ed]!=-1) return state[st][ed];
		state[st][ed] = 0;
		int res = 0;
		if(start!=end) {
			res += Math.min(dp(st+1, ed)+1, dp(st, ed-1)+1);
		}
		if(start == end) {
			res += dp(st+1, ed-1);
		}
		return state[st][ed]=res;
	}

}
