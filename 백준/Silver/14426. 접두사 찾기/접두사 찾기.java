import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int N,M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int cnt=0;
    private static Trie trie;
    private static class Node{
        Map<Character,Node> child=new HashMap<>();
    }
    private static class Trie{
        Node root=new Node();

        void insert(String input){
            Node node=root;

            for (int i=0;i<input.length();i++){
                node.child.putIfAbsent(input.charAt(i),new Node());
                node=node.child.get(input.charAt(i));
            }
        }

        boolean search(String input){
            Node cur=this.root;

            for (int i=0;i<input.length();i++){
                cur=cur.child.getOrDefault(input.charAt(i),null);
                if (cur==null) return false;
            }
            return true;
        }
    }
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        trie=new Trie();

        for (int i=0;i<N;i++){
            trie.insert(br.readLine());
        }

    }

    private static void operation() throws IOException {
        for (int i=0;i<M;i++){
            String input=br.readLine();
            if (trie.search(input)) cnt++;
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) throws IOException {
        init();
        operation();
    }
}
