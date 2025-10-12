import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[] minTree;
    private static int[] maxTree;
    private static StringBuilder sb=new StringBuilder();
    private static int size;

    private static int getK() {
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

        size = (int) Math.pow(2, getK());

        minTree = new int[size * 2];
        maxTree = new int[size * 2];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            minTree[size + i] = num;
            maxTree[size + i] = num;
        }

    }

    private static void makeMinTree() {
        for (int i = size - 1; i > 0; i--) {
            minTree[i] = Math.min(minTree[i * 2], minTree[i * 2 + 1]);
        }
    }

    private static void makeMaxTree() {
        for (int i = size - 1; i > 0; i--) {
            maxTree[i] = Math.max(maxTree[i * 2], maxTree[i * 2 + 1]);
        }
    }

    private static void find() throws IOException {
        for (int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            int min=interval_min(a,b);
            int max=interval_max(a,b);

            sb.append(min).append(" ").append(max).append("\n");
        }
    }

    private static int interval_min(int start,int end){
        start=size+start-1;
        end=size+end-1;
        int min=Integer.MAX_VALUE;

        while (start<=end){
            if (start%2==1){
                min=Math.min(min,minTree[start]);
                start++;
            }
            if (end%2==0){
                min=Math.min(min,minTree[end]);
                end--;
            }

            start/=2;
            end/=2;
        }

        return min;
    }

    private static int interval_max(int start,int end){
        start=size+start-1;
        end=size+end-1;
        int max=Integer.MIN_VALUE;

        while (start<=end){
            if (start%2==1){
                max=Math.max(max,maxTree[start]);
                start++;
            }
            if (end%2==0){
                max=Math.max(max,maxTree[end]);
                end--;
            }

            start/=2;
            end/=2;
        }

        return max;
    }
    public static void main(String[] args) throws IOException {
        init();
        makeMaxTree();
        makeMinTree();
        find();
        System.out.println(sb);
    }
}
