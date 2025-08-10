package cote;

import java.io.*;
import java.util.*;

public class tp20922 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st1.nextToken());
		int k = Integer.parseInt(st1.nextToken());
		
		int[] arr = new int[n];
		int[] state = new int[1000001];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		int len = 0;
		int start = 0;
		int end = 0;
		
		while(end<arr.length) {
			state[arr[end]]++;
			while(state[arr[end]]>k) {
				state[arr[start]]--;
				start++;
			}
			len = Math.max(len, end-start+1);
			end++;
		}
		
		System.out.println(len);
	}

}
