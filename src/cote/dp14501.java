package cote;

import java.io.*;
import java.util.*;

public class dp14501 {
	
	static int N;
	static List<int[]> list;
	static Integer[][] state;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		state = new Integer[N+1][N];
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new int[] {d,c});
		}
		
		int result = dp(0,0);
		System.out.println(result);
	}
	
	public static int dp(int day, int num) {
		if(day>N||num==N) return 0;
		if(state[day][num]!=null) return state[day][num];
		state[day][num] = 0;
		for(int i=num; i<N; i++) {
			if(day + list.get(i)[0]<=N) {
				System.out.println(list.get(i)[0]);
				state[day][num] = Math.max(state[day][num], dp(day+list.get(i)[0],i+1)+list.get(i)[1]);
			}
		}
		return state[day][num];
	}
//그 날마다 강의가 존재하는 건데 강의를 선택해서 할 수 있는 것으로 잘못푼 경우
}
