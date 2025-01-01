class Solution {    
    public void union(int[] arr,int a,int b){
        a=find(arr,a);
        b=find(arr,b);
        if(a<b)arr[b]=a;
        else arr[a]=b;
    }
    public int find(int[] arr,int a){
        if(arr[a]==a) return arr[a];
        return arr[a]=find(arr,arr[a]);
    }
    
    public int result(int[][] wires,int n){
        int[] arr=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=i;
        }
        for(int i=0;i<wires.length;i++){
            union(arr,wires[i][0],wires[i][1]);
        }
        
        //서로 다른 송전탑 개수 세기
        int[] groupArr=new int[n+1];
        
        for(int i=1;i<=n;i++){
           int root=find(arr,i);
            groupArr[root]++;
        }
        
        int groupA=0;
        int groupB=0;
        for(int count:groupArr){
            if(count>0){
                if(groupA==0) groupA=count;
                else groupB=count;
            }
        }
        return Math.abs(groupA-groupB);
    }
    //행을 삭제하는 메서드
    public int[][] deleteArr(int[][]arr,int deleteRow){
        int[][] copyArr=new int[arr.length-1][];
        int newRow=0;
        for(int i=0;i<arr.length;i++){
            if(i!=deleteRow){
                copyArr[newRow++]=arr[i];
            }
        }
        return copyArr;
    }
    
    
    public int solution(int n, int[][] wires) {
        int answer=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            int[][]copy=new int[wires.length-1][];
            copy=deleteArr(wires,i);
            answer=Math.min(result(copy,n),answer);
        }
        return answer;
        
    }
}