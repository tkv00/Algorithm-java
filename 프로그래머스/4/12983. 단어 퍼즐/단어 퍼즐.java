import java.util.*;
class Solution {
    private static final int INF=20_001;
    public int solution(String[] strs, String t) {
        int size=t.length();
        int[] dp=new int[size+1];
        Arrays.fill(dp,INF);
        dp[0]=0;
        HashSet<Integer> sizes=new HashSet<>();
        for(int i=0;i<strs.length;i++){
            sizes.add(strs[i].length());
        }
        
        for(int i=1;i<=size;i++){
            for(int k:sizes){
                if(i-k>=0){
                    String sub=t.substring(i-k,i);
                    if(Arrays.asList(strs).contains(sub)){
                        dp[i]=Math.min(dp[i-k]+1,dp[i]);
                        }
                    }
                }
            }
        return dp[size]<INF ? dp[size] : -1;
        }
        
    }
