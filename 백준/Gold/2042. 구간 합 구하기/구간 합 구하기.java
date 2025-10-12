import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K;
    //M : 수 변경 횟수 K:구간 합 구하는 횟수
    private static BufferedReader br;
    private static StringTokenizer st;
    private static long[] tree;
    private static int k;
    private static StringBuilder sb;
    private static int getCount() {
        int k = 0;
        while (true) {
            k++;

            if (Math.pow(2, k) >= N) break;
            ;
        }
        return k;
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb=new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        k = getCount();
        tree = new long[(int) Math.pow(2, k + 1)];

        for (int i = 0; i < N; i++) {
            tree[i + (int) Math.pow(2, k)] = Long.parseLong(br.readLine());
        }

        makeTree();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            //업데이트
            if (order == 1) {
                update(b,c);
            }
            //부분합
            else if (order == 2) {
                sb.append(
                        interval_sum((int)Math.pow(2,k)+b-1, 
                                (int) (Math.pow(2,k) + c - 1)
                        )).append("\n");
            }
        }
    }
    //트리 만들기
    private static void makeTree(){
        for (int i=(int)Math.pow(2,k)-1;i>0;i--){
            tree[i]=tree[i*2]+tree[i*2+1];
        }
    }

    //부분합 구하기
    private static long interval_sum(int start, int end) {
        long sum=0;

        while (start<=end){
            if (start%2==1) {
                sum += tree[start];
                start++;
            }
            if (end%2==0) {
                sum += tree[end];
                end--;
            }

            start/=2;
            end/=2;
        }
        return sum;
    }

    //업데이트
    private static void update(int b,long c){
        int idx=(int) Math.pow(2,k)+b-1;
        //차이값
        long diff=c-tree[idx];

        while (idx!=0){
            tree[idx]+=diff;
            idx/=2;
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb);
    }
}
