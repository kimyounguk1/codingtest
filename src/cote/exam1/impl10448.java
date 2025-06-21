package cote.exam1;

import java.util.*;

public class impl10448 {
	
	static int t;
	static List<Integer> list;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		list = new LinkedList<>();
		
		for(int i=1; ;i++) {
			int s = i*(i+1)/2;
			list.add(s);
			if(s>1000) {
				break;
			}
		}
		
		t = sc.nextInt();
		for(int i=0; i<t; i++) {
			int a = sc.nextInt();
			if(tri(a)) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}

	}
	
	static boolean tri(int a) {
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<list.size(); j++) {
				for(int k=0; k<list.size(); k++) {
					if(list.get(i)+list.get(j)+list.get(k)==a) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
