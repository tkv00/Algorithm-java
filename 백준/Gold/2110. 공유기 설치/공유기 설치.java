import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;
    public static int n;
    public static int m;
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());//공유기 개수
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        //처음 값
        int res=0;
        int left = 0;
        int right = arr[n - 1]-arr[0];
        while (left <= right) {
            int cnt = 1;

            int mid = (left + right) / 2;
            int start = arr[0];
            for (int i = 1; i < n; i++) {
                if (start + mid <= arr[i]) {
                    start = arr[i];
                    cnt++;
                }
            }
            //너무 넓게 설정.
            if (cnt < m) {

                right = mid - 1;

            } else {
                res=mid;
                left = mid + 1;
            }

        }
        System.out.println(res);
    }
}
