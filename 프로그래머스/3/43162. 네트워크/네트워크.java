import java.util.*;

 class Solution {
    private static int[] arr;
    private static Set<Integer> set;
     private static void union(int a,int b){
         a=findParent(a);
         b=findParent(b);
         
         if(a<b) arr[b]=a;
         else arr[a]=b;
     }
     
     private static int findParent(int a){
         if(a==arr[a]) return a;
         else return a=findParent(arr[a]);
     }
     
    public int solution(int n, int[][] computers) {
        int size=computers.length;
        arr=new int[size];
        set=new HashSet<>();
        
        for(int i=0;i<size;i++){
            arr[i]=i;
        }
        
        for(int row=0;row<size;row++){
            for(int col=row+1;col<size;col++){
                if(computers[row][col]==1){
                    union(row,col);
                }
            }
        }
        int cnt=1;
        for(int i=0;i<size;i++){
            set.add(findParent(i));
        }
        
        return set.size();
    }
}