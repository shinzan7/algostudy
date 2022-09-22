package programmers.BFS_DFS;

import java.util.*;

public class 게임맵최단거리 {
	static boolean[][] isVisit;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        isVisit = new boolean[maps.length][maps[0].length];
        
        answer = bfs(maps);
        
        return answer;
    }
    
    public int bfs(int[][] maps){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,1));
        isVisit[0][0] = true;
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            if(cur.r == maps.length - 1 && cur.c == maps[0].length - 1){
                return cur.cnt;
            }
            
            for(int i=0; i<4; i++){
                int nr = cur.r + dx[i];
                int nc = cur.c + dy[i];
                
                if(nr>=0 && nr<maps.length && nc>=0 && nc<maps[0].length 
                   && !isVisit[nr][nc] && maps[nr][nc] == 1){
                    q.add(new Point(nr, nc, cur.cnt + 1));
                    isVisit[nr][nc] = true;
                }
                
            }
            
        }

        return -1;
    }
    
    public class Point{
    int r, c, cnt;
    public Point(int r, int c, int cnt){
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}
}
