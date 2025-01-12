class Solution {
    private static int[] dp1;
    private static int[] dp2;
    
    public int solution(int[] money) {
        dp1=new int[money.length];
        dp2=new int[money.length];
       //첫 번째 집 선택o -> 마지막 집 선택 불가
        dp1[0]=money[0];
        dp1[1]=money[0];
      //첫 번째 집 선택x -> 마지막 집 선택 가능
        dp2[1]=money[1];
        
        for(int i=2;i<money.length-1;i++){
            //직전 집 선택o,직전 집 선택x
            dp1[i]=Math.max(dp1[i-1],dp1[i-2]+money[i]);
        }
        for(int i=2;i<money.length;i++){
            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+money[i]);
        }
        return Math.max(dp1[money.length-2],dp2[money.length-1]);
    }
}