package cote;

import java.io.*;
import java.util.*;

public class bi2805 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		//나무의 수
		int n = Integer.parseInt(st1.nextToken());
		//가져가야 하는 나무길이
		int m = Integer.parseInt(st1.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		Arrays.sort(arr);
		
		long low = 0;
		long high = arr[n-1];
		
		long answer=0;
		
		while(low<=high) {
			long mid = (low + high)/2;
			if(check(arr, mid)>=m) {
				answer = mid;
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		System.out.println(answer);
	}
	
	static long check(int[] arr, long mid) {
		long sum = 0;
		for(int l:arr) {
			if(l-mid>0) {
				sum += l-mid;
			}
		}
		return sum;
	}

}
