
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    private static class Trie {
        String name;
        TreeMap<String, Trie> child = new TreeMap<>((a,b)->a.compareTo(b));

        public Trie( ) {
        }

        private void insert(String[] inputs){
            Trie root=this;

            for (String input:inputs){
                root.child.putIfAbsent(input,new Trie());
                root=root.child.get(input);
            }
        }
    }

    private static int N, K;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static final String PARTITION = "--";
    private static StringBuilder sb;
    private static Trie trie;

    private static void init() throws IOException {
        trie=new Trie();
        sb = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            String[] cleaned=Arrays.copyOfRange(inputs,1,inputs.length);
            trie.insert(cleaned);
        }
    }

    private static void dfs(Trie now,int depth) {
        for (Map.Entry<String,Trie> next:now.child.entrySet()){
            for (int i=0;i<depth;i++){
                sb.append(PARTITION);
            }

            sb.append(next.getKey()).append("\n");
            dfs(next.getValue(),depth+1);
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        dfs(trie,0);

        System.out.println(sb);
    }
}
