package cote;

import java.io.*;
import java.util.*;

public class grid1931 {
	
	static int N, S, E;
	static List<int[]> list;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		list = new LinkedList<>();
		for(int i=0; i<N; i++) { //N개의 회의
			S = sc.nextInt();
			E = sc.nextInt();
			list.add(new int[] {S,E}); //회의 리스트
		}
		//리스트 정렬(종료 시간 빠른순, 시작시간 빠른 순);
		list.sort((e1,e2)->{
			if(e1[1]==e2[1]) {
				return e1[0] - e2[0];
			}else {
				return e1[1] - e2[1];
			}
		});
		int count = 0;
		int endTime = 0;
		for(int i=0; i<list.size(); i++) {
			if(endTime<=list.get(i)[0]) {
				endTime = list.get(i)[1];
				count++;
				System.out.println(endTime);
			}
		}
		System.out.println(count);
	}

}
