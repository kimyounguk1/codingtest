package cote;

import java.io.*;
import java.util.*;

public class tp17609 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String a = br.readLine();
			
			char[] arr = a.toCharArray();
			
			int start = 0;
			int end = arr.length-1;
			int count = 0;
			
			int result = check(arr,0,arr.length-1,0);
			if(result==0) {
				System.out.println(0);
			}else if(result == 1) {
				System.out.println(1);
			}else {
				System.out.println(2);
			}
		}
	}
	
	public static int check(char[] arr, int start, int end, int count) {
		if(count>2) return 2;
		while(start<end) {
			if(arr[start]==arr[end]) {
				start++;
				end--;
			}else {
				return Math.min(check(arr, start+1, end, count+1), check(arr, start, end-1, count+1));
			}
		}
		return count;
	}

}
