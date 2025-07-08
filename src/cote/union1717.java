package cote.exam1;
import java.util.*;
public class union1717 {
	static int[] parent;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		parent = new int[N+1];
		
		for(int i=0; i<N+1; i++) { //대표노드 초기화
			parent[i] = 1;
		}
		for(int i=0; i<M; i++) { //질의 계산하는 부분
			int question = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(question == 0) { //union
				union(a,b);
			}else { //같은 원소인지 보기
				boolean result = checkSame(a,b);
				if(result) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
	}
	private static void union(int a, int b) {
		//대표 노드를 찾아서 연결하기
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b] = a;
		}
	}
	private static int find(int a) {
		if(a==parent[a]) return a;
		else {
			return parent[a] = find(parent[a]); //value를 index로 바꿔서 찾기
		}
	}
	
	private static boolean checkSame(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return true;
		return false;
	}

}
