import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String input;
    private static String find;
    private static BufferedReader br;
    private static int MOD = 1_000_000_007;
    private static final int BASE = 2;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        find = br.readLine();

        input = input.replaceAll("[0-9]", "");
    }

    private static int makePattern() {
        int inputLen = input.length();
        int findLen = find.length();
        long hashInput = 0, hashFind = 0;
        long pow = 1;

        if (inputLen < findLen) return 0;

        for (int i = 0; i < findLen - 1; i++) {
            pow = (pow * BASE) % MOD;
        }

        //초기 해시값 세팅 - 뒤에서부터 곱함.
        long power = 1;
        for (int i = findLen - 1; i >= 0; i--) {
            hashInput = (hashInput + power * input.charAt(i)) % MOD;
            hashFind = (hashFind + power * find.charAt(i)) % MOD;
            power = (power * BASE) % MOD;
        }

        if (hashFind == hashInput) {
            if (input.substring(0, findLen).equals(find)) return 1;
        }

        for (int i = 1; i <= inputLen - findLen; i++) {
            //젤 앞에꺼 빼주고 2번째 char를 가중치 올려줘야함.
            hashInput = ((hashInput - input.charAt(i - 1) * pow % MOD + MOD) * BASE + input.charAt(i + findLen - 1)) %
            MOD;

            if (hashFind == hashInput) {
                if (input.substring(i, i + findLen).equals(find)) return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(makePattern());
    }
}
