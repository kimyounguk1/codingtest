package cote;
import java.io.*; 
import java.util.*;
public class bi15732v2 {

		// TODO Auto-generated method stub
		public static void main(String[] args) throws IOException {
		    // TODO Auto-generated method stub
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		    StringTokenizer st = new StringTokenizer(br.readLine());

		    int n = Integer.parseInt(st.nextToken());
		    int k = Integer.parseInt(st.nextToken());
		    int d = Integer.parseInt(st.nextToken());

		    int[] arr = new int[n + 1];

		    for (int i = 0; i < k; i++) {
		        StringTokenizer st2 = new StringTokenizer(br.readLine());
		        int start = Integer.parseInt(st2.nextToken());
		        int end = Integer.parseInt(st2.nextToken());
		        int diff = Integer.parseInt(st2.nextToken());

		        int index = start;
		        while (index <= end) {
		            arr[index]++;
		            index = index + diff;
		        }
		    }

		    int start = 1;
		    int end = n;
		    int answer = 0;

		    while (start <= end) {
		        int mid = (start + end) / 2;
		        if (check(arr, mid) >= d) {
		            answer = mid;
		            end = mid - 1;
		        } else {
		            start = mid + 1;
		        }
		    }

		    System.out.println(answer);
		}

		static int check(int[] arr, int mid) {
		    int sum = 0;
		    for (int i = 1; i <= mid; i++) {
		        sum = sum + arr[i];
		    }
		    return sum;
		
	}

}
