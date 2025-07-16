package cote;

import java.io.*;
import java.util.*;

public class dp2225 {
	
	static int n,k; // 0~n k개
	static Integer[][] state;
	static int a =  1000000000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		state = new Integer[n+1][k+1]; //합이 n인 경우의 수 저장 배열
		
		int result = dp(0,0);
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		
	}
	
	static int dp(int sum, int count) {
		if(count == k) return (sum == n) ? 1 : 0;
		if(sum > n) return 0;
		if(state[sum][count]!=null) return state[sum][count];
		state[sum][count]=0;
		for(int i=0; i<=n; i++){
			state[sum][count] = (state[sum][count] + dp(sum+i, count+1)) % a;
		}
		return state[sum][count];
	}

}
