package cote;

import java.util.*;

public class grid1493 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력 받기: 박스 크기
		int L = sc.nextInt();
		int W = sc.nextInt();
		int H = sc.nextInt();

		// 큐브 종류 수
		int N = sc.nextInt();

		// 큐브 개수를 지수별로 저장 (2^0 ~ 2^19)
		int[] cubes = new int[20];
		for (int i = 0; i < N; i++) {
			int power = sc.nextInt();  // 큐브의 지수
			int count = sc.nextInt();  // 큐브 개수
			cubes[power] = count;
		}

		long filled = 0;   // 지금까지 채운 부피
		long answer = 0;   // 사용한 큐브 개수
		
		long totalSize = W*H*L;

		for (int i = cubes.length-1; i >= 0; i--) {
			int size = 1 << i; // 큐브 한 변의 길이 (2^i)

			//전체 박스크기에 넣을 수 있는 수
			long possibleCount = (long)(L / size) * (W / size) * (H / size);

			//채워진거를 지금 큐브 크기로 나눠 갯수르 하고 채울 수 있는 수르 구함
			//전체 갯수 - 이미 채워진 갯수
			long filledCount = filled / ((long)size * size * size);
			possibleCount -= filledCount;
			
			// 실제로 사용할 큐브 수는 우리가 가진 수와 가능한 수 중 작은 것
			long use = Math.min(possibleCount, cubes[i]);

			// 사용한 큐브만큼 부피 채우기
			filled += use * (long)size * size * size;
			answer += use;
		}

		// 박스 전체 부피와 채운 부피가 같아야 성공
		long totalVolume = (long)L * W * H;
		if (filled == totalVolume) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}
	}
}
