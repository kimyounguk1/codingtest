package cote;
import java.io.*;
import java.util.*;
public class dp2294 {
	
	static int k,n;
	static Integer[] state;
	static Integer[][] state2;
	static int[] coin;
	static int inf = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //동전 수
		k = Integer.parseInt(st.nextToken()); //합
		
		state = new Integer[k]; //경우의 수 최솟값 
		state2 = new Integer[k][n];
		coin = new int[n];
		
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int result = dp(0,0);
		//bw.write(String.valueOf(result == inf ? -1 : result));
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
	
	static int dp(int sum) {
		
		if(sum>k) return inf;
		if(sum == k) return 0;
		if(state[sum]!=null) return state[sum];
		
		int res = inf;
		for(int i=0; i<n; i++) {
			int next = dp(sum+coin[i]);
			if(next!=inf) {
				res = Math.min(res, next + 1);
			}
		}

		return state[sum] = res;
	}
	
	static int dp(int idx, int sum) {
		if(sum>k) return inf;
		if(idx == n) return inf;
		if(sum == k) return 0;
		if(state2[sum][idx]!=null) return state2[sum][idx];
		int res = dp(idx + 1, sum); // 동전 안 쓰는 경우

		int temp = dp(idx, sum + coin[idx]);
		if (temp != inf) {
			res = Math.min(res, temp + 1); // 동전 쓰는 경우
		}
		
		return state2[sum][idx] = res;
	}
}
