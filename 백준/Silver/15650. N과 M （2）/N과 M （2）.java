import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;

    public static int M;

    public static int []arr;
    public static boolean []visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        visit=new boolean[N];
        arr=new int[N+1];
        backTracking(0);
    }

    public static void backTracking(int depth){
       if(depth>0){
           if(arr[depth]<=arr[depth-1]) return;
       }
        if(depth==M){


            for(int value:arr){
                if(value!=0){
                    System.out.print(value+" ");
                }
            }
            System.out.println();
            return;
        }
        for(int i=0;i<N;i++){
            if(!visit[i]){
                visit[i]=true;
                arr[depth+1]=i+1;
                backTracking(depth+1);
                visit[i]=false;
            }
        }
    }
}
