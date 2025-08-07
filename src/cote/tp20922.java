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
		int[] state = new int[2000001];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		int count = 0;
		int max = 0;
		
		for(int i=0; i<n; i++) {
			state[arr[i]]++;
			if(state[arr[i]]<=k) count++;
			if(state[arr[i]]>k) {
				max = Math.max(max, count);
				count = 0;
			}
		}
		
		System.out.println(count);
	}

}
