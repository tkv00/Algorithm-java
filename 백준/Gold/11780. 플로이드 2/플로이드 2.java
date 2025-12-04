import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n,m;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static final int MAX_VALUE=10_000_001;
    private static int[][] map;
    private static StringBuilder sb;
    private static List<Integer>[][] rootMap;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());
        rootMap=new List[n+1][n+1];
        sb=new StringBuilder();

        map=new int[n+1][n+1];

        for (int i=0;i<=n;i++){
            for (int j=0;j<=n;j++){
                rootMap[i][j]=new ArrayList<>();
            }
        }

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
                    if (i==j) {
                        rootMap[i][j].add(0);
                        continue;
                    };

                    if (map[i][j]>map[i][k]+map[k][j]){
                        trackingRoot(i,k,j);
                        map[i][j]=map[i][k]+map[k][j];
                    }
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

        //경로 출력
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if (i==j || map[i][j]==MAX_VALUE){
                    sb.append("0").append("\n");
                    continue;
                }

                if (rootMap[i][j].isEmpty()){
                    sb
                            .append(2)
                            .append(" ")
                            .append(i)
                            .append(" ")
                            .append(j)
                            .append("\n");
                    continue;
                }

                sb
                        .append(rootMap[i][j].size()+2)
                        .append(" ")
                        .append(i)
                        .append(" ");

                for (int x:rootMap[i][j])
                    sb.append(x).append(" ");

                sb.append(j).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void trackingRoot(int i,int k,int j){
        rootMap[i][j].clear();

        for (int next:rootMap[i][k]){
            rootMap[i][j].add(next);
        }

        rootMap[i][j].add(k);

        for (int next:rootMap[k][j]){
            rootMap[i][j].add(next);
        }
    }
    private static void print(){
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                System.out.print(i+"->"+j+" : ");
                System.out.println(rootMap[i][j]);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        operation();
        printMap();
    }
}
