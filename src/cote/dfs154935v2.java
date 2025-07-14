package cote;

import java.util.*;

public class dfs154935v2 {

    static int N, count;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int size = sc.nextInt(); // 배열 길이
        N = sc.nextInt(); // 목표 합
        arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        count = 0;
        dfs(0, 0, 0);

        // 공집합 제외 처리
        System.out.println(count);
    }

    static void dfs(int sum, int start, int depth) {
        if (sum == N&&depth>=1) {
            count++;

        }

        for (int i = start; i < arr.length; i++) {
            dfs(sum + arr[i], i + 1, depth+1); // 다음 인덱스부터 탐색
        }
    }
}
