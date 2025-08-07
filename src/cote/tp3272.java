package cote;
import java.io.*;
import java.util.*;
public class tp3272 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} //배열에 값 넣기
		
		Arrays.sort(arr);
		
		int x = Integer.parseInt(br.readLine());
		
		int start = 0;
		int end = n-1;
		int sum = 0;
		int count = 0;
		
		while(start<end) {
			sum = arr[start]+arr[end];
			if(sum == x) {
				count++;
				start++;
				end--;
			}else if(sum > x) {
				end--;
			}else if(sum < x) {
				start++;
			}
		}
		System.out.println(count);
	}

}
