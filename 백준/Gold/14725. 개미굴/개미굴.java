import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int N;
    private static StringBuilder sb;
    private static Trie trie;
    private static class Node{
        TreeMap<String,Node> child=new TreeMap<>((a,b)->a.compareTo(b));
    }

    private static class Trie{
        Node root=new Node();

        void insert(String str){
            Node node=this.root;

            String[] strings=str.split(" ");
            int num=Integer.parseInt(strings[0]);

            for (int i=1;i<=num;i++){
                node.child.putIfAbsent(strings[i],new Node());
                node=node.child.get(strings[i]);
            }
        }

        void search(int depth,Node node){
            TreeMap<String,Node> children=node.child;
            if (children==null) return;

            Set<Character> set=new HashSet<>();
            for (String next:children.keySet()){


                for (int i=0;i<depth;i++){
                    sb.append("--");
                }
                sb.append(next).append("\n");

                search(depth+1,node.child.get(next));
            }
        }
    }

    private static void init() throws IOException {
        sb=new StringBuilder();
        br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        trie=new Trie();

        for (int i=0;i<N;i++){
            String input=br.readLine();
            trie.insert(input);
        }

    }
    private static void operation(){
        trie.search(0,trie.root);
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        init();
        operation();
    }
}
