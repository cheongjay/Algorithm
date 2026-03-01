import java.util.*;

class Solution {
    static boolean[] visited;
    static Queue<String> queue = new LinkedList<>();
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        answer = BFS(begin, target, words);
        
        return answer;
    }
    static int BFS(String b, String t, String[] words){
        queue.offer(b);
        int answer = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            // 그 단어의 모든 알파벳 방문 시도(hot라면 h, o, t)
            for(int j = 0; j < size; j++){
                String from = queue.poll();
                
                // BFS는 거리 순으로 탐색하므로(1 -> 2 -> 3...), 타겟을 처음 만났을 때가 최단 거리
                if(from.equals(t)){
                    return answer;
                }
                
                // 알파벳 하나 변경 가능한지 words에서 확인
                for(int i = 0; i < words.length; i++){
                    if(!visited[i] && isOneDifferent(from, words[i])){
                        visited[i] = true;
                        queue.offer(words[i]);
                    }
                }
            }          
            
            answer++;
        }
        return 0;
        
    }
    static boolean isOneDifferent(String from, String to){
        int count = 0;
        for(int i = 0; i < from.length(); i++){
            char c1 = from.charAt(i);
            char c2 = to.charAt(i);
            if(c1 != c2)
                count++;
        }
        
        if(count == 1){
            return true;
        }
        else{
            return false;
        }
    }
}