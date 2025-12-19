import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int[][] matrix;
    private static int N;
    private static long B;
    private static List<Long> matrixMap;
    private static Map<Long,int[][]> matrixStore;
    private static StringBuilder sb;
    private static final int VALUE = 1_000;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        matrix = new int[N][N];
        matrixStore=new HashMap<>();
        matrixMap = new ArrayList<>();
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    //행렬 곱셈
    private static int[][] multiple(int[][] A, int[][] B) {
        int size = A.length;
        int[][] arr = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int multi = 0;
                for (int k = 0; k < size; k++) {
                    multi += (A[row][k] * B[k][col]) % VALUE;
                }
                arr[row][col] = multi % VALUE;
            }
        }

        return arr;
    }

    //리스트 값 세팅
    private static void setUp(long n) {
        while (n != 0) {
            matrixMap.add(n);
            n /= 2;
        }

       // System.out.println(matrixMap);
    }


    private static int[][] operation() {
        int size = matrixMap.size() - 1;
        int[][] result = matrix;

        for (int i = size - 1; i >= 0; i--) {
            long now = matrixMap.get(i);
            //System.out.println("now=" + now);
            
            result = multiple(result, result);
            //System.out.println("result1=" + Arrays.deepToString(result));

            if (now % 2 != 0) {
                result = multiple(result, matrix);
            }

            //System.out.println("resul2=" + Arrays.deepToString(result));
        }

        return result;
    }

    private static void printMap(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j] % VALUE).append(" ");
            }
            sb.append("\n");
        }
    }


    public static void main(String[] args) throws IOException {
        init();
        setUp(B);
        int[][] answer = operation();
        printMap(answer);

        System.out.println(sb);
    }
}
