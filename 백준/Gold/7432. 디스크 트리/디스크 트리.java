import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    private static int N;
    private static BufferedReader br;
    private static StringBuilder sb;
    private static class Node{
        TreeMap<String,Node> childNodes=new TreeMap<>((a,b)->a.compareTo(b));
        boolean endOfWord;
    }
    private static class Trie{
        Node root=new Node();
        int cnt=0;

        void insert(String input){
            Node node=this.root;
            String[] inputs=input.split("\\\\");

            for (int i=0;i<inputs.length;i++){
                if (!node.childNodes.containsKey(inputs[i])){
                    cnt++;
                    node.childNodes.put(inputs[i],new Node());
                }
                node=node.childNodes.get(inputs[i]);
            }
            node.endOfWord=true;
        }


        void search(Node node,int depth){
            if (node.childNodes==null) return;
            TreeMap<String,Node> map=node.childNodes;

            for (String key:map.keySet()){
                for (int i=0;i<depth;i++){
                    sb.append(" ");
                }
                sb.append(key).append("\n");
                search(map.get(key),depth+1);
            }
        }

    }

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        N=Integer.parseInt(br.readLine());
        Trie trie=new Trie();

        for (int i=0;i<N;i++){
            String input=br.readLine();
            trie.insert(input);
        }

        trie.search(trie.root,0);
    }
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb);
    }
}
