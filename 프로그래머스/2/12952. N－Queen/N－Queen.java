class Solution {
    private static boolean[][] visited;
    private static int answer=0;
   
    public boolean isSafe(int row,int col,int n){
        //열 검사
        for(int i=row;i>=0;i--){
           if(visited[i][col])return false;
        }
            
        //왼쪽 대각선 검사
        for(int i=1;row-i>=0 && col-i>=0;i++){
            if(visited[row-i][col-i])return false;
        }
        
        //오른쪽 위 대각선
        for(int i=1;row-i>=0 && col+i<n;i++){
            if(visited[row-i][col+i])return false;
        }
        return true;
               
    }
   
    public void backtrack(int row,int n){
        if(row==n){
            answer++;
            return;
        }
        //열에 대해서만 하고 메인에서는 행에 대해서
        for(int i=0;i<n;i++){
            if(isSafe(row,i,n)){
                visited[row][i]=true;
                backtrack(row+1,n);
                visited[row][i]=false;
            }
        }
    }
    public int solution(int n) {
       visited=new boolean[n][n];
        backtrack(0,n);
        return answer;
    }
}