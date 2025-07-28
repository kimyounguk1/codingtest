package cote;
import java.io.*;
import java.util.*;
public class tp2003 {
	public static void main(String[] args) throws IOException{

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    
    int[] arr = new int[N];
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(st1.nextToken());
    }
    
    int start = 0;
    int end = 0;
    int sum = 0;
    int count = 0;
    
    while (end < N) {
        // sum이 M보다 작으면 end를 늘리고, sum에 값 추가
        if (sum < M) {
            sum += arr[end++];
        } 
        // sum이 M보다 크면 start를 늘리고, sum에서 값 빼기
        else if (sum > M) {
            sum -= arr[start++];
        } 
        // sum이 M이면 count 증가
        if (sum == M) {
            count++;
            sum -= arr[start++];  // sum == M일 때는 start 증가
        }
    }
    
    System.out.println(count);
	}

}
