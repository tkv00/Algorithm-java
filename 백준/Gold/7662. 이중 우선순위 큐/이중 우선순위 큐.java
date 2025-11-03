import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    private static final String EMPTY = "EMPTY";
    private static int T;
    private static int k;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static final String INSERT = "I";
    private static final String DELETE = "D";
    private static TreeMap<Integer, Integer> treeMap;
    private static StringBuilder sb;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            k = Integer.parseInt(br.readLine());
            treeMap = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                operation(order, num);
            }
            printResult();
        }

        System.out.print(sb);
    }

    private static void operation(String order, int num) {
        if (order.equals(INSERT)) {
            insert(num);
        } else if (order.equals(DELETE)) {
            if(treeMap.isEmpty()) return;
            //최댓값 삭제
            if (num == 1) {
                int maxKey = treeMap.lastKey();
                delete(maxKey);
            }

            //최솟값 삭제
            else if (num == -1) {
                int minKey = treeMap.firstKey();
                delete(minKey);
            }
        }
    }

    private static void insert(int num) {
        treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
    }

    private static void delete(int num) {
        if (!treeMap.containsKey(num)) return;

        int cnt = treeMap.getOrDefault(num, 0);
        if (cnt <= 1) {
            treeMap.remove(num);
        } else {
            treeMap.put(num, cnt - 1);
        }
    }

    private static void printResult() {
        if (treeMap.isEmpty()) {
            sb.append(EMPTY).append("\n");
            return;
        }

        sb.append(treeMap.lastKey())
                .append(" ")
                .append(treeMap.firstKey())
                .append("\n");

    }

    public static void main(String[] args) throws IOException {
        init();
    }
}
