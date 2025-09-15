import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int getParent(int a){
        if(arr[a]==a) return a;
        return arr[a]=getParent(arr[a]);
    }

    private static void union(int a,int b){
        a=getParent(a);
        b=getParent(b);

        if(a>b) arr[a]=b;
        else arr[b]=a;
    }
    private static int[] arr;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int N,M;
    private static int isCycle;
    private static Set<Integer> set;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i]=i;
        }

        isCycle=0;
        set=new HashSet<>();
    }

    public static void main(String[] args) throws IOException {
        init();
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            //사이클 판단

            if(getParent(u)==getParent(v)){
                isCycle++;
                continue;
            }
            union(u,v);
        }

        for(int i=1;i<arr.length;i++){
            set.add(getParent(arr[i]));
        }

        System.out.print(set.size()-1+isCycle);
    }
}
