
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n,m;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static final int MAX_VALUE=10_000_001;
    private static int[][] map;
    private static StringBuilder sb;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());
        sb=new StringBuilder();

        map=new int[n+1][n+1];

        for (int i=1;i<=n;i++){
            Arrays.fill(map[i],MAX_VALUE);
            map[i][i]=0;
        }

        for (int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int city_1=Integer.parseInt(st.nextToken());
            int city_2=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            map[city_1][city_2]=Math.min(cost,map[city_1][city_2]);
        }
    }

    private static void operation(){
        for (int k=1;k<=n;k++){
            for (int i=1;i<=n;i++){
                for (int j=1;j<=n;j++){
                    if (i==j) continue;
                    map[i][j]=Math.min(map[i][k]+map[k][j],map[i][j]);
                }
            }
        }
    }

    private static void printMap(){
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if (map[i][j]==MAX_VALUE){
                    sb.append(0).append(" ");
                    continue;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        init();
        operation();
        printMap();
    }
}
