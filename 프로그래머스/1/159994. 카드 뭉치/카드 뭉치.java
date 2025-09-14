class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int len1 = cards1.length;
        int len2 = cards2.length;
        int goallen = goal.length;
        
        int index1 = 0;
        int index2 = 0;
        int i = 0;
        
        for(; i < goallen; i++){
            if(index1 < len1 && goal[i].equals(cards1[index1])){
                index1++;
            }
            else if(index2 < len2 && goal[i].equals(cards2[index2])){
                index2++;
            }
            else{
                return "No";
            }
        }
        return "Yes";
    }
}