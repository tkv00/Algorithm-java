import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int start;
        int end;
        int cost;
        Node(int start,int end,int cost){
            this.cost=cost;
            this.start=start;
            this.end=end;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost,o.cost);
        }
    }
    static void union(int a,int b,int[] arr){
        a=find(a,arr);
        b=find(b,arr);
        if(a<b)arr[b]=a;
        else arr[a]=b;
    }
    static int find(int a,int[] arr){
        if(arr[a]==a)return a;
        return arr[a]=find(arr[a],arr);
    }
    static PriorityQueue<Node> q;
    static int n;
    static int m;
    static StringTokenizer st;

    static int[] unionfind;
    static int res=0;
    static int max=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        q=new PriorityQueue<>();

        unionfind=new int[n+1];
        for(int i=1;i<=n;i++){
            unionfind[i]=i;
        }

        for (int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            q.add(new Node(start,end,cost));

        }

        while (!q.isEmpty()){
            Node node=q.poll();
            //같은 그룹이 아닐때만
            if(find(node.start,unionfind)!=find(node.end,unionfind)){
                //같은 그룹만들기
                union(node.start,node.end,unionfind);
                res+=node.cost;
                max=Math.max(max,node.cost);
            }
        }
        System.out.println(res-max);

    }
}
