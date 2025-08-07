package cote;

import java.io.*;
import java.util.*;

public class tp2531 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken()); //레일에 있는 수
	    int d = Integer.parseInt(st.nextToken()); //모든 총 가짓수
	    int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 수
	    int c = Integer.parseInt(st.nextToken()); //쿠폰
	    
	    int[] selected = new int[d+1]; //선택한 것
	    int[] sushi = new int[n]; //레일에 존재하는 것
	    
	    for(int i=0; i<n; i++) {
	    	sushi[i] = Integer.parseInt(br.readLine());
	    }
	    
	    selected[c] = 1;
	    
	    int cnt = 1;
	    int max = 1;
	    
	    for(int i=0; i<k; i++) { //우선 k개를 넣음(0~k-1)
	    	selected[sushi[i]]++;
	    	if(selected[sushi[i]]==1) {
	    		cnt++;
	    	}
	    }
	    max = cnt;
	    
	    for(int i=1; i<n; i++) { 
	    	//나머지 n-1번 반복해줘야함 selected의 sushi[i-1]번째를 없애고 sushi[(i-1+k)%n]을 추가함
	    	selected[sushi[i-1]]--;								//없앤 것의 k번쨰 뒤의 값을 추가 하고 원형이므로 n으로 나눔
	    	if(selected[sushi[i-1]]==0) cnt--;
	    	selected[sushi[(i-1+k)%n]]++;
	    	if(selected[sushi[(i-1+k)%n]]==1) cnt++;
	    	if(cnt>max) max = cnt;
	    }
	    
	    System.out.println(max);
	}

}
