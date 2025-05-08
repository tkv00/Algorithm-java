import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static StringTokenizer st;
    private static int[][] map;
    private static int[][] arr;
    private static int max=Integer.MIN_VALUE;
    private static int getSumOfArray(int row1,int col1,int row2,int col2){
        return arr[row2][col2]
                -arr[row1-1][col2]
                -arr[row2][col1-1]
                +arr[row1-1][col1-1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N+1][M+1];
        arr=new int[N+1][M+1];

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                //누적합 구하기
                arr[i][j]=map[i][j]-arr[i-1][j-1]+arr[i-1][j]+arr[i][j-1];
            }
        }


        for(int row1=1;row1<=N;row1++){
            for(int col1=1;col1<=M;col1++){
                for(int row2=row1;row2<=N;row2++){
                    for(int col2=col1;col2<=M;col2++){
                        max=Math.max(getSumOfArray(row1,col1,row2,col2),max);
                    }
                }
            }
        }

        System.out.print(max);

    }
}
