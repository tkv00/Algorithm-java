import java.util.*;
class Solution {
    private static int ticketsCnt;
    private static ArrayList<String> answer=new ArrayList<>();
    private static boolean[] visit;
    
    public String[] solution(String[][] tickets) {
        
        ticketsCnt=tickets.length;
        visit=new boolean[ticketsCnt];
        
        dfs(0,"ICN","ICN",tickets);
        
        Collections.sort(answer);
        String[] str={};
        
        str=answer.get(0).split(" ");
        return str;
        
    }
    private void dfs(int dep,String start,String route,String[][] tickets){
        if(dep==ticketsCnt){
            answer.add(route);
            return;
        }
        
        for(int i=0;i<ticketsCnt;i++){
            if(tickets[i][0].equals(start) && !visit[i]){
                visit[i]=true;
                dfs(dep+1,tickets[i][1],route+" "+tickets[i][1],tickets);
                visit[i]=false;
            }
        }
    }
}