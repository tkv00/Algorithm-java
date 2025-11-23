import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class SegmentTree {
        int nodes;
        int height;
        static long[] tree;

        SegmentTree(int N) {
            height = (int) Math.ceil(Math.log(N) / Math.log(2));
            nodes = (int) Math.pow(2, height + 1);
            tree = new long[nodes];
        }

        //초기화
        long init(int start, int end, int node) {
            if (start == end) {
                return tree[node] = origin[start];
            }

            int mid = (start + end) / 2;

            return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);

        }

        //수정
        // - newValue:수정하고자 하는 값
        // -node:수정 인덱스
        void update(int node, int start, int end, int index, long diff) {
            if (start > index || end < index) return;

            //해당 값 수정
            tree[node] += diff;
            int mid = (start + end) / 2;

            if (start == end) return;

            update(node * 2, start, mid, index, diff);
            update(node * 2 + 1, mid + 1, end, index, diff);
        }

        //구간 합 추출
        long search(int start, int end, int node, int left, int right) {
            if (left > end || right < start) return 0;

            if (left <= start && right >= end) {
                return tree[node];
            }

            int mid = (start + end) / 2;

            return search(start, mid, node * 2, left, right) + search(mid + 1, end, node * 2 + 1, left, right);
        }

    }

    private static int N, M, K;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static long[] origin;
    private static SegmentTree segmentTree;
    private static StringBuilder sb;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        origin = new long[N];
        segmentTree = new SegmentTree(N);

        for (int i = 0; i < N; i++) {
            origin[i] = Long.parseLong(br.readLine());
        }
        segmentTree.init(0, N - 1, 1);

    }

    private static void operation() throws IOException {
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) - 1;


            //a=1 => b번째 수를 c로 change
            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                long diff = c - origin[b];
                origin[b] = c;
                segmentTree.update(1, 0, N - 1, b, diff);
            }
            //a=2 => b번째 수로부터 c번째 수 합
            else if (a == 2) {
                int c=Integer.parseInt(st.nextToken());
                sb.append(segmentTree.search(0, N - 1, 1, b, c - 1)).append("\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        operation();

        System.out.println(sb);
    }
}
