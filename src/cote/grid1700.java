package cote;

import java.util.*;
import java.io.*;

public class grid1700 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] order = new int[K];
		for(int i=0; i<K; i++) {
			order[i] = sc.nextInt(); //사용 순서 저장
		}
		
	Set<Integer> multiTap = new HashSet<>(); //set으로 멀티탭 구현
	int unplugCount = 0; //교체 횟수
	
	for(int i=0; i<K; i++) {
		int current = order[i]; //현재 사용해야 하는 제품 숫자
		
		if(multiTap.contains(current)) continue; //이미 꽂혀 있다면 넘어감
		
		if(multiTap.size()<N) { //자리가 있으면 저장하고 넘어가기
			multiTap.add(current);
			continue;
			}
		
		int farthest = -1;  //가장 나중에 사용될 시점의 인덱스
		int idxToRemove = -1;	//위의 인덱스의 가전제품 번호
		
		for(int plugged:multiTap) {
			int nextUse = Integer.MAX_VALUE;
			
			for(int j=i+1; j<K; j++) {//current다음부터 찾기 시작
				if(order[j]==plugged) {//plugged가 order에 처음 나오는 시점
					nextUse = j; //plugged가 다음에 쓰일 시점
					break;
				}//나오지 않으면 MAX_VALUE
			}
			
			if(nextUse>farthest) { //최대값 갱신
				farthest = nextUse;
				idxToRemove = plugged;
			}
		}
		
		//기존 거 제거하고 새로운 거 추가
		multiTap.remove(idxToRemove);
		multiTap.add(current);
		unplugCount++;
		
		}
	System.out.println(unplugCount);
	}

}
