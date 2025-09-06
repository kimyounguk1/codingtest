package cote;
import java.io.*;
import java.util.*;
public class bi2143 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long t = Long.parseLong(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int[] array1 = new int[n];
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			array1[i] = Integer.parseInt(st1.nextToken());
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int[] array2 = new int[m];
		
		for(int i=0; i<m; i++) {
			array2[i] = Integer.parseInt(st2.nextToken());
		}
		//부배열의 모든 경우의 수 배열로 만들기
		int sizeA = n*(n+1)/2;
		int[] arrayA = new int[sizeA];
		int indexA = 0;
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=i; j<n; j++) {
				sum = sum + array1[j];
				arrayA[indexA++] = sum;
			}
		}
		
		int sizeB = m*(m+1)/2;
		int[] arrayB = new int[sizeB];
		int indexB = 0;
		for(int i=0; i<m; i++) {
			int sum = 0;
			for(int j=i; j<m; j++) {
				sum = sum + array2[j];
				arrayB[indexB++] = sum;
			}
		}
		
		long count = 0;
		
		for(int a:arrayA) {
			long need = t-a;
			
			int start = lowerBound(arrayB, need);
			int end = upperBound(arrayB, need);
		
			count = count + (end - start);
		}
	}
	
	static int lowerBound(int[] array, long need) {
		int l = 0;
		int r = array.length - 1;
		
		while(l<r) {
			int mid = (l+r)/2;
			if(array[mid]<need) {
				l = mid + 1;
			}else {
				r = mid;
			}
		}
		return l;
	}
	
	static int upperBound(int[] array, long need) {
		int l = 0;
		int r = array.length - 1;
		
		while(l<r) {
			int mid = (l+r)/2;
			if(array[mid]<=mid) {
				l = mid + 1;
			}else {
				r = mid;
			}
		}
		return l;
	}
	
}
