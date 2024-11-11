import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] calc;
    static int max=-1000000000;
    static int min=1000000000;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        arr=new int[N];
        calc=new int[4];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            calc[i]=Integer.parseInt(st.nextToken());
        }
        dfs(1,arr[0]);
        System.out.println(max);
        System.out.println(min);


    }
    static void dfs(int depth,int res){
        //종료하는 경우
        if(depth==N){
            max=Math.max(res,max);
            min=Math.min(res,min);
            return;
        }
        //+인 경우
        if(calc[0]!=0){
            calc[0]--;
            dfs(depth+1,res+arr[depth] );
            calc[0]++;
        }
        //-인 경우
        if(calc[1]!=0){
            calc[1]--;
            dfs(depth+1,res-arr[depth]);
            calc[1]++;
        }
        //*인 경우
        if(calc[2]!=0){
            calc[2]--;
            dfs(depth+1,res*arr[depth]);
            calc[2]++;
        }
        // / 인 경우
        if(calc[3]!=0){
            calc[3]--;
            dfs(depth+1, (int) res/arr[depth]);
            calc[3]++;
        }
    }
}
