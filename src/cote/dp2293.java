package cote;

import java.io.*;
import java.util.*;

public class dp2293 {
	
	static int n,k; //갯수, 금액 합
	static Integer[][] state; //금액 및 동전의 상태 후에 동일한 경우에는 동일한 경우의 
	static int[] coin; //동전 가치의 배열
	static int count;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		state = new Integer[n][k];
		coin = new int[n];
		
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int result = dp(0,0); //현재 상태가 0번째 합계 0
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
	static int dp(int idx, int sum) {
		if(idx>=n) return 0;
		if(sum>k) return 0;
		if(sum == k) return 1;
		if(state[idx][sum]!=null) return state[idx][sum];
		//경우의 수를 나눠서 그냥 더하기 아니면 숫자 바꾸기
//		state[idx][sum] = dp(idx+1, sum) + dp(idx, sum+coin[idx]);
//		return state[idx][sum];
		//모든 경우의 수 구하기
		int res = 0;
		for(int i=idx; i<n; i++) {
			res = res + dp(i, sum+coin[i]);
		}
		state[idx][sum] = res;
		return res;
		
		
	}
}
