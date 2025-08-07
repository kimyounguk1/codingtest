package cote;

import java.io.*;
import java.util.*;

public class tp2018 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int n = Integer.parseInt(br.readLine());

	    int start = 1;
	    int end = 1;
	    int count = 0;
	    int sum = 0;
	    
	    
	    while(end <= n+1) { //end가 마지막보다 하나 더 커질 수 있어야 함
	        if(sum >= n) {
	            sum = sum - start++;
	        } else if(sum < n) {
	            sum = sum + end++;
	        }
	        if(sum == n) {
	            count++;
	        }
	       
	    }
	    System.out.println(count);
	}

}
