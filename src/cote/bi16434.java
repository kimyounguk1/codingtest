package cote;
import java.io.*;
import java.util.*;
public class bi16434 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st1.nextToken()); //방의 개수
		int h = Integer.parseInt(st1.nextToken()); //용사의 초기 공격력
		
		Node[] arr = new Node[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			long a = Long.parseLong(st2.nextToken()); //방의 정보 1몬스터 2 물약
			long b = Long.parseLong(st2.nextToken()); //몬스터 공격력 or 공격력 증가
			long c = Long.parseLong(st2.nextToken()); //몬스터 체력 or 체력 회복
			
			Node node = new Node(a,b,c);
			arr[i] = node;
		}
		
		long start = 1;
		long end = Long.MAX_VALUE-1;
		long answer = 0;
		
		while(start<=end) {
			long mid = (start+end)/2;
			if(check(mid,arr, h)) {
				answer = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
	static boolean check(long mid, Node[] arr, int h) {
		//방을 빠져나갈 수 있어야함, mid는 최대 체력
		long maxHealth = mid;
		long now = mid;
		long attack = h;
		for(Node n:arr) {
			if(n.room == 1) {
				long mon_heal = n.health;
				long num = mon_heal/attack;
				if(mon_heal%attack == 0) num--;
				if(num*n.att>=now) {
					return false;
				}
				else {
					now = now - num*n.att;
				}
			}else {
				attack += n.att;
				now += n.health;
				if(maxHealth<now) now = maxHealth;
			}
		}
		
		return true;
	}
	
	static class Node{
		long room;
		long att;
		long health;
		
		public Node(long room, long att, long health) {
			this.room = room;
			this.att = att;
			this.health = health;
		}
	}

}
