package cote;

import java.io.*;
import java.util.*;

public class tp1940 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	 
	    int n = Integer.parseInt(br.readLine());
	    int m = Integer.parseInt(br.readLine());
	    
	    int[] arr = new int[n];
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    for(int i=0; i<n; i++) {
	    	arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(arr);
	    
	    int sum = 0;
	    int start = 0;
	    int end = n-1;
	    int count = 0;
	    
	    while(start<end) {
	    	sum = arr[start]+arr[end];
	    	if(sum == m) {
	    		count++;
	    		start++;
	    		end--;
	    	}else if(sum<m) {
	    		start++;
	    	}else {
	    		end--;
	    	}
	    		
	    }
	    
	    System.out.println(count);
	    
	    
	}

}
