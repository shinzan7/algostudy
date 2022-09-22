package programmers.BFS_DFS;

import java.util.*;
class 단어변환 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean isArrive = false;
        boolean[] isVisit = new boolean[words.length];

        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));

        while(!q.isEmpty()){
            Word cur = q.poll();
            if(target.equals(cur.word)){
                isArrive = true;
                answer = cur.cnt;
                break;
            }

            for(int i=0; i<words.length; i++){
                if(!isVisit[i] && dismatchCount(cur.word, words[i]) == 1){
                    q.add(new Word(words[i], cur.cnt + 1));
                    isVisit[i] = true;
                }

            } 
        }

        return answer;
    }

    public static int dismatchCount(String a, String b){
        int cnt = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                cnt++;
                if(cnt > 1){
                    return -1;
                }
            }
        }

        return cnt;
    }


    static class Word{
        String word;
        int cnt;
        Word(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
}