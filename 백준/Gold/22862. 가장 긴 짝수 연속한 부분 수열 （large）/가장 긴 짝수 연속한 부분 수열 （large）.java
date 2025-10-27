import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[] arr;
    private static int max = 0;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

    }

    private static void operation() {
        int start = 0, end = 0;
        int odd = 0;
        int len = 0;

        while (end < N) {
            int now = arr[end];

            if (now % 2 != 0){
                if (odd < K) {
                    len++;
                    odd++;
                    end++;
                } else {
                    max = Math.max(len-odd, max);
                    if (arr[start]%2==0){
                        start++;
                        len--;
                    }else{
                        odd--;
                        start++;
                        len--;
                    }
                }
            }else {
                len++;
                end++;
            }

            max=Math.max(len-odd,max);
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        operation();
        System.out.println(max);
    }
}
