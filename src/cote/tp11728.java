package cote;

import java.io.*;
import java.util.*;

public class tp11728 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st1 = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st1.nextToken());
	    int M = Integer.parseInt(st1.nextToken());
	    
	    int[] arr1 = new int[N+1];
	    int[] arr2 = new int[M+1];
	    
	    StringTokenizer st2 = new StringTokenizer(br.readLine());
	    
	    for(int i=0; i<N; i++) {
	    	arr1[i] = Integer.parseInt(st2.nextToken());
	    }
	    
	    StringTokenizer st3 = new StringTokenizer(br.readLine());
	    
	    for(int i=0; i<M; i++) {
	    	arr2[i] = Integer.parseInt(st3.nextToken());
	    }
	    //배열 저장까지 완료
	    
	    int s1 = 0;
	    int s2 = 0;
	    int index = 0;
	    
	    int[] result = new int[N+M];
	    
	    while(s1<N&&s2<M) {
	    	if(arr1[s1]<arr2[s2]) {
	    		result[index++] = arr1[s1++];
	    	} else {
	    		result[index++] = arr2[s2++];
	    	}
	    }
	    while(s1<N) {
	    	result[index++] = arr1[s1++];
	    }
	    while(s2<M) {
	    	result[index++] = arr2[s2++];
	    }
	    for (int a : result) {
	        bw.write(a + " ");
	    }
	    bw.flush();
	    
	}

}
