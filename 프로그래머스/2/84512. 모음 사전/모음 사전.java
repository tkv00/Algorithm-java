import java.util.*;
class Solution {
    private static String[] alpha={"A","E","I","O","U"};
    private static int answer=0;
    private static ArrayList<String> arr;
    
    public int solution(String word) {
        arr=new ArrayList<>();
        
        dfs("");
        Collections.sort(arr);
        return arr.indexOf(word);
    }
    private static void dfs(String str){
        arr.add(str);
        if(str.length()==5) return;
        for(int i=0;i<5;i++){
            dfs(str+alpha[i]);
        }
    }
}