package cote;

import java.io.*;
import java.util.*;

public class dp2293v2 {
	
	static Integer[] state; //일차원 배열로 풀어보기
	static int n,k; //갯수, 금액 합
	static int[] coin; //동전 가치의 배열
	static int count;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		state = new Integer[k+1];
		coin = new int[n];
		
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int result = dp(0);
		if(result != 0) {
			System.out.println(result);
		}
	}
	
	static int dp(int sum) {
	    if (sum == k) return 1;
	    if (sum > k) return 0;
	    if (state[sum] != null) return state[sum];
	    
	    int res = 0;
	    for (int c : coin) {
	        res += dp(sum + c);
	    }
	    return state[sum] = res;
	}

}
