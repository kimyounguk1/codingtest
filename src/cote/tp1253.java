package cote;
import java.io.*;
import java.util.*;

public class tp1253 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		long[] arr = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		long count = 0;
		
		for(int i=0; i<n; i++) {
			int index = i;
			int start = 0;
			int end = n-1;
			while(start<end) {
				if(start == index) {
					start++; 
					continue;
				}
				if(end == index) {
					end--; 
					continue;
				}
				long sum = arr[start] + arr[end];
				if(sum == arr[index]) {
					start++;
					end--;
					count++;
					break;
				}else if(sum > arr[index]) {
					end--;
				}else if(sum < arr[index]) {
					start++;
				}
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();

	}

}
