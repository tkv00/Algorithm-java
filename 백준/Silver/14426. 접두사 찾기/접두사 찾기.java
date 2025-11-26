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
    private static int result=0;
    private static TrieTree trieTree;

    private static class TrieTree{
        Map<Character,TrieTree> childNode=new HashMap<>();
        boolean terminate;

        public void insert(String input){
            TrieTree trieTree=this;
            for (int w=0;w<input.length();w++){
                char c=input.charAt(w);

                trieTree.childNode.putIfAbsent(c,new TrieTree());
                trieTree=trieTree.childNode.get(c);
                trieTree.terminate=true;
            }
        }

        public boolean find(String input){
            TrieTree trieTree=this;

            for (int w=0;w<input.length();w++){
                char c=input.charAt(w);
                TrieTree node=trieTree.childNode.get(c);

                if(node==null) return false;
                if(!node.terminate) return false;

                trieTree=node;
            }
            return true;
        }
    }
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        trieTree=new TrieTree();

        for (int i=0;i<N;i++){
            String input=br.readLine();
            trieTree.insert(input);
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        for (int i=0;i<M;i++){
            if (trieTree.find(br.readLine())) result++;
        }

        System.out.println(result);
    }
}
