import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static BufferedReader br;
    private static int result = 0;
    private static boolean[][] visited;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
    }

    private static void backTracking(int row) {
        if (row >= N) {
            result++;
            return;
        }


        for (int col=0;col<N;col++){
            if (isSafe(row,col)){
                visited[row][col]=true;
                backTracking(row+1);
                visited[row][col]=false;
            }
        }
    }

    private static boolean isSafe(int row, int col) {
        //열 검사
        for (int i = 0; i < row; i++) {
            if (visited[i][col]) return false;
        }

        //왼쪽 위 대각선
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (visited[i][j]) return false;
        }

        //오른쪽 위 대각선
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (visited[i][j]) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        init();
        backTracking(0);

        System.out.println(result);
    }
}
