package cote;

import java.util.*;

public class grid19598 {
	
	static class Task implements Comparable<Task>{
		public int start;
		public int end;
		public Task(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Task t) {
			return this.end - t.end;
		} //종료시간 오름차순 정렬
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Task[] array = new Task[N];
		for(int i=0; i<N; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			array[i] = new Task(s,e);
		}
		
		Arrays.sort(array, (e1,e2)->{
			if(e1.start == e2.start) {
				return e1.end - e2.end;
			}else {
				return e1.start - e2.start;
			}
		}); //시작 오른차순 정렬, 종료 오름차순 정렬
		
		PriorityQueue<Task> pq = new PriorityQueue<>();
		
		for(Task t: array) {
			if(pq.isEmpty()) {
				pq.offer(t);
				
			}else {
				Task a = pq.peek();
				if(a.end<=t.start) {
					pq.poll();
					pq.offer(t);
				}else {
					pq.offer(t);
				}
			}
		}
		System.out.println(pq.size());
	}

}
