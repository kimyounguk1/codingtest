package cote;
import java.io.*;
import java.util.*;
public class tp2473 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		long min = Long.MAX_VALUE;
		long a = 0;
		long b = 0;
		long c = 0;
		
		for(int i=0; i<=n-3; i++) {
			long s = arr[i];
			int start = i+1;
			int end = n-1;
			while(start<end) {
				int diff = arr[start] + arr[end];
				if(diff + s == 0) {
					System.out.print(arr[i] + " " + arr[start] + " " + arr[end]);
					return;
				}else if(diff + s > 0) {
					long abs = Math.abs(diff + s);
					if(min>abs) {
						min = abs;
						a = arr[i];
						b = arr[start];
						c = arr[end];
					}
					end--;
				}else if(diff + s < 0) {
					long abs = Math.abs(diff + s);
					if(min>abs) {
						min = abs;
						a = arr[i];
						b = arr[start];
						c = arr[end];
					}
					start++;
				}
			}
		}
		System.out.println(a + " " + b + " " + c);
	}

}
