class Solution {
    public int[] solution(int brown, int yellow) {
        int []result=new int[2];
        //전체 크기
        int total=brown+yellow;
        
        for(int i=3;i<=total;i++){
            int col=i;//세로
            int row=total/col;//가로
            
            if(row<3)continue;
            if(row>=col){
                if((row-2)*(col-2)==yellow){
                    result[0]=row;
                    result[1]=col;
                    break;
                }
            }
        }
        
        
        return result;
    }
}