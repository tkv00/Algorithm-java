class Solution {
    private static int result=0;
    
    private static void operation(String[] words,String now,String end,int cnt,boolean[] visited){
        if(now.equals(end)){
            result=cnt;
            return;
        }
        
        for(int idx=0;idx<words.length;idx++){
            if(visited[idx]) continue;
            if(!canConvert(now,words[idx])) continue;
            
            visited[idx]=true;
            operation(words,words[idx],end,cnt+1,visited);
            visited[idx]=false;
        }
    }
    
    private static boolean canConvert(String start,String end){
        int len=start.length();
        
        char[] startArr=start.toCharArray();
        char[] endArr=end.toCharArray();
        
        int cnt=0;
        
        for(int i=0;i<len;i++){
            if(startArr[i]==endArr[i]) cnt++;
        }
        
        return cnt == len -1 ;
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited=new boolean[words.length];
        operation(words,begin,target,0,visited);
        
        return result;
    }
}