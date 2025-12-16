import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());  // 패티 개수
        int B = Integer.parseInt(st.nextToken());  // 치즈 개수
        
        StringBuilder sb = new StringBuilder();
        
        // 햄버거 개수
        int hamburgerCount = A - B;
        
        // 유효성 검사
        if (hamburgerCount <= 0 || hamburgerCount > B) {
            sb.append("NO");
        } else {
            sb.append("YES").append("\n");
            sb.append(hamburgerCount).append("\n");
            
            // 치즈 분배 계산
            int baseCheese = B / hamburgerCount;
            int extraCheese = B % hamburgerCount;
            
            // 각 햄버거 생성
            for (int i = 0; i < hamburgerCount; i++) {
                int cheeseCount = baseCheese;
                if (i < extraCheese) {
                    cheeseCount++;  // 앞쪽 햄버거들에게 추가 치즈 1개씩
                }
                
                // 패티 개수 = 치즈 개수 + 1
                int pattyCount = cheeseCount + 1;
                
                // 햄버거 패턴 생성
                StringBuilder burger = new StringBuilder();
                for (int j = 0; j < pattyCount + cheeseCount; j++) {
                    if (j % 2 == 0) {
                        burger.append('a'); // 패티
                    } else {
                        burger.append('b'); // 치즈
                    }
                }
                sb.append(burger.toString()).append("\n");
            }
        }
        
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}