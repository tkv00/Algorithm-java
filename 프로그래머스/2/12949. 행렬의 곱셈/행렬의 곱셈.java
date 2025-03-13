class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        //1번쨰 행 크기
        int row1Size=arr1.length;
        //1번째 열 크기
        int col1Size=arr1[0].length;
        
        //2번째 행 크기
        int row2Size=arr2.length;
        //2번쨰 열 크기
        int col2Size=arr2[0].length;
        
        int[][] result=new int[row1Size][col2Size];
        
        for(int i=0;i<row1Size;i++){
            for(int j=0;j<col2Size;j++){
                for(int k=0;k<row2Size;k++){
                    result[i][j]+=arr1[i][k]*arr2[k][j];
                }
            }
        }
        return result;
    }
}