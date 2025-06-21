package cote.exam1;

import java.io.*;
import java.util.*;

public class impl3190 {
	
	static int N;
	static Set<String> set; //사과의 위치
	static Deque<int[]> deque; //뱀의 위치
	static Set<String> Sset; //뱀의 위치 셋
	static int[][] ds = {
			{0,1},  // 오른쪽 (초기 방향)
		    {1,0},  // 아래
		    {0,-1}, // 왼쪽
		    {-1,0}  // 위
	};
	static Map<Integer,String> map;
	static int time;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int appleNum = Integer.parseInt(br.readLine());
		set = new HashSet<>();
		for(int i=0; i<appleNum; i++) {
			String[] tokens = br.readLine().split(" ");
			int x = Integer.parseInt(tokens[0]) - 1;
			int y = Integer.parseInt(tokens[1]) - 1;
			set.add(x + "," + y);
		}
		//방향 전환(시간, 방향) 저장
		int dNum = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		for(int i=0; i<dNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		deque = new ArrayDeque<>();
		deque.offer(new int[] {0,0}); //시작 지점
		Sset = new HashSet<>();
		Sset.add("0,0");
		int i=0;
		
		while(true) {
			time++;
			int[] loc = deque.peekFirst();
			int x = loc[0]+ds[i][0];
			int y = loc[1]+ds[i][1];
			deque.addFirst(new int[] {x,y});
			
			if(x<0||x>=N||y<0||y>=N) break;
			if(Sset.contains(String.valueOf(x)+","+String.valueOf(y))) {
				break;
			}
			Sset.add(String.valueOf(x)+","+String.valueOf(y));
			if(!set.contains(String.valueOf(x)+","+String.valueOf(y))) {
				int[] last = deque.pollLast();
				Sset.remove(String.valueOf(last[0])+","+String.valueOf(last[1]));
			}else {
				set.remove(String.valueOf(x)+","+String.valueOf(y));
			}
			if(map.containsKey(time)) {
				String D = map.get(time);//방향
				if(D.equals("D")) {
					i = (i+1)%4;
				}else if(D.equals("L")) {
					i = (i+3)%4;
				}
			}
			
		}
		System.out.println(time);
	}

}
