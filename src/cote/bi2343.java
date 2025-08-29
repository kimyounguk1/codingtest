package cote;

import java.io.*;
import java.util.*;

public class bi2343 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken());
		int m = Integer.parseInt(st1.nextToken());
		
		int[] arr = new int[n];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
			sum += arr[i];
		}
		
		int start = 0;
		int end = sum;
		int answer = 0;
		while(start<=end) {
			int mid = (start+end)/2;
			if(check(mid, arr)<=m) {
				answer = mid;
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		System.out.println(answer);
	}
	static int check(int mid, int[] arr) {
		int count = 1;
		int hap = 0;
		for(int r:arr) {
			hap = hap + r;
			if(hap>mid) {
				count++;
				hap = r;
			}
		}
		return count;
		
	}

}
