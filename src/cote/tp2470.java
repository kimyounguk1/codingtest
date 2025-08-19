package cote;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class tp2470 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = n-1;
		long min = Integer.MAX_VALUE;
		int a1 = 0;
		int a2 = 0;
		
		while(start<end) {
			long diff = arr[end] + arr[start];
			long sum = Math.abs(diff);
			if(sum<min) {
				min = sum;
				a1 = start;
				a2 = end;
			}
			if(diff == 0) {
				System.out.println(arr[start] + " " + arr[end]);
				return;
			}else if(diff>0) {
				end--;
			}else if(diff<0) {
				start++;
			}
		}
		System.out.println(arr[a1] + " " + arr[a2]);
		
	}

}
