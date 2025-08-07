package cote;

import java.io.*;
import java.util.StringTokenizer;

public class tp10025 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[1000001];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st1.nextToken());
		int k = Integer.parseInt(st1.nextToken());
		
		for (int i = 0; i < n; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int g = Integer.parseInt(st.nextToken()); // 얼음 양
		    int x = Integer.parseInt(st.nextToken()); // 좌표
		    arr[x] += g; // 얼음양을 좌표에 누적
		}
		
		int max = 0;
		int sum = 0;
		
		for(int i=0; i<2*k+1&&i<1000001; i++) {
			sum = sum + arr[i]; //처음 0부터 배열 생성 (0~2k)
		}
		
		max = sum;
		
		for(int i=1; 2*k+i<=1000000; i++) {//2k+1~10000000 범위까지
			sum = sum - arr[i-1];
			sum = sum + arr[2*k+i];
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
		
	}

}
