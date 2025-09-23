import java.io.*;
import java.util.*;

public class Main {
    private static Map<Integer, Integer> countMap;
    private static int rowSize=3;
    private static int colSize=3;
    //0은 제외하고 센다.
    private static void operationR() {
        int newColSize=0;
        for (int i = 0; i < rowSize; i++) {
            countMap = new HashMap<>();

            for (int j = 0; j < colSize; j++) {
                if (map[i][j] == 0) continue;
                int value = map[i][j];
                countMap.put(value, countMap.getOrDefault(value, 0) + 1);
            }

            Arrays.fill(map[i],0);

            List<Integer> keys = new ArrayList<>(countMap.keySet());
            keys.sort((a, b) -> countMap.get(a).equals(countMap.get(b)) ? a - b : countMap.get(a) - countMap.get(b));


            int idx = 0; //열 인덱스
            for (Integer key : keys) {
                if(idx>=INF) break;;
                map[i][idx++] = key;
                if (idx>=INF) break;
                map[i][idx++] = countMap.get(key);
            }
            newColSize=Math.max(newColSize,idx);
        }
        colSize=newColSize;
    }

    private static void operationC() {
        int newRowSize=0;
        for (int c=0;c<colSize;c++){
            countMap=new HashMap<>();

            for (int r=0;r<rowSize;r++){
                if(map[r][c]==0) continue;
                int value=map[r][c];
                countMap.put(value,countMap.getOrDefault(value,0)+1);
            }

            for (int i=0;i<rowSize;i++){
                map[i][c]=0;
            }

            List<Integer> keys=new ArrayList<>(countMap.keySet());
            keys.sort((a, b) -> countMap.get(a).equals(countMap.get(b)) ? a - b : countMap.get(a) - countMap.get(b));

            int idx=0;
            for (Integer key:keys){
                if (idx>=INF) break;
                map[idx++][c]=key;

                if (idx>=INF) break;
                map[idx++][c]=countMap.get(key);
            }
            newRowSize=Math.max(newRowSize,idx);
        }
        rowSize=newRowSize;
    }

    //R연산인지 C연산인지 판단.
    private static int whatIsValue() {
        if(rowSize>=colSize)return R;
        else return C;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[INF][INF];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }


    private static int r, c, k;
    private static int result = 0;
    private static final int INF = 101;
    private static StringTokenizer st;
    private static int[][] map;
    private static final int R = 1, C = 2;

    public static void main(String[] args) throws IOException {
        input();

        while (result<=100){
            if(map[r-1][c-1]==k) {
                System.out.println(result);
                return;
            }

            //R연산 C연산 판단.
            int t=whatIsValue();
            if(t==R){
                operationR();
            }else{
                operationC();
            }
           // printMap();
            result++;
        }
        System.out.println(-1);
    }
}
