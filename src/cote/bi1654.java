package cote;
import java.io.*;
import java.util.*;
public class bi1654 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //k개
		int m = Integer.parseInt(st.nextToken()); //m개 최대 길이로 만들기
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long start = 1;
		long end = arr[n-1];
		long answer = 0;
		while(start<=end) {
			long mid = (start+end)/2;
			if(check(mid,arr)>=m) {
				answer = mid;
				start = mid+1;
			}else {
				end = mid - 1;
			}
		}
		System.out.println(answer);
	}

	static long check(long mid, int[] arr) {
		long count = 0;
		for(int r:arr) {
			count = count + r/mid;
		}
		return count;
	}
}
