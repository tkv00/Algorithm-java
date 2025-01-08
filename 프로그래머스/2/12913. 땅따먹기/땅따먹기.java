class Solution {
    int solution(int[][] land) {
        int size=land.length;
        for(int i=1;i<size;i++){
            //1열
            land[i][0]+=Math.max(land[i-1][1],Math.max(land[i-1][2],land[i-1][3]));
            //2열
            land[i][1]+=Math.max(land[i-1][0],Math.max(land[i-1][2],land[i-1][3]));
            //3열
            land[i][2]+=Math.max(land[i-1][1],Math.max(land[i-1][0],land[i-1][3]));
            //4열
            land[i][3]+=Math.max(land[i-1][1],Math.max(land[i-1][2],land[i-1][0]));
        }
        int maxValue=Integer.MIN_VALUE;
        for(int i=0;i<4;i++){
            maxValue=Math.max(maxValue,land[size-1][i]);
        }
        
        return maxValue;
    }
}