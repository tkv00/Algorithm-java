import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static int N,M;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=2;i<=M;i++){
            map[1][i]=map[1][i]+map[1][i-1];
        }

        for(int i=2;i<=N;i++){
            map[i][1]=map[i][1]+map[i-1][1];
        }

        for(int i=2;i<=N;i++){
            for(int j=2;j<=M;j++){
                map[i][j]+=Math.max(map[i-1][j-1],Math.max(map[i-1][j],map[i][j-1]));
            }
        }

        System.out.print(map[N][M]);
    }
}
