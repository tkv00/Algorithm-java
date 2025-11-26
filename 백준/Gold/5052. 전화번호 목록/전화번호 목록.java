import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int T;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static StringBuilder sb;
    private static List<String> inputs;

    private static class Trie {
        boolean terminate = false;
        Map<Integer, Trie> childNode = new HashMap<>();

        boolean insert(String input) {
            Trie root = this;

            for (int w = 0; w < input.length(); w++) {
                int value = input.charAt(w) - '0';

                root.childNode.putIfAbsent(value, new Trie());
                root = root.childNode.get(value);

                if (root.terminate) return false;

                if (input.length() - 1 == w) {
                    root.terminate = true;
                }
            }
            return true;
        }

    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            inputs = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                inputs.add(br.readLine());
            }

            Collections.sort(inputs, (a, b) -> a.length() - b.length());
            Trie trie = new Trie();
            boolean flag = true;

            for (String input : inputs) {
                if (!trie.insert(input)) flag = false;
            }

            if (!flag) sb.append("NO").append("\n");
            else sb.append("YES").append("\n");
        }


    }

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb);
    }
}
