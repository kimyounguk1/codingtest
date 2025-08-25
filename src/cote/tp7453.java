package cote;

import java.io.*;
import java.util.*;

public class tp7453 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] A = new long[n];
		long[] B = new long[n];
		long[] C = new long[n];
		long[] D = new long[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[i] = Long.parseLong(st.nextToken());
			B[i] = Long.parseLong(st.nextToken());
			C[i] = Long.parseLong(st.nextToken());
			D[i] = Long.parseLong(st.nextToken());
		}
		
		long[] AB = new long[n*n];
		long[] CD = new long[n*n];
		int index = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				AB[index++] = A[i]+B[j];
			}
		}
		
		index = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				CD[index++] = C[i]+D[j];
			}
		}
		
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		int start = 0;
		int end = n*n-1;
		long count = 0;
		
		while(start<AB.length&&end>=0) {
			long diff = AB[start] + CD[end];
			if(diff==0) {
				long valA = AB[start];
				long valC = CD[end];
				//연속으로 동일한 갑이 나오는 경우를 구해서 곱으로 전체 경우의 수를 구함
				long countA = 0;
				while(start<AB.length&&AB[start] == valA) {
					start++;
					countA++;
				}
					
				long countC = 0;
				while(end>=0&&CD[end]==valC) {
					end--;
					countC++;t
				}
				count += countA*countC;
			}else if(diff > 0) {
				end--;
			}else if(diff < 0) {
				start++;
			}
				
		}
		System.out.println(count);
		
	}

}
