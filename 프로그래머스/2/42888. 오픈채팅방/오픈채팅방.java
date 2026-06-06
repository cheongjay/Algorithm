import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> lst = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        List<String> instructions = new ArrayList<>();
        List<String> ids = new ArrayList<>();
        
        for(int i = 0; i < record.length; i++){
            String[] r = parse(record[i]);
            String instr = r[0];
            String id = r[1];
            String nick = "";
            
            if(r.length == 3){
                nick = r[2];
            }
            
            instructions.add(instr);
            ids.add(id);
            
            if(instr.equals("Enter")){
                map.put(id, nick);
            }
            else if(instr.equals("Change")){
                map.put(id, nick);
            }
        }
        
        for(int i = 0; i < ids.size(); i++){
            StringBuilder str = new StringBuilder();
            
            str.append(map.get(ids.get(i))).append("님이 ");
            
            if(instructions.get(i).equals("Enter")){
                str.append("들어왔습니다.");
            }
            else if(instructions.get(i).equals("Change")){
                continue;
            }
            else{
                str.append("나갔습니다.");    
            }
            
            lst.add(str.toString());
        }
        
        String[] answer = new String[lst.size()];
        
        for(int i = 0; i < lst.size(); i++){
            answer[i] = lst.get(i);
        }
        
        return answer;
    }
    
    public String[] parse(String str){
        return str.split(" ");
    }
}