import java.io.*;
import java.util.*;
public class Main {
    private static int N,M;
    private static int[][] map;
    private static StringTokenizer st;
    private static final int INF=1000000001;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());
        map=new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            Arrays.fill(map[i],INF);
            map[i][i]=0;
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            map[start][end]=Math.min(map[start][end],cost);
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                for(int k=1;k<=N;k++){
                    map[j][k]=Math.min(map[j][k],map[j][i]+map[i][k]);
                }
            }
        }

        StringBuilder sb=new StringBuilder();
               for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(map[i][j]==INF){
                    sb.append(0).append(" ");
                }else{
                    sb.append(map[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
