class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        // 신고 결과 과정을 담을 2차원 배열
        // [0][1] : muzi(0) <- frodo(1)
        // [같은 값][같은 값] : 자기 자신이므로 x
        boolean [][] reportToFrom = new boolean[id_list.length][id_list.length];
        
        // 신고 당한 횟수 저장 배열
        int[] reportCount = new int[id_list.length];
        
        for(int i = 0; i < report.length; i++){
            String[] ab = report[i].split(" ");
            int aIndex = getIndexUser(id_list, ab[0]);
            int bIndex = getIndexUser(id_list, ab[1]);
            if(reportToFrom[bIndex][aIndex] == false){
                reportToFrom[bIndex][aIndex] = true;
                reportCount[bIndex]++;           
            }
        }
        int[] emails = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++){
            if(reportCount[i] >= k){
                for(int j = 0; j < id_list.length; j++){
                    if(reportToFrom[i][j] == true){
                        emails[j]++;
                    }
                }              
            }
        }
        return emails;
    }
    
    public int getIndexUser(String[] id_list, String name){
        for(int i =0 ; i < id_list.length ; i++){
            if(name.equals(id_list[i])){
                return i;
            }
        }
        
        return -1;        
    }
}