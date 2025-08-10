package cote;

import java.io.*;
import java.util.*;

public class tp1644 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//에라토스이 체(소수 찾기)
		boolean[] Prime = new boolean[N+1];
		
		Arrays.fill(Prime, true);
		
		Prime[0] = false;
		Prime[1] = false;
		
		for(int i=2; i*i<=N; i++) {
			if(Prime[i]) {
				for(int j=i*i; j<=N; j=j+i) {
					Prime[j] = false;
				}
			}
		}
		
		List<Integer> list = new LinkedList<>();
		for(int i=0; i<=N; i++) { //N번 반복
			if(Prime[i]) { //소수를 list에 넣기
				list.add(i);
			}
		}
		list.add(0);
		
		int start = 0;
		int end = 0;
		int count = 0;
		int sum = 0;
		
		while(end<=list.size()-1) {
			if(sum>=N) {
				sum = sum - list.get(start++);
			}else if(sum<N) {
				sum = sum + list.get(end++);
			}
			if(sum == N) {
				count++;
			}
		}
		
		System.out.println(count);
	}

}
