import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int sum = 0;
    private static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += solve(br.readLine());
        }
        System.out.print(sum);
    }

    private static int solve(String str) {
        char[] arr = str.toCharArray();
        if (str.length() % 2 != 0) return 0;

        stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length ; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                continue;
            }
            if (arr[i] == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(arr[i]);


        }
        if (stack.isEmpty()) return 1;
        return 0;
    }


}
