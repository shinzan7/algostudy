package programmers;

import java.util.*;

public class 네트워크 {
    static boolean[] isVisit;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        isVisit = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            if(!isVisit[i]){
                //연결되지 않은 컴퓨터
                q.add(i);
                isVisit[i] = true;
                answer++;
                
                while(!q.isEmpty()){
                    int cur = q.poll();
                    
                    for(int j=0; j<n; j++){
                        if(!isVisit[j] && computers[cur][j] == 1){
                            q.add(j);
                            isVisit[j] = true;
                        }
                        
                    }
                    
                    
                }
                
                
            }
            
        }
        
        return answer;
    }
}
