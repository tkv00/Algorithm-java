import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static ArrayList<Integer> [] arrayLists;
    public static boolean []visited;
    public static int []res;
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        n= Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());

        arrayLists=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            arrayLists[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            arrayLists[a].add(b);
            arrayLists[b].add(a);

        }
        visited=new boolean[n+1];
        res=new int[n+1];
        bfs(0,1);
       // System.out.println(Arrays.toString(res));
        int cnt=0;
        for(int i=2;i<=n;i++){
            if(res[i]<3 && res[i]!=0){
                cnt++;
            }
        }
        System.out.println(cnt);

    }
    public static void bfs(int depth,int start){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        visited[start]=true;
        while (!queue.isEmpty()){
            int z=queue.poll();
            //visited[z]=true;
            for(int k:arrayLists[z]){
                if(!visited[k]){
                    visited[k]=true;
                    queue.add(k);
                    res[k]=res[z]+1;
                }
            }
        }
    }
}
