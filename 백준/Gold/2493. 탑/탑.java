
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static Block[] inputs;
    private static StringBuilder sb;

    private static class Block {
        int idx;
        int h;

        Block(int idx, int h) {
            this.h = h;
            this.idx = idx;
        }
    }

    private static int N;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static Stack<Block> stack;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        stack = new Stack<>();
        inputs = new Block[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int idx = 1; idx <= N; idx++) {
            inputs[idx] = new Block(idx, Integer.parseInt(st.nextToken()));
        }
    }

    private static void operation() {
        for (int i = 1; i <= N; i++) {
            Block now = inputs[i];

            while (!stack.isEmpty()) {
                if (stack.peek().h > now.h){
                    sb.append(stack.peek().idx).append(" ");
                    stack.push(now);
                    break;
                }
                if (stack.peek().h < now.h) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                stack.push(now);
                sb.append(0).append(" ");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        operation();

        System.out.println(sb);
    }
}
