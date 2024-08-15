import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int find(int x,int[] arr){
        if(arr[x]==x)return x;
        return arr[x]=find(arr[x],arr);
    }
    public static void union(int x,int y,int[] arr){
        x=find(x,arr);
        y=find(y,arr);
        if(x<y){
            arr[y]=x;
        }else{
            arr[x]=y;
        }
    }
    //같은 부모인지 판단
    public static int isSameParent(int a,int b,int[]arr){
        a=find(a,arr);
        b=find(b,arr);
        if(a==b)return 1;
        else return -1;
    }
    static class Node  {
        int start;
        int end;
        int cost;
        Node(int start,int end,int cost){
            this.start=start;
            this.end=end;
            this.cost=cost;
        }

    }
    static PriorityQueue<Node> queue;
    static int V;
    static int E;
    static StringTokenizer st;
    static int[] unionFind;
    static int res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        unionFind=new int[V+1];
        //유니온 파인드 초기화
        for(int i=1;i<=V;i++){
            unionFind[i]=i;
        }

        queue=new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
               return o1.cost-o2.cost;
            }
        });
        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            queue.add(new Node(start,end,cost));
        }

        while (!queue.isEmpty()){
            Node node=queue.poll();
            int start=node.start;
            int end=node.end;
            int cost=node.cost;

            //부모가 다르면 union
            if(find(start,unionFind)!=find(end,unionFind)){
                union(start,end,unionFind);
                res+=cost;
            }
        }
        System.out.println(res);

    }
}
