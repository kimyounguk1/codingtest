package cote;

import java.io.*;
import java.util.*;

public class dp10942 {
	
	static int N, M;
	static int[] arr;
	static Boolean[][] rs;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N+1];
		M = sc.nextInt();//시행횟수
		rs = new Boolean[N+1][N+1];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			boolean r = dp(s,e);
			if(r) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}
	
	public static boolean dp(int s, int e) {
		if(s>=e) return true;
		if(rs[s][e]!=null) return rs[s][e];
		if(arr[s]==arr[e]) {
			rs[s][e] = dp(s+1, e-1);
			return rs[s][e];
		}else {
			rs[s][e] = false;
			return rs[s][e];
		}
	}

}
