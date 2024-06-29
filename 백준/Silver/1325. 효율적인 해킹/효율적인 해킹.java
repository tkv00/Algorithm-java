import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N,M;
    public static StringTokenizer st;
    public static ArrayList<Integer> []arrayList;
    public static int[] visit;
    public static int[] res;
    public static Queue <Integer>q=new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        res=new int[N+1];

        arrayList= new ArrayList[N+1];
        for (int i=1;i<=N;i++){
            arrayList[i]=new ArrayList<>();
        }


        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start,end;
            start=Integer.parseInt(st.nextToken());
            end=Integer.parseInt(st.nextToken());
            arrayList[end].add(start);
        }
        //System.out.println(Arrays.toString(arrayList));

        for(int i=1;i<=N;i++){
            visit=new int[N+1];
            bfs(i);

        }
        //System.out.println(Arrays.toString(res));
        ans(res);

    }
    public static void bfs(int v){
        q.add(v);
        visit[v]=1;
        while (!q.isEmpty()){
            int t=q.poll();

            for(int k:arrayList[t]){
                if(visit[k]==0){
                    visit[k]=1;
                    q.add(k);
                    res[v]+=1;
                }
            }
        }
    }
    public static void ans(int[] res){
        int cnt=0;
        for(int i=1;i<=N;i++){
            if(cnt<res[i]){
                cnt=res[i];
            }
        }
        for(int i=1;i<=N;i++){
            if(cnt==res[i]){
                System.out.print(i+" ");
            }
        }
    }

}
