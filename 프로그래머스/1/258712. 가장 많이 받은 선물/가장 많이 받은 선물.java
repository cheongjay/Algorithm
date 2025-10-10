import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int[][] table = new int[friends.length][friends.length];
        int[][] jisu = new int[friends.length][3]; //선물지수
        List<String> friendsList = Arrays.asList(friends);
        
        // gifts 순회돌기
        for(int i = 0 ; i < gifts.length; i++){
            // 첫 번째 이름이 friends의 몇 번째 인덱스에 있는지 확인하기
            String [] names = gifts[i].split(" ");
            int give = friendsList.indexOf(names[0]);
            // 두 번째 이름도 몇 번째 인덱스인지 확인하기
            int receive = friendsList.indexOf(names[1]);
            //table[첫 번째 이름 인덱스][두 번째 이름 인덱스] 에 +1 증가시키기
            table[give][receive] += 1;
            
            //jisu[첫 번째 이름 인덱스][0]에 +1 증가시키기
            jisu[give][0] +=1;
            //jisu[두 번째 이름 인덱스][1]에 +1 증가시키기
            jisu[receive][1] +=1;
            
        }
        
        //선물지수 계산하기 : 준 선물 - 받은 선물
        for(int i =0; i< friends.length; i++){
            jisu[i][2] = jisu[i][0] - jisu[i][1];
        }
        
        int[] nextMonth = new int[friends.length];
        
        // table 순회 
        for(int i = 0; i < friends.length; i++){
            for(int j = 0; j < friends.length; j++){
                // 자기 거는 패스
                if(i == j){
                    continue;
                }
                // 자기가 상대에게 준 선물 개수 구하기
                int iGive = table[i][j];
                
                // 상대가 자신에게 준 선물 개수 구하기
                int uGive = table[j][i];
                
                // 2개 비교해서 자기가 더 크면 nextMonth +1
                if(iGive > uGive){
                    nextMonth[i]++;
                }
                // 둘 다 0이거나, 같으면 jisu 확인
                if((uGive == 0 && iGive ==0) || uGive == iGive){
                    int iJisu = jisu[i][2];
                    int uJisu = jisu[j][2];
                    // 지수가 자기가 더 크면 nextMonth +1
                    if(iJisu > uJisu){
                        nextMonth[i]++;
                    }
                }
            }
        
        }
            
        //nextMonth에서 max 찾아 리턴
        int max = 0;
        for(int i : nextMonth){
            if(max < i){
                max = i;
            }
        }
        return max;
    }
    
}

