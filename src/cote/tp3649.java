package cote;

import java.io.*;
import java.util.*;

public class tp3649 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while((line = br.readLine())!=null) {
		
			long l = Long.parseLong(line)*10_000_000;
			
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = Long.parseLong(br.readLine());
			}
			
			Arrays.sort(arr);
			
			int start = 0;
			int end = arr.length-1;
			long maxA = 0;
			long maxB = 0;
			long maxDiff = Integer.MIN_VALUE;
			
			while(start<end) {
				long a = arr[start];
				long b = arr[end];
				long diff = Math.abs(a-b);
				if(arr[start]+arr[end]==l) {
					if(diff>maxDiff) {
						maxDiff = diff;
						maxA = arr[start];
						maxB = arr[end];
					}
					start++;
					end--;
				}else if(arr[start]+arr[end]>l) {
					end--;
				}else {
					start++;
				}
			}
			
			if(maxDiff>Integer.MIN_VALUE) {
				System.out.println("yes"+ " "+ maxA + " " + maxB);
			}else {
				System.out.println("danger");
			}
		}
		}
		

}
