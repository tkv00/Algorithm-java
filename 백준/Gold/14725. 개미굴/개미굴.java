import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    private static int N;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static StringBuilder sb;
    private static final String FLOOR="--";
    private static Trie trie;
    private static class Trie{
       TreeMap<String,Trie> child=new TreeMap<>((a,b)->a.compareTo(b));

        void insert(String[] inputs){
            Trie root=this;

            for (String input:inputs){
                root.child.putIfAbsent(input,new Trie());
                root=root.child.get(input);
            }
        }
    }
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        trie=new Trie();
        sb=new StringBuilder();

        for (int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int K=Integer.parseInt(st.nextToken());
            String[] inputs=new String[K];

            for (int k=0;k<K;k++){
                inputs[k]=st.nextToken();
            }
            trie.insert(inputs);
        }
    }

    private static void DFS(Trie now,int depth){
       for (Map.Entry<String,Trie> next:now.child.entrySet()){
            for (int i=0;i<depth;i++){
                sb.append(FLOOR);
            }

            sb.append(next.getKey()).append("\n");

            DFS(next.getValue(),depth+1);
       }
    }

    public static void main(String[] args) throws IOException {
        init();
        DFS(trie,0);

        System.out.println(sb);
    }
}
