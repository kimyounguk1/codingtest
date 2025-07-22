package cote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class dp14501v2 {

	static int N;
	static List<int[]> list;
	static Integer[] state;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		state = new Integer[N+1];
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new int[] {d,c});
		}
		
		int result = dp(0);
		System.out.println(result);
	}
	
	static int dp(int day) {
		if(day>=N) return 0;

		if(state[day]!=null) return state[day];

		if(day + list.get(day)[0] <= N) {
			state[day] = Math.max(dp(day+1), list.get(day)[1]+dp(day+list.get(day)[0]));
		}else {
			state[day] = dp(day+1);
		}
		return state[day];
	}
}
