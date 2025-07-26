import java.io.*;
import java.util.*;

public class Main {
    private static int[] list;
    private static void union(int a,int b){
        a=parent(a);
        b=parent(b);
        if(a<=b) list[b]=a;
        else list[a]=b;
    }
    private static int parent(int a){
        if(list[a]==a) return list[a];
        return list[a]=parent(list[a]);
    }
    private static int solve(){
        for(int i=1;i<=N;i++){
            //System.out.print(list[i]+" ");
            set.add(parent(i));
        }
        return set.size();
    }
    private static HashSet<Integer> set;
    private static int T;
    private static int N;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<T;i++){
            N=Integer.parseInt(br.readLine());
            st=new StringTokenizer(br.readLine());
            list=new int[N+1];
            for(int j=1;j<=N;j++){
                list[j]=j;
            }
            set=new HashSet<>();

            for(int j=1;j<=N;j++){
                int num=Integer.parseInt(st.nextToken());
                union(j ,num);
            }
            sb.append(solve()).append("\n");
            
        }
        System.out.print(sb);
    }
}
