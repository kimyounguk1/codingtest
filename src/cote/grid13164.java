package cote;

import java.util.*;
import java.io.*;

public class grid13164 {
	
	static int N,K;
	static Integer array[];
	static int diff[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //N개의 숫자
		K = sc.nextInt(); //K개의 그룹
		
		for(int i=0; i<N; i++) {
			array[i] = sc.nextInt();
		}
		
		for(int i=0; i<N-1; i++) {
			//숫자간의 차이를 배열에 저장
			diff[i] = array[i+1] - array[i]; //오름차순 정렬된 값
		}
		
		//저장된 diff에서 가장 큰 수 k-1개를 제거해서 더하면 가장큰 수와 가장 작은 수의 차의 합
		Arrays.sort(array, Collections.reverseOrder());
		
		for(int i=0; i<K-1; i++) {
			array[i] = 0;
		}
		
		int sum = 0;

		for(int l:array) {
			sum += l;
		}
		
		System.out.println(sum);
	}

}
