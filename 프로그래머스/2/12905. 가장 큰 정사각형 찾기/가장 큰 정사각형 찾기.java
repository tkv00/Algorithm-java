class Solution
{
    public int solution(int [][]board)
    {
        int maxValue=0;
        int row=board.length;
        int col=board[0].length;
        
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                //우 하단 기준
                //대각선 위
                int cross=board[i-1][j-1];
                //바로 위
                int up=board[i-1][j];
                //왼쪽
                int left=board[i][j-1];
                if(board[i][j]!=0){
                    board[i][j]=Math.min(cross,Math.min(up,left))+1;
                }
            }
        }
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                maxValue=Math.max(maxValue,board[i][j]);
            }
        }
        return maxValue*maxValue;
    }
}