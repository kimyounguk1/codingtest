package cote;
import java.io.*;
import java.util.*;
public class bi2776 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] arr1 = new int[n];
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr1[j] = Integer.parseInt(st1.nextToken());
			}
			
			Arrays.sort(arr1);
			
			int m = Integer.parseInt(br.readLine());
			
			int[] arr2 = new int[m];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr2[j] = Integer.parseInt(st2.nextToken());
			}
			
			int start = 0;
			int end = n-1;
			boolean flag = false;
			for(int k=0; k<m; k++) {
				while(start<=end) {
					int mid = (start+end)/2;
					
					if(arr1[mid]==arr2[k]) {
						flag = true;
						break;
					}
					
					if(arr1[mid]>arr2[k]) {
						end = mid-1;
					}else {
						start = mid+1;
					}
				}
				if(flag) {
					System.out.println(1);
				}else {
					System.out.println(0);	
				}
			}
		}
	}

}
