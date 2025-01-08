class Solution {
    public int solution(int[][] triangle) {
        int size=triangle.length;
        int maxValue=Integer.MIN_VALUE;
        
        for(int i=1;i<size;i++){
            triangle[i][0]+=triangle[i-1][0];
            triangle[i][triangle[i].length-1]+=triangle[i-1][triangle[i-1].length-1];
            //중간 값
            for(int j=1;j<triangle[i].length-1;j++){
                triangle[i][j]+=Math.max(triangle[i-1][j],triangle[i-1][j-1]);
            }
        }
        for(int i=0;i<triangle[size-1].length;i++){
            maxValue=Math.max(maxValue,triangle[size-1][i]);
        }
        return maxValue;
        
    }
}