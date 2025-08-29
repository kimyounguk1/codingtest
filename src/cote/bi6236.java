package cote;
import java.io.*;
import java.util.*;
public class bi6236 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			max = Math.max(max, arr[i]);
		}
		int start = max;
		int end = sum;
		int answer = 0;
		while(start<=end) {
			int mid = (start+end)/2;
			if(check(mid, arr)<=m) {
				answer = mid;
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
	static int check(int mid, int[] arr) {
		int count = 1;
		int money = mid;
		for(int r:arr) {
			if(money-r<0) {
				count++;
				money = mid -r;
			}
		}
		return count;
	}

}
