import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int N,M,K;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static Set<Integer> generator; //발전기 설치된 도시
    private static int result=0;
    private static int[] arr;
    private static PriorityQueue<int[]> pq;
    private static int findParent(int a){
        if (arr[a]==a) return a;

        return arr[a]=findParent(arr[a]);
    }

    private static void union(int a,int b){
        a=findParent(a);
        b=findParent(b);

        //발전기를 부모로 해야함
        if (generator.contains(a) && generator.contains(b)) return;
        //a가 발전기인 경우
        if (generator.contains(a)){
            arr[b]=a;
        }
        //b가 발전기인 경우
        else if (generator.contains(b)){
            arr[a]=b;
        }

        //나머지 경우는 기존 유니온-파인드와 동일하게
        else {
            if (a>b) arr[a]=b;
            else arr[b]=a;
        }
    }
    //연결된 노드들에 대해서 모두 발전기와 연결되어 있는지 확인
    private static boolean isAllConnected(){
        for (int i=1;i<=N;i++){
            if (!generator.contains(findParent(arr[i])))return false;
        }
        return true;
    }

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        arr=new int[N+1];

        for (int i=1;i<=N;i++){
            arr[i]=i;
        }

        generator=new HashSet<>();

        st=new StringTokenizer(br.readLine());
        for (int i=0;i<K;i++){
            generator.add(Integer.parseInt(st.nextToken()));
        }

        for (int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int node1=Integer.parseInt(st.nextToken());
            int node2=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            pq.offer(new int[]{node1,node2,cost});
        }

    }

    private static void operation(){
        while (!pq.isEmpty()){
            //모든 노드들이 발전기에 연결 -> 종료
            if (isAllConnected()) break;

            int[] nowInfo=pq.poll();

            if (arr[nowInfo[0]]==arr[nowInfo[1]]) continue;

            if (generator.contains(findParent(nowInfo[0])) && generator.contains(findParent(nowInfo[1]))) continue;

            result+=nowInfo[2];

            union(nowInfo[0],nowInfo[1]);
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        operation();

        System.out.println(result);
    }
}
