package cote;
import java.io.*;
import java.util.*;
public class bi2512 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		long m = Long.parseLong(br.readLine());
				
		long start = 0;
		long end = arr[n-1];
		long answer = 0;
		
		while(start<=end) {
			long mid = (start+end)/2;
			if(check(arr, mid)<=m) {
				answer = mid;
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		System.out.println(answer);
	}
	static long check(int[] arr, long mid) {
		long sum = 0;
		for(int l:arr) {
			if(l-mid>0) {
				sum = sum + mid;
			}else {
				sum = sum + l;
			}
		}
		return sum;
	}

}
