import java.io.*;
import java.util.*;
public class Main {
    private static int n,m;
    private static int[][] costMap;
    private static int[][] rootMap;
    private static StringTokenizer st;
    private static final int INF=40000001;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        costMap=new int[n+1][n+1];
        rootMap=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(costMap[i],INF);
            costMap[i][i]=0;
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            costMap[start][end]=Math.min(costMap[start][end],cost);
            costMap[end][start]=Math.min(costMap[end][start],cost);
            rootMap[start][end]=end;
            rootMap[end][start]=start;
        }

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(costMap[i][j]>costMap[i][k]+costMap[k][j]){
                        costMap[i][j]=costMap[i][k]+costMap[k][j];
                        rootMap[i][j]=rootMap[i][k];
                    }
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) sb.append("-").append(" ");
                else{
                    sb.append(rootMap[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}
