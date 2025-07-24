package cote;
import java.io.*;
import java.util.*;
public class string16934 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		Set<String> set = new HashSet<>();
		
		for(int i=0; i<n; i++) {
			int k=2;
			String s = br.readLine();
			if(!list.contains(s)) {
				list.add(s);
			} else {
				while(true) {
					String ns = s+k;
					if(!set.contains(ns)) {
						set.add(ns);
						break;
					} else {
						k++;
					}
				}
			}
		}
		
		for(String l:list) {
			for(int i=1; i<l.length(); i++) {
				String a = l.substring(0,i);
				if(!set.contains(a)) {
					set.add(a);
					break;
				}
			}
		}
		for(String s:set) {
			System.out.println(s);
		}
	}

}
