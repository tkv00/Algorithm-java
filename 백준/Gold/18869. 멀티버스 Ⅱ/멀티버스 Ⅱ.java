import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static StringTokenizer st;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
            press(arr[i]);

        }
        for (int i = 0; i < N - 1; i++) {
            for(int j=i+1;j<N;j++){
                if(Arrays.equals(arr[i],arr[j])) cnt++;
            }
        }
        System.out.println(cnt);


    }

    public static void press(int[] arr) {

        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>();
        int idx = 0;
        for (int item : sorted) {
            if (!rankMap.containsKey(item)) {
                rankMap.put(item, idx);
                idx++;
            }
        }
        int i=0;
        for (int item : arr) {
            arr[i++]=rankMap.get(item);
        }


    }

}
