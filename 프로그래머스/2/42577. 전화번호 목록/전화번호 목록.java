import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 접두어 - indexOf나 startsWith 사용하여 판단 가능
        
        // 정렬 이유 : 접두어라면 정렬했을 때 바로 뒷 번호만 확인해보면 되기 때문이다.
            // e.g. 12 121 131 .. -> 12와 121만 비교해보면 됨. 12와 131 비교 필요 x
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length - 1; i++){
            int j = i + 1;
            if(phone_book[j].startsWith(phone_book[i]))
                return false;
        }
        
        return answer;
    }
}