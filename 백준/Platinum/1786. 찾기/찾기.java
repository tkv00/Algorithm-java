import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String input;
    private static String find;
    private static final int BASE = 256;
    private static int cnt = 0;
    private static StringBuilder sb;
    private static BufferedReader br;
    private static final int MOD = 1_000_000_007;

    private static void init() throws IOException {
        sb = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        find = br.readLine();
    }

    private static void rabin_karp() {
        int findLen = find.length();
        int inputLen = input.length();

        if (findLen>inputLen){
            return;
        }
        long pow = 1;
        long hashFind = 0;
        long hashInput = 0;
        long power = 1;
        //가중치 세팅
        for (int i = 0; i < findLen - 1; i++) {
            power = (power * BASE) % MOD;
        }
        //초기 값 세팅
        for (int i = findLen - 1; i >= 0; i--) {
            hashFind = (hashFind + (pow * find.charAt(i)) % MOD) % MOD;
            hashInput = (hashInput + (pow * input.charAt(i)) % MOD) % MOD;
            pow = (pow * BASE) % MOD;
        }

        //처음값 검증
        if (hashFind == hashInput) {
            cnt++;
            sb.append(1).append(" ");
        }

        for (int i = 1; i <= inputLen - findLen; i++) {
            hashInput = ((BASE * ((hashInput - input.charAt(i - 1) * power % MOD + MOD))) % MOD + input.charAt(i + findLen - 1)) % MOD;

            if (hashFind == hashInput) {
                cnt++;
                sb.append(i + 1).append(" ");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        rabin_karp();
        sb.insert(0, cnt + "\n");
        System.out.println(sb);
    }
}
