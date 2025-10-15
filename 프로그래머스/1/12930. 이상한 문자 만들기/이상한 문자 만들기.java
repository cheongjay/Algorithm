class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int j = 0;
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            
            if(j % 2 == 0){
                answer.append(Character.toUpperCase(c));
            }else{
                answer.append(Character.toLowerCase(c));
            }
            
            if(c == ' '){
                j=0;
            }
            else{
               j++;
            }
        }
        return answer.toString();
    }
}