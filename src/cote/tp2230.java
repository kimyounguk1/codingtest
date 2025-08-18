package cote;
import java.io.*;
import java.util.*;
public class tp2230 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int start = 0, end = 0;
		int answer = Integer.MAX_VALUE;

		while(end < n && start<=end) {
		    int diff = arr[end] - arr[start];
		    
		    if(diff >= k) {
		        answer = Math.min(answer, diff);
		        start++;
		    } else {
		        end++; // 차이를 늘려야 함
		    }
		}
		System.out.println(answer);
	}

}
