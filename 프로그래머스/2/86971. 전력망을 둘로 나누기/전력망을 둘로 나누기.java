import java.util.*;
class Solution {
    //끊을 네트워크 번호 a,b
    private static int cutting(int a,int b,int n){
        //연결 끊어버리기
        map.get(a).remove(Integer.valueOf(b));
        map.get(b).remove(Integer.valueOf(a));
        
        //탐색 시작 - 네트워크 개수 세기 (1부터만 탐색해도 충분.)
        int cnt=0;
        visited=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
        visited[1]=true;
        q.offer(1);
        cnt++;
        
        while(!q.isEmpty()){
            int now=q.poll();
            
            for(int next:map.get(now)){
                if(!visited[next]){
                    q.offer(next);
                    visited[next]=true;
                    cnt++;
                }
            }
        }
        
        //연결 복구
        map.get(a).add(b);
        map.get(b).add(a);
        
        return Math.abs(n-cnt-cnt);
    }
    
    
    private static Map<Integer,List<Integer>> map;
    private static boolean[] visited;
    private static int MIN=Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        
        map=new HashMap<>();
        for(int[] arr:wires){
            map.putIfAbsent(arr[0],new LinkedList<>());
            map.putIfAbsent(arr[1],new LinkedList<>());
            
            map.get(arr[0]).add(arr[1]);
            map.get(arr[1]).add(arr[0]);
        }
        
        for(int[] arr:wires){
            int cnt=cutting(arr[0],arr[1],n);
            MIN=Math.min(MIN,cnt);
        }
        
        return MIN;
    }
}