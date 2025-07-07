package cote;

import java.io.*;
import java.util.*;

public class impl15685 {

    static int n;
    static final boolean[][] map = new boolean[101][101];
    static List<Integer> list;
    static int[][] directions = {
    		{1,0}, //오 1
    		{0,-1},//위 2
    		{-1,0},//왼 3
    		{0,1} //아래 4
    };
    static int num = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()); //방향
            int g = Integer.parseInt(st.nextToken()); //세대

            list = new ArrayList<>();
            
            direct(d,g);
            check(x,y);
            
        }
        int result = count();
        System.out.println(result);
    }
    static void direct(int d, int g) {
    	list.add(d); //0세대 방향 넣기
    	
    	for(int i=0; i<g; i++) { //세대수만큼 반복해서 넣기(x2가 됨)
    		for(int j=list.size()-1; j>=0; j--){ //역순으로 1증가해서 추가해야함
    			int nd = (list.get(j)+1)%4; //넣을 새로운 방향
    			list.add(nd);
    		}
    	}//리스트에 세대수만큼 방향을 넣음, 다음에 점에 방문 처리해야함
    	
    }


    
    static void check(int x, int y) {
    	map[y][x] = true;
    	for(int l:list) {
    		x = x+directions[l][0];
    		y = y+directions[l][1];
    		
    		map[y][x] = true;
    	}
    }
    
    static int count() {
    	for(int i=0; i<100; i++) {
    		for(int j=0; j<100; j++) {
	    		if(map[i][j]&&map[i+1][j+1]&&map[i][j+1]&&map[i+1][j]) {
	    			num++;
	    		}
    		}
    	}
    	return num;
    }

}
