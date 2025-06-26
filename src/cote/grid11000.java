package cote;

import java.io.*;
import java.util.*;

public class grid11000 {
	
	static int N,S,E;
	static List<Clss> list;
	static PriorityQueue<Clss> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list.add(new Clss(S,E));
		}
		
		//시작 시간 기준으로 정렬
		list.sort((e1,e2)->{
			return e1.start - e2.start;
		});
		
		for (Clss lec : list) {
		    if (!pq.isEmpty() && pq.peek().end <= lec.start) {
		        pq.poll(); // 강의실 재사용
		    }
		    pq.offer(lec); // 항상 새 강의는 하나의 강의실에 들어감
		}
		
		System.out.println(pq.size());
		
//		int endTime = 0;
//		int clssNum = 0;
				
		//리스트를 순회중에 삭제하는 건 매우 위험
		//Iterator<Clss> iter = list.iterator(); iterator로 처리 추천
		//while(iter.hasNext()), iter.next(), iter.remove()
//		while(list.size()>0) {
//			endTime = 0;
//			clssNum++;
//			for(int i=0; i<list.size(); i++) {
//				Clss a = list.get(i);
//				if(endTime<=a.start) {
//					endTime = a.end;
//					list.remove(a);
//				}
//			}
//		}
//		System.out.println(clssNum);
		
	}
	
	static class Clss implements Comparable<Clss> {
	    int start;
	    int end;

	    public Clss(int start, int end) {
	        this.start = start;
	        this.end = end;
	    }

	    @Override
	    public int compareTo(Clss o) {
	        return this.end - o.end; // 종료 시간 기준 오름차순
	    }
	}

}
