package cote;
import java.util.*;
import java.io.*;
public class tp1484 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int G = Integer.parseInt(br.readLine());
		
		int e = 2;
		int b = 1;
		
		boolean flag = false;
		
		while(e<=50000) {
			long e2 = e*e;
			long b2 = b*b;
			if(e2-b2 == G) {
				flag = true;
				System.out.println(e);
				e++;
				b++;
			}else if(e2-b2<G) {
				e++;
			}else if(e2-b2>G) {
				b++;
			}
		}
		if(!flag) {
			System.out.println(-1);
		}

	}

}
