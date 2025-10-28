
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[][] colors;
    private static int[][] dp;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        colors=new int[N][3];
        dp=new int[N][3];

        for (int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int red=Integer.parseInt(st.nextToken());
            int green=Integer.parseInt(st.nextToken());
            int blue=Integer.parseInt(st.nextToken());

            colors[i][0]=red;
            colors[i][1]=green;
            colors[i][2]=blue;
        }

        dp[0][0]=colors[0][0];
        dp[0][1]=colors[0][1];
        dp[0][2]=colors[0][2];

        //printMap(colors);
    }

    private static void dynamicProgramming(){
        for (int row=1;row<N;row++){
            for (int col=0;col<3;col++){
                switch (col){
                    case 0:
                        dp[row][0]=Math.min(dp[row-1][1],dp[row-1][2])+colors[row][col];
                        break;
                    case 1:
                        dp[row][1]=Math.min(dp[row-1][0],dp[row-1][2])+colors[row][col];
                        break;
                    case 2:
                        dp[row][2]=Math.min(dp[row-1][0],dp[row-1][1])+colors[row][col];
                        break;
                }
            }
        }

        //printMap(dp);
    }

    private static void printMap(int[][]map){
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[0].length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        dynamicProgramming();

        int min=Integer.MAX_VALUE;
        for (int i=0;i<3;i++){
            min=Math.min(min,dp[N-1][i]);
        }

        System.out.println(min);
    }
}
