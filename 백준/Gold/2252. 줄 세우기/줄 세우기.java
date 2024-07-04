import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static StringTokenizer st;
    public static ArrayList<Integer>[] arr;
    public static int[] indegree;
    public static Stack<Integer> stack;
    public static int []res;
    public static int index=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1];
        res=new int[N];
        for(int i=0;i<=N;i++){
            arr[i]=new ArrayList<>();
        }
        indegree=new int[N+1];
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[a].add(b);
            indegree[b]++;
        }
       // System.out.println(Arrays.toString(arr));
        //System.out.println("indegree"+Arrays.toString(indegree));
        stack=new Stack<>();
        for(int i=1;i<=N;i++){
            if(indegree[i]==0){
                stack.push(i);
            }
           // System.out.println("stack"+stack);
        }
        bfs();
        for(int i=0;i<N;i++){
            System.out.print(res[i]+" ");
        }

    }
    public static void bfs(){
        while (!stack.isEmpty()){
            int v=stack.pop();
           // System.out.println(v);
            res[index++]=v;
            for(int a:arr[v]){
                indegree[a]--;
               // System.out.println("indegree[a]"+ Arrays.toString(indegree));
                if(indegree[a]==0){
                    stack.push(a);
                }
            }
        }
    }

}
