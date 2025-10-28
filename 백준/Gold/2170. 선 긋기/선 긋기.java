
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static List<int[]> list;
    private static int len = 0;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new int[]{x, y});
        }
    }

    private static void operation() {
        list.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        //초기 값 설정
        int start = list.get(0)[0];
        int end = list.get(0)[1];

        for (int i = 1; i < list.size(); i++) {
            int s = list.get(i)[0];
            int e = list.get(i)[1];

            //값이 갱신
            if (s > end) {
                len += end - start;
                start = s;
            }
            end = Math.max(e,end);
        }
        len+=end-start;
    }

    public static void main(String[] args) throws IOException {
        init();
        operation();
        System.out.println(len);
    }
}
