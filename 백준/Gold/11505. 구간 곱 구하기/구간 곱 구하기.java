import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static long[] tree;
    private static int start_idx;
    private static StringBuilder sb;
    private static final long MOD = 1_000_000_007;

    private static int countK() {
        int k = 0;
        while (true) {
            k++;
            if (Math.pow(2, k) >= N) break;
        }
        return k;
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        start_idx = (int) Math.pow(2, countK());
        tree = new long[start_idx * 2];
        Arrays.fill(tree, 1L);

        for (int i = 0; i < N; i++) {
            tree[start_idx + i] = Integer.parseInt(br.readLine());
        }
    }

    private static void operation() throws IOException {
       for (int i=0;i<M+K;i++){
           st=new StringTokenizer(br.readLine());
           int order=Integer.parseInt(st.nextToken());
           int b=Integer.parseInt(st.nextToken());
           long c=Long.parseLong(st.nextToken());

           if (order==1){
               update_tree(b,c);
           }else if (order==2){
               sb.append(interval_multiply(start_idx+b-1,start_idx+(int)c-1)).append("\n");
           }
       }

    }

    /**
     * 구간 곱 구하기
     */
    private static long interval_multiply(int start, int end) {
        long sum = 1;
        while (start <= end) {
            if (start % 2 == 1) {
                sum = (tree[start] * sum) % MOD;
                start++;
            }
            if (end % 2 == 0) {
                sum = (tree[end] * sum) % MOD;
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return sum;
    }

    /**
     * 구간 업데이트
     */
    private static void update_tree(int idx, long num) {
        int index = start_idx + idx - 1;
        tree[index] = num;

        index /= 2;

        while (index > 0) {
            tree[index] = (tree[index * 2] * tree[index * 2 + 1]) % MOD;
            index /= 2;
        }
    }

    private static void makeTree() {
        for (int i = start_idx - 1; i > 0; i--) {
            tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        makeTree();
        operation();
        System.out.println(sb);
    }
}
