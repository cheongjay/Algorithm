class Solution {
    static int answer = 0;
    static int cnt = 0;
    String[] vowels = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {

        boolean[] v = new boolean[word.length()];
        dfs("", word);
        
        return answer;
    }
    
    boolean dfs(String cur, String word){
    
        // 찾으면 answer 기록 후 true 리턴
        // 안 해주면 답 찾은 후에도 dfs 계속 탐색해서 성능 저하 
        if(cur.equals(word) ){
            answer = cnt;
            return true;
        }
        
        // 길이 5까지만
        if(cur.length() == 5)
            return false;
        
        for(int i = 0; i < 5; i++){
            cnt++;
            // 만약 찾았다면 탐색 중단 위해 true 리턴
            if(dfs(cur + vowels[i], word))
                return true;
        }
        
        return false;    
    }
}