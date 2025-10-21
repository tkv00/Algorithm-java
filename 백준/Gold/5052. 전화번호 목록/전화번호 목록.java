import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static int T,N;
    private static BufferedReader br;
    private static StringBuilder sb;
    private static class Node{
        Map<Character,Node> childNodes=new HashMap<>();
        //단어의 끝 여부
        boolean endOfWord;
    }

    private static class Trie{
        Node root=new Node();

        void insert(String str){
            Node node=this.root;

            for (int i=0;i<str.length();i++){
                node.childNodes.putIfAbsent(str.charAt(i),new Node());
                node=node.childNodes.get(str.charAt(i));
            }

            node.endOfWord=true;
        }

        boolean search(String str){
            Node node=this.root;

            for (int i=0;i<str.length();i++){
                if(node.endOfWord) return false;
                node=node.childNodes.getOrDefault(str.charAt(i),null);

                if (node==null) return false;
            }
            return node.endOfWord;
        }
    }

    public static void main(String[] args) throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        T=Integer.parseInt(br.readLine());

        for (int i=0;i<T;i++){
            N=Integer.parseInt(br.readLine());
            Trie trie=new Trie();
            String[] inputs=new String[N];

            for (int j=0;j<N;j++){
                String input=br.readLine();
                inputs[j]=input;
                trie.insert(input);
            }

            boolean flag=true;
            for (String input:inputs){
                if (!trie.search(input)) flag=false;

            }

            if (flag) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }
}
