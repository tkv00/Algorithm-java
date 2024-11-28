class Solution {
    private boolean[] visited;
    private int answer = 0;
   
    public int solution(int k, int[][] dungeons) {
        visited=new boolean[dungeons.length];
        for(int i=0;i<dungeons.length;i++){
            backtrack(dungeons,k,0);
        }
        return answer;
    }
    
    public void backtrack(int[][] dungeons,int now,int depth){
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && now>=dungeons[i][0]){
                visited[i]=true;
                backtrack(dungeons,now-dungeons[i][1],depth+1);
                visited[i]=false;
            }
        }
        answer=Math.max(answer,depth);
    }
}