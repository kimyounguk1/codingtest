package cote;

import java.io.*;
import java.util.*;
//연속해야 한다는 조건을 제거한 dp변형 문제 풀이
public class dp2003 {
	
	static int[] array;
	static Integer[][] state;
	static int N,M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		array = new int[N];
		state = new Integer[N][M+1];
		
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st1.nextToken());
		}
		
		int result = dp(0,0);
		
		System.out.println(result);

	}
	
	static int dp(int start, int sum) {
		if(sum > M) return 0;
		if(start>=N) return 0;
		if(sum == M) return 1;
		if(state[start][sum]!=null) return state[start][sum];
		state[start][sum] = 0;
		for(int i=start; i<N; i++) {
			state[start][sum] = state[start][sum] + dp(i+1, sum+array[i]);
		}
		return state[start][sum];
	}

}
