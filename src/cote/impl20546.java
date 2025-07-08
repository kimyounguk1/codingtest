package cote.exam1;
import java.util.*;
public class impl20546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int[] A = new int[15];
		
		for(int i=1; i<15; i++) {
			A[i] = sc.nextInt();
		}
		
		int jm = M;
		int sm = M;
		int jj = 0;
		int sj = 0;
		
		
		for(int i=1; i<15;i++) {
			if(jm>=A[i]) {
				jj += jm/A[i];
				jm = jm%A[i];
			}
		}
		
		int pd = 0;
		int md = 0;
		
		for(int i=1; i<15; i++) {
			if(i>1&&A[i]>A[i-1]) {
				pd++;
				md = 0;
			}else if(i>1&&A[i]<A[i-1]) {
				md ++;
				pd = 0;
			}else {
				md = 0;
				pd = 0;
			}
			if(pd == 3) {
				sm = A[i]*sj+sm;
				sj = 0;
				pd = 0;
			}
			if(md == 3) {
				sj = sj + sm/A[i];
				sm = sm%A[i];
				md = 0;
			}
			
		}
		int j = A[14]*jj + jm;
		int s = A[14]*sj + sm;
		if(j>s) {
			System.out.println("BNP");
		}else if(s>j) {
			System.out.println("TIMING");
		}else {
			System.out.println("SAMESAME");
		}
	}

}
