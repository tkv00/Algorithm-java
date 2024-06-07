import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static boolean []visit;
    public static int []arr;
    public static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        visit=new boolean[N];
        arr=new int[N];

        dfs(0);
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int depth) throws IOException {
        if(depth==M){
            for(int i =0;i<M;i++){
                if(arr[i]!=0)
                    bw.write(arr[i] +" ");

            }
            bw.newLine();
            return;
        }
        for(int i=0;i<N;i++){
            arr[depth]=i+1;
            dfs(depth+1);
        }
    }
}
