package cote.exam1;

import java.io.*;
import java.util.*;

public class impl14891 {

    static List<Deque<Integer>> gears = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 톱니바퀴 입력
        for (int i = 0; i < 4; i++) {
            char[] line = br.readLine().toCharArray();
            Deque<Integer> gear = new LinkedList<>();
            for (char c : line) {
                gear.add(c - '0');
            }
            gears.add(gear);
        }

        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            int[] rotateDirs = new int[4]; // 0: 회전 안 함, 1: 시계, -1: 반시계
            rotateDirs[gearNum] = dir;

            // 왼쪽 톱니들 확인
            for (int i = gearNum; i > 0; i--) {
                if (gears.get(i).toArray()[6].equals(gears.get(i - 1).toArray()[2])) break;
                rotateDirs[i - 1] = -rotateDirs[i];
            }

            // 오른쪽 톱니들 확인
            for (int i = gearNum; i < 3; i++) {
                if (gears.get(i).toArray()[2].equals(gears.get(i + 1).toArray()[6])) break;
                rotateDirs[i + 1] = -rotateDirs[i];
            }

            // 회전 적용
            for (int i = 0; i < 4; i++) {
                if (rotateDirs[i] == 1) rotateClockwise(i);
                else if (rotateDirs[i] == -1) rotateCounterClockwise(i);
            }
        }

        // 점수 계산
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears.get(i).peekFirst() == 1) {
                score += (1 << i);
            }
        }
        System.out.println(score);
    }

    static void rotateClockwise(int idx) {
        Deque<Integer> gear = gears.get(idx);
        gear.addFirst(gear.pollLast());
    }

    static void rotateCounterClockwise(int idx) {
        Deque<Integer> gear = gears.get(idx);
        gear.addLast(gear.pollFirst());
    }
}
