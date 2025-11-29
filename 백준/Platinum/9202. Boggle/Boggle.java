import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static final int SIZE = 4;
    private static BufferedReader br;
    private static StringBuilder sb;
    private static Dictionary tree;
    private static List<char[][]> inputs;
    private static Set<String> set ;
    private static int[] dr = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dc = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    private static boolean[][] visited;

    private static class Dictionary {
        boolean terminate;
        Map<Character, Dictionary> child = new HashMap<>();

        void insert(String input) {
            Dictionary root = this;

            char[] inputArr = input.toCharArray();
            for (int i = 0; i < inputArr.length; i++) {
                root.child.putIfAbsent(inputArr[i], new Dictionary());
                root = root.child.get(inputArr[i]);

                if (i == inputArr.length - 1) {
                    root.terminate = true;
                }
            }
        }

        boolean contains(String input){
            Dictionary root=this;

            char[] inputArr=input.toCharArray();
            for (int i=0;i<inputArr.length;i++){
                Dictionary next=root.child.get(inputArr[i]);

                if (next==null) return false;
                if (i==inputArr.length-1){
                    return next.terminate;
                }
                root=next;
            }

            return false;
        }

        //초기 판단
        boolean initWord(char init){
            Dictionary node=this;
            for (char c:node.child.keySet()){
                if (init==c) return true;
            }
            return false;
        }
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        tree = new Dictionary();
        inputs = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        sb=new StringBuilder();

        //단어 사전에 들어있는 단어
        for (int i = 0; i < N; i++) {
            tree.insert(br.readLine());
        }

        br.readLine();

        int boardCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < boardCount; i++) {
            char[][] map = new char[SIZE][SIZE];
            for (int j = 0; j < SIZE; j++) {
                String input = br.readLine();
                map[j] = input.toCharArray();
            }

            inputs.add(map);

            if (i < boardCount - 1) {
                br.readLine();
            }
        }

    }

    private static void operation(char[][] map) {
        set= new TreeSet<>((a, b) -> b.length() == a.length() ? a.compareTo(b) : b.length() - a.length());
        int maxScore = 0;
        String maxString = "";
        int totalWord = 0;
        visited=new boolean[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                //초기 판단
                if (!tree.initWord(map[i][j])) continue;
                visited[i][j]=true;
                search(i,j, String.valueOf(map[i][j]),visited,set,map);
                visited[i][j]=false;
            }
        }

        //점수 계산 및 가장 긴 단어
        int idx=0;
        for (String key:set){
            if (idx==0){
                maxString=key;
            }
            maxScore+=calculateScore(key);
            idx++;
        }
        totalWord=set.size();

        sb
                .append(maxScore)
                .append(" ")
                .append(maxString)
                .append(" ")
                .append(totalWord)
                .append("\n");
    }

    private static void search(int x, int y, String str,boolean[][] visited,Set<String> set,char[][] map) {
        if (str.length()>8) return;

        //사전에 단어가 들어가 있는 경우
        if (tree.contains(str)){
            set.add(str);
           
        }

        for (int d=0;d<8;d++){
            int nr=x+dr[d];
            int nc=y+dc[d];

            if (nr<0 || nr>=4 || nc<0 || nc>=4) continue;
            if (visited[nr][nc]) continue;

            visited[nr][nc]=true;
            search(nr,nc,str+map[nr][nc],visited,set,map);
            visited[nr][nc]=false;
        }
    }

    //점수 계산

    private static int calculateScore(String str) {
        int len = str.length();

        if (len <= 2) return 0;
        else if (len <= 4) return 1;
        else if (len == 5) return 2;
        else if (len == 6) return 3;
        else if (len == 7) return 5;
        else if (len == 8) return 11;
        return -1;
    }
    public static void main(String[] args) throws IOException {
        init();

        for (char[][] map:inputs){
            operation(map);
        }

        System.out.println(sb);
    }
}
