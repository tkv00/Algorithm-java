import java.util.*;

class Solution {
    private static int[] arr;
    private static Set<Integer> set;
    private static int getParent(int a){
        if(arr[a]==a) return a;
        return arr[a]=getParent(arr[a]);
    }
    private static void union(int a,int b){
        a=getParent(a);
        b=getParent(b);
        if(a>b) arr[a]=b;
        else arr[b]=a;
    }
    private static int max;
    public int solution(int[] nums) {
        arr=new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            arr[i]=i;
        }
        
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]) union(arr[i],arr[j]);    
            }
        }
        set=new HashSet<>();
        for(int x:arr){
            set.add(x);
        }

        
        return Math.min(nums.length/2 , set.size());
    }
}