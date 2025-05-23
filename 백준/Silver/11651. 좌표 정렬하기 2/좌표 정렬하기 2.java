import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    private static class Node{
        Integer x;
        Integer y;
        Node(Integer x,Integer y){
            this.x=x;
            this.y=y;
        }
    }
    private static int N;
    private static StringTokenizer st;
    private static Node[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        nodes=new Node[N];
        for (int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            nodes[i]=new Node(x,y);
        }
        StringBuilder sb=new StringBuilder();
        Arrays.sort(nodes,(o1,o2)->{
            if (o1.y.equals(o2.y)){
                return o1.x.compareTo(o2.x);
            }
            return o1.y.compareTo(o2.y);
        });

        for (Node node:nodes){
            sb.append(node.x).append(" ").append(node.y).append("\n");
        }

        System.out.println(sb);
    }
}
