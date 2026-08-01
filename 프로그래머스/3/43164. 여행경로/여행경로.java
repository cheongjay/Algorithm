import java.util.*;

class Solution {
    ArrayList<String> allRoute = new ArrayList<>();
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length]; // 티켓 사용 여부
        int cnt = 0;
        
        dfs("ICN", "ICN", tickets, cnt);
        
        Collections.sort(allRoute); // 알파벳 순으로 방문되도록
        answer = allRoute.get(0).split(" ");
        
        return answer;        
    }
    
    public void dfs(String start, String route, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            allRoute.add(route);
            return;
        }
        
        for (int i = 0; i<tickets.length; i++) {           
            // 출발지가 동일하고, 그 티켓을 사용하지 않았다면
            if (start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
    }
}