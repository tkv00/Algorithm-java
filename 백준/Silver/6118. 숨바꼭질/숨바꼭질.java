import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static StringTokenizer st;
    static int cnt=0;
    static int same=0;
    static boolean[] visited;
    static ArrayList<Integer>[] arrayLists;
    //거리 기록 배열
    static int[]res;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arrayLists=new ArrayList[N+1];
        queue=new LinkedList<>();
        res=new int[N+1];
        for(int i=0;i<=N;i++){
            arrayLists[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            arrayLists[start].add(end);
            arrayLists[end].add(start);
        }
        //1방문
        queue.add(1);

        visited=new boolean[N+1];
        visited[1]=true;


        while (!queue.isEmpty()){
            int k=queue.poll();
            for(int t:arrayLists[k]){
                //방문하지 않은 것만
                //이어져 있으면
                if(!visited[t]){
                    queue.add(t);
                    visited[t]=true;
                    res[t]=res[k]+1;
                }
            }
        }

        //최댓값 찾기
        for(int i=1;i<=N;i++){
            cnt=Math.max(cnt,res[i]);
        }

        //같은 거리 갯수 찾기
        for(int i=1;i<=N;i++){
            if(cnt==res[i]){
                same+=1;
            }
        }


        //헛간 번호
        for(int i=1;i<=N;i++){
            if(cnt==res[i]){
                sb.append(i+" ");
                break;
            }
        }
        sb.append(cnt+" ");
        sb.append(same+" ");


        System.out.println(sb);



    }


}
