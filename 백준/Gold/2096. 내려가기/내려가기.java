import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][]MaxDp;
    public static int[][]MinDp;
    public static int[][]map;
    public static StringTokenizer st;
    public static int max=0;
    public static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N+1][3];
        MaxDp=new int[N+1][3];
        MinDp=new int[N+1][3];
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }


        for(int i=1;i<=N;i++){
            //열기준 0번 인덱스
            MaxDp[i][0]=Math.max(MaxDp[i-1][0],MaxDp[i-1][1])+map[i][0];
            //열기준 1번 인덱스
            MaxDp[i][1]=Math.max(Math.max(MaxDp[i-1][0],MaxDp[i-1][1]),MaxDp[i-1][2])+map[i][1];
            //열기준 2번 인덱스
            MaxDp[i][2]=Math.max(MaxDp[i-1][1],MaxDp[i-1][2])+map[i][2];

            //열기준 0번 인덱스
            MinDp[i][0]=Math.min(MinDp[i-1][0],MinDp[i-1][1])+map[i][0];
            //열기준 1번 인덱스
            MinDp[i][1]=Math.min(Math.min(MinDp[i-1][0],MinDp[i-1][1]),MinDp[i-1][2])+map[i][1];
            //열기준 2번 인덱스
            MinDp[i][2]=Math.min(MinDp[i-1][1],MinDp[i-1][2])+map[i][2];
        }
        for(int i=0;i<3;i++){
            max=Math.max(max,MaxDp[N][i]);
            min=Math.min(min,MinDp[N][i]);
        }
        System.out.println(max+" "+min);


    }
}
