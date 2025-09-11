import java.util.*;
class Solution {
    private static int[] arr;
    private static void union(int a,int b){
        a=getParent(a);
        b=getParent(b);
        if(a>b) arr[a]=b;
        else arr[b]=a;
    }
    private static int getParent(int a){
        if(arr[a]==a) return a;
        return getParent(arr[a]);
    }

    private static boolean isSameParent(int a,int b){
        a=getParent(a);
        b=getParent(b);
        return a==b;
    }
    public int solution(int n, int[][] costs) {
        arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i;
        }
        Arrays.sort(costs,(a,b)->a[2]-b[2]);
        int answer=0;
        
        for(int [] cost:costs){
            if(!isSameParent(cost[0],cost[1])){
                answer+=cost[2];
                union(cost[0],cost[1]);
            }
        }
        
        return answer;
    }
}