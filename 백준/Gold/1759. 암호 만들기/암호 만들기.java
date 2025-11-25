import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int L, C;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static List<Character> inputs;
    private static boolean[] selected;
    private static StringBuilder sb;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        inputs = new ArrayList<>();

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        selected = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            inputs.add(st.nextToken().charAt(0));
        }


        Collections.sort(inputs);
    }

    //모음 판단
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static void DFS(int idx, int cnt, String str,int vowel,int consonant) {

        if (cnt == L) {
            if(vowel>=1 && consonant>=2){
                sb.append(str).append("\n");
            }
            return;
        }

        if (idx == C) return;

        char c=inputs.get(idx);

        //모음인 경우
        if(isVowel(c)){
            DFS(idx+1,cnt+1,str+c,vowel+1,consonant);
        }else{
            DFS(idx+1,cnt+1,str+c,vowel,consonant+1);
        }

        //선택하지 않는 경우
        DFS(idx+1,cnt,str,vowel,consonant);

    }

    public static void main(String[] args) throws IOException {
        init();
        DFS(0, 0, "",0,0);

        System.out.println(sb);
    }
}
