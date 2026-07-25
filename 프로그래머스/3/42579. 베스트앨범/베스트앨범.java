import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 장르별 합
        HashMap<String, Integer> sumByGenres = new HashMap<>();
        
        // 장르별, 고유 번호와 재생횟수
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            if(!sumByGenres.containsKey(genre)){
                HashMap<Integer, Integer> map = new HashMap<>();
                
                map.put(i, play); // 고유번호, 재생횟수
                music.put(genre, map); // 해당 장르에 수록
                
                sumByGenres.put(genre, play); // 장르별 횟수
            } else {
                music.get(genre).put(i, play); // 해당 장르에 수록
                sumByGenres.put(genre, sumByGenres.get(genre) + play); // 장르별 횟수 합산
            }
        }
        
        List<String> keySet = new ArrayList(sumByGenres.keySet());
        Collections.sort(keySet, (s1, s2) -> sumByGenres.get(s2) - (sumByGenres.get(s1)));
        
        for(String key : keySet){            	
            HashMap<Integer, Integer> map = music.get(key);
            List<Integer> genreKey = new ArrayList(map.keySet());
 
            // 해당 장르 안에서 재생 횟수 기준 내림차순 정렬
            Collections.sort(genreKey, (s1, s2) -> map.get(s2) - (map.get(s1)));
 
            // 가장 많이 튼 곡
            answer.add(genreKey.get(0));
            
            // 두 번째로 많이 튼 곡 있다면 수록
            if(genreKey.size() > 1)
                answer.add(genreKey.get(1));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}