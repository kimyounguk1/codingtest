package cote;

import java.io.*;
import java.util.*;

public class tp21921 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int X = Integer.parseInt(st.nextToken());
	    
	    int[] arr = new int[N+1];
	    
	    StringTokenizer st1 = new StringTokenizer(br.readLine());
	    
	    for(int i=0; i<N; i++) {
	    	arr[i] = Integer.parseInt(st1.nextToken());
	    }
	    
	    int start = 0;
	    int end = 0;
	    int max = 0;
	    int sum = 0;
	    int count = 1;
	    int num = 0;
	    
	    while(end <= N) {
	    	if(num>=X) {
	    		sum = sum - arr[start++];
	    		num--;
	    	}else if(num < X) {
	    		sum = sum + arr[end++];
	    		num++;
	    	}
	    	if(num == X) {
	    		if(max<sum) {
	    			max = sum;
	    			count = 1;
	    		}else if(max == sum){
	    			count++;
	    		}
	    	}
	    }
	    if(max == 0) {
	    	System.out.println("SAD");
	    }else {
	    	System.out.println(max);
	    	System.out.println(count);
	    }
	    
	    
	}

}
