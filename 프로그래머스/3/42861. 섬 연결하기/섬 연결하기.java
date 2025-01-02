import java.util.Arrays;
class Solution {
    public int find(int[] arr,int a){
        if(a==arr[a]) return arr[a];
        return arr[a]=find(arr,arr[a]);
    }
    
    public void union(int[] arr,int a,int b){
        a=find(arr,a);
        b=find(arr,b);
        if(a<b)arr[b]=a;
        else arr[a]=b;
    }
    
    public int solution(int n, int[][] costs) {
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i;
        }
        int totalCost=0;
        Arrays.sort(costs,(o1,o2)->Integer.compare(o1[2],o2[2]));
        int bridge=0;
        
        for(int[] edge:costs){
            if(bridge==n-1) break;
            if(find(arr,edge[0])!=find(arr,edge[1])){
                union(arr,edge[0],edge[1]);
                totalCost+=edge[2];
                bridge++;
            }
        }
        return totalCost;
    }
}