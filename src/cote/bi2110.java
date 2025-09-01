package cote;
import java.io.*;
import java.util.*;
public class bi2110 {
	static int n;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		long arr[] = new long[n];
		long max = Long.MIN_VALUE;
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		Arrays.sort(arr);
		
		long start = 1;
		long end = max-arr[0];
		long answer = 0;
		
		while(start<=end) {
			long mid = (start+end)/2;
			if(check(mid, arr)>=c) {
				answer = mid;
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
	
	static long check(long mid, long[] arr) {
		long distance = 0;
		long count = 1;
		for(int i=0; i<n-1; i++) {
			if(distance + arr[i+1] - arr[i] >= mid) {
				count++;
				distance = 0;
			}else {
				distance = distance + arr[i+1] - arr[i];
			}
		}
		return count;
	}

}
