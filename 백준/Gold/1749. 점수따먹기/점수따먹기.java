import java.io.*;
import java.util.*;
public class Main {
    private static int max=Integer.MIN_VALUE;
    private static int N,M;
    private static StringTokenizer st;
    private static int[][] map;
    private static int[][] sum;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        sum=new int[N+1][M+1];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        sum[1][1]=map[0][0];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                sum[i][j]=map[i-1][j-1]+sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
            }
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                for(int row=i;row<=N;row++){
                    for(int col=j;col<=M;col++){
                        max=Math.max(sum[row][col]-sum[row][j-1]-sum[i-1][col]+sum[i-1][j-1],max);
                    }
                }
            }
        }
        System.out.print(max);
    }
}
