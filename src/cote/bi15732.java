package cote;
import java.io.*;
import java.util.*;
public class bi15732 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[][] jobs = new int[k][3]; // 각 작업: start, end, diff
		
		for(int i=0; i<k; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			jobs[i][0] = Integer.parseInt(st2.nextToken());
			jobs[i][1] = Integer.parseInt(st2.nextToken());
			jobs[i][2] = Integer.parseInt(st2.nextToken());
		}
		int start = 1;
		int end = n;
		int answer = 0;
		
		while(start<=end) {
			int mid = (start + end)/2;
			if(check(jobs, mid)>=d) {
				answer = mid;
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		System.out.println(answer);
		
	}
	static int check(int[][] jobs, int mid) {
		int sum = 0;
		for(int i=0; i<jobs.length; i++) {
			int start = jobs[i][0];
			int end = jobs[i][1];
			int diff = jobs[i][2];
			
			if(mid>=start) {
				sum = sum + (Math.min(mid, end) - start) / diff + 1;
			}
		}
		return sum;
	}

}
