import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        
        Integer[][] book = new Integer[book_time.length][2];
        
        for(int i = 0; i < book_time.length; i++) {
            
            String[] start = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":");
                
            book[i][0] = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            book[i][1] = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10; // 청소시간 10분 추가
        }
        
        // 시작 시간 기준 오름차순 정렬
        Arrays.sort(book, (a,b) -> Integer.compare(a[0], b[0]));

        List<Integer> rooms = new ArrayList<>();
        
        for(int i = 0; i < book.length; i++) {
            // 입실 시각 체크
            int start = book[i][0];    
            int end = book[i][1];
            
            boolean assigned = false;
             
            // 기존 방 중 사용 가능한 방 확인
            for(int j = 0; j < rooms.size(); j++) {
                if(rooms.get(j) <= start) {
                    rooms.set(j, end); // 해당 방에 예약 배정
                    assigned = true;
                    break;
                }
            }
            
            // 빈 방이 없으면 새 방 추가
            if (!assigned) {
                rooms.add(end);
            }
        }
        
        return rooms.size();
    }
    
}