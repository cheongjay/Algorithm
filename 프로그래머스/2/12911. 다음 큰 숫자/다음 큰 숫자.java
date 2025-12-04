class Solution {
    public int solution(int n) {
        int answer = 0;
        String n2 = Integer.toString(n, 2);
        
        int c = count(n2);
        
        for(int i = n+1; i <= 1000000; i++){
            if(count(Integer.toString(i,2)) == c){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public int count(String n){
        int c = 0;

        for(int i = n.length() - 1; i >= 0; i--){
            if(n.charAt(i) == '1'){
                c++;
            }
        }
        return c;
    }
}