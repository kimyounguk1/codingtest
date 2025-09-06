package cote;
import java.io.*;
import java.util.*;
public class bi7453 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] A = new long[n];
		long[] B = new long[n];
		long[] C = new long[n];
		long[] D = new long[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[i] = Long.parseLong(st.nextToken());
			B[i] = Long.parseLong(st.nextToken());
			C[i] = Long.parseLong(st.nextToken());
			D[i] = Long.parseLong(st.nextToken());
		}
		
		long[] array1 = new long[n*n];
		long[] array2 = new long[n*n];
		
		int index1 = 0;
		int index2 = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				array1[index1++] = A[i] + B[j];
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				array2[index2++] = C[i] + D[j];
			}
		}
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		long count = 0;
		for(long a: array1) {
			
			int start = lowerBound(array2, 0);
			int end = upperBound(array2, 0);
			
			count = count + (end - start);
		}
		
		System.out.println(count);
	}
	
	static int lowerBound(long[] array, int key) {
		int l = 0;
		int r = array.length;
		
		while(l<r) {
			int mid = (l+r)/2;
			if(array[mid]<key) {
				l = mid+1;
			}else {
				r = mid;
			}
		}
		return l;
	}
	
	static int upperBound(long[] array, int key) {
		int l = 0;
		int r = array.length;
		
		while(l<r) {
			int mid = (l+r)/2;
			if(array[mid]<=key) {
				l = mid + 1;
			}else {
				r = mid;
			}
		}
		return l;
	}

}
