import java.util.*;

class Solution {
    
    Set<String> set1 = new HashSet<>();
    Set<String> set2 = new HashSet<>();
    
    Map<String, Integer> map1 = new HashMap<>();
    Map<String, Integer> map2 = new HashMap<>();
    
    public int solution(String str1, String str2) {
        
        splitStr(str1, set1, map1);
        splitStr(str2, set2, map2);
        
        int c = cross();
        int s = sum();
        
        if(c == 0 && s == 0)
            return 65536;
        else
            return c * 65536 / s;
    }
    // 교집합
    public int cross(){
        Map<String, Integer> map = new HashMap<>();
        for(String s: set1){
            // 둘 다 있다면 적은 수가 교집합
            if(set2.contains(s)){
                int s1 = map1.get(s);
                int s2 = map2.get(s);
                map.put(s, Math.min(s1, s2));
            }
        }
        
        for(String s:map.keySet()){
            System.out.println(s + " " + map.get(s));
        }
        
        int size = 0;
        for(int v : map.values()){
            size += v;
        }
        return size;
    }
    
    // 합집합
    public int sum(){
        // set 2개 합친 것
        // 만약 중복 요소 있다면 map1과 map2 중 max인 것
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        
        set.addAll(set1);
        set.addAll(set2);
        
        for(String s: set){
            // 중복 요소
            if(set1.contains(s) && set2.contains(s)){
                int s1 = map1.get(s);
                int s2 = map2.get(s);
                map.put(s, Math.max(s1, s2));
            }
            // set1에만 있는 요소
            else if(set1.contains(s)){
                map.put(s, map1.get(s));
            }
            // set2에만 있는 요소
            else{
                map.put(s, map2.get(s));
            }
        }
        // System.out.println(set);
        // for(String s:map.keySet()){
        //     System.out.println(s + " " + map.get(s));
        // }
        
        int size = 0;
        for(int v : map.values()){
            size += v;
        }
        return size;
    }
    public void splitStr(String str, Set<String> set, Map<String, Integer> map){
        int len  = str.length();
        for(int i = 0; i < len - 1; i++){
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(i+1);
            // 모두 알파벳인 경우만 저장
            if(Character.isLetter(ch1) && Character.isLetter(ch2)){
                // 소문자로 만들기
                String element = str.substring(i, i+2).toLowerCase();
                set.add(element);
                map.put(element, map.getOrDefault(element, 0) + 1);
            }
        }
        
        // for(String s:map.keySet()){
        //     System.out.println(s + " " + map.get(s));
        // }
    }
}