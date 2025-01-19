class Solution {
    public int solution(int n, int[][] results) {
        int[][]map=new int[n+1][n+1];
        int answer=0;
        
        for(int i=0;i<results.length;i++){
            //이긴 거 표시
            map[results[i][0]][results[i][1]]=1;
        }
        //경유지
        for(int i=1;i<=n;i++){
            //출발지
            for(int j=1;j<=n;j++){
                //도착지
                for(int z=1;z<=n;z++){
                    if(map[j][i] == 1 && map[i][z]==1){
                        map[j][z]=1;
                    }
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            int cnt=0;
            for(int j=1;j<=n;j++){
                if(map[i][j] == 1 || map[j][i]==1){
                    cnt++;
                }
            }
            if(cnt==n-1){
                answer++;
            }
        }
        return answer;
    }
}