package cote;

import java.io.*;
import java.util.*;

public class dp12865 {
	
	static int N,K;
	static Integer[][] state;
	static List<int[]> list;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		state = new Integer[N][K+1];
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st2.nextToken());
			int v = Integer.parseInt(st2.nextToken());
			list.add(new int[] {w,v});
		}
		
		int result = dp(0,0);
		System.out.println(result);
		
	}
	
	static int dp(int start, int weight) {
		if(start>=N) return 0;
		if(weight == K) return 0;
		if(state[start][weight]!=null) return state[start][weight];
		state[start][weight] = 0;
		for(int i=start; i<N; i++) {
			if(list.get(i)[0]+weight<=K) { //기존거랑 그 이후를 진행한 것에 대해서 큰것 선택
				if(state[start][weight]<dp(i+1,weight+list.get(i)[0]) + list.get(i)[1]) {
					state[start][weight] = dp(i+1,weight+list.get(i)[0]) + list.get(i)[1];
				}
			}
		}
		return state[start][weight];
	}

}
