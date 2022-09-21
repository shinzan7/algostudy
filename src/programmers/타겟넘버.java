package programmers;

import java.util.Arrays;

public class 타겟넘버 {
    static int answer, t;
    static int[] nums;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        t = target;
        nums = numbers;
        dfs(0, 0);
        
        return answer;
    }
    
    public void dfs(int idx, int num){
        if(idx == nums.length ){
            if(num == t){
                answer++;
            }
            return;
        }
        
        dfs(idx + 1, num + nums[idx]);
        dfs(idx + 1, num - nums[idx]);
        
    }
}
