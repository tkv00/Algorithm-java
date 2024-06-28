import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    public static int N;
    public static int M;
    public static StringTokenizer st;
    public static int []res;
    public static int []visit;
    public static int resNum=0;

    public static ArrayList<ArrayList<Integer>> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        arr=new ArrayList<>();

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            arr.add(new ArrayList<>());
        }
       
        res=new int[N];

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int num1=Integer.parseInt(st.nextToken());
            int num2=Integer.parseInt(st.nextToken());
            res[num1]=1;res[num2]=1;
            arr.get(num1).add(num2);
            arr.get(num2).add(num1);
        }
        for(int i=0;i<N;i++){
            if(res[i]==1) resNum++;
        }
        if(resNum<=4){
            System.out.println(0);
            exit(0);
        }
        for(int i=0;i<N;i++){

             visit=new int[N];
            dfs(1,i);
        }


        System.out.println(0);


    }
    public static void dfs(int depth,int v){
        visit[v]=1;
        if(depth==5){
            System.out.println(1);
            exit(0);
        }
        for(int i=0;i<arr.get(v).size();i++){
            int k= arr.get(v).get(i);
            if(visit[k]==0){

                visit[k]=1;
                //System.out.println(Arrays.toString(visit));
                //System.out.println("k값:"+k);
                dfs(depth+1,k);
                //System.out.println(Arrays.toString(new String[]{"dfs후" + visit}));
               visit[k]=0;
            }
        }
    }
}
