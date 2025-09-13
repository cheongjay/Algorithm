class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        int len = s.length();
        for(int i = 0; i<len;i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                int num = c - 'A';
                num = (num+n)%26;
                // System.out.println((char)(num+'A'));
                // System.out.println(Character.toString((char)num));
                answer+= Character.toString((char)(num+'A'));
            }
            else if(Character.isLowerCase(c)){
                int num = c - 'a';
                num = (num+n)%26;
                // System.out.println((char)(num+'A'));
                // System.out.println(Character.toString((char)num));
                answer+= Character.toString((char)(num +'a'));
            }
            else{
                answer +=  Character.toString(c);
            }
            // System.out.println((char)( (c+1) % a));
            // answer+= Character.toString((char)((c+1) % a) );
        }
        
        return answer;
    }
}