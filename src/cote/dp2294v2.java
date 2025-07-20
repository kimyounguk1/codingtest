package cote;

import java.io.*;
import java.util.*;

public class dp2294v2 {

	static int k,n;
	static int[][] state;
	static int[] coin;
	static int inf = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //동전 수
		k = Integer.parseInt(st.nextToken()); //합
		
		state = new int[n][k];
		coin = new int[n];
		
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(br.readLine()); //0~n-1
		}
		
		int result = dp(0,0);
		bw.write(String.valueOf(result >= 100001 || result == 0 ? -1 : result));
		bw.flush();
		bw.close();
	}
	
	static int dp(int idx, int sum) {
		if(sum > k) return 100001;
		if(sum == k) return 0;
		if(state[idx][sum] != 0) return state[idx][sum];
		
		state[idx][sum] = 100001;
		for(int i=idx; i<n; i++) {
			state[idx][sum] = Math.min(state[idx][sum],dp(i,sum+coin[i])+1);
		}
		return state[idx][sum];
	}
}
