import java.util.*;

class Solution {
    
    String[] userId;
    String[] bannedId;
    Set<Set<String>> result = new HashSet<>(); // 경우의 수 중복 제거를 위한 set
    boolean[] visited; // 사용한 유저인지 아닌지 확인하는 용도
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
            
        userId = user_id;
        bannedId = banned_id;
        
        visited = new boolean[userId.length];
        
        // dfs + 백트랙킹으로 완전 탐색
        dfs(0);
        
        return result.size();
    }
    
    private void dfs(int depth) {
        // 하나의 경우의 수(조합) 완성된 경우, set에 추가하기 
        if(depth == bannedId.length) {
            Set<String> s = new HashSet<>();
            for(int i = 0; i < userId.length; i++) {
                if(visited[i]) {
                    s.add(userId[i]);
                }
            }
            result.add(s);
            return;
        }
        
        // 현재 bannedId[depth] 가 매칭되는 유저 id 찾기 위해 전체 순회
        for(int i = 0; i < userId.length; i++) {
            // 이미 사용한 유저 id 거나, 맞지 않는 경우면 패스
            if(visited[i] || !isMatched(userId[i], bannedId[depth])) {
                continue;
            }
            
            // 사용 가능한 유저라면,
            visited[i] = true; // 1. 방문 처리
            dfs(depth + 1); // 다음 depth로 이동
            visited[i] = false; // 다른 경우의 수를 위해 백트랙킹
        }
    }
    
    private boolean isMatched(String user, String banned) {
        // 길이 확인
        if(user.length() != banned.length()) {
            return false;
        }

        int len = user.length();
        // 문자 하나씩 확인
        for(int i = 0; i < len; i++) {
            char b = banned.charAt(i);
            
            if(b == '*') {
                continue;
            }
            char u = user.charAt(i);
            
            if(u != b) {
                return false;
            }
        }
        return true;
    }
}