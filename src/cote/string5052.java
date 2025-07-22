package cote;

import java.io.*;
import java.util.*;

public class string5052 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int m = Integer.parseInt(br.readLine());
			String[] ar = new String[m];
			for(int j=0; j<m; j++) {
				ar[j] = br.readLine();
			}
			boolean a = true;
			Arrays.sort(ar);
			for(int k=0; k<m-1; k++) {
				if(ar[k+1].startsWith(ar[k])) {
					a = false;
				}
			}
			if(a) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}

}
