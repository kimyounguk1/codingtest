package cote;

import java.io.*;
import java.util.*;

public class grid13904 {
	
	static int N, total;
	static List<Task> assi;
	static boolean[] visit;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		assi = new ArrayList<>();
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			String[] a = br.readLine().split(" ");
			int d = Integer.parseInt(a[0]);
			int c = Integer.parseInt(a[1]);
			assi.add(new Task(d,c));
			max = Math.max(max,d);
		}
		
		visit = new boolean[max+1];
		
		total = 0;
		
		Collections.sort(assi);
		
		for(Task t:assi) {
			int d = t.day;
			int c = t.cost;
			
			for(int i=d; i>0; i--) {
				if(!visit[i]) {
					visit[i] = true;
					total += c;
					break;
				}
			}
		}
		System.out.println(total);
	}
	
	static class Task implements Comparable<Task> {
		int day;
		int cost;
		
		public Task(int day, int cost) {
			this.cost = cost;
			this.day = day;
		}
		@Override
		public int compareTo(Task o) {
			return o.cost - this.cost; //this부터면 오름차순, 변수부터면 내림차순
		}
		
	}

}
