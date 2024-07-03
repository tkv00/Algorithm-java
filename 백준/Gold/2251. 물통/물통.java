import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Water {
    public int waterA;
    public int waterB;
    public int waterC;

    Water(int WaterA, int WaterB, int WaterC) {
        this.waterA = WaterA;
        this.waterB = WaterB;
        this.waterC = WaterC;
    }
}

public class Main {

    public static int A;
    public static int B;
    public static int C;
    public static int[] res;
    public static int[] arr;

    public static boolean[][][] visit;


    public static int i = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visit = new boolean[201][201][201];
        arr = new int[201];
        for(int i=0;i<arr.length;i++){
            arr[i]=-1;
        }

        bfs();
        Arrays.sort(arr,0,201);
       // System.out.println(Arrays.toString(arr));
        for(int item:arr){
            if(item!=-1){
                System.out.print(item+" ");
            }
        }
        //System.out.println(Arrays.toString(arr));



    }

    public static void bfs() {
        Queue<Water> waters = new LinkedList<>();
        Water initialWater = new Water(0, 0, C);
        waters.add(initialWater);



        while (!waters.isEmpty()) {
            Water curWater = waters.poll();
            if(curWater.waterA<0 || curWater.waterB<0 || curWater.waterC<0) continue;
            if (visit[curWater.waterA][curWater.waterB][curWater.waterC]) continue;

            visit[curWater.waterA][curWater.waterB][curWater.waterC] = true;
            if (curWater.waterA == 0) {
                arr[i++] = curWater.waterC;
            }
            //A->B
            if (curWater.waterB + curWater.waterA >= B) {//넘치는 경우?
                waters.add(new Water(curWater.waterA-(B-curWater.waterB),B,curWater.waterC));
            } else {
                waters.add(new Water(0, curWater.waterA + curWater.waterB, curWater.waterC));
            }
            //A->C
            if (curWater.waterC + curWater.waterA >= C) {
                waters.add(new Water(curWater.waterA-(C-curWater.waterC), curWater.waterB, C));
            } else {
                waters.add(new Water(0, curWater.waterB, curWater.waterA + curWater.waterC));
            }
            //B->C
            if ((curWater.waterB + curWater.waterC) >= C) {
                waters.add(new Water(curWater.waterA, curWater.waterB-(C-curWater.waterC), C));

            } else {
                waters.add(new Water(curWater.waterA, 0, curWater.waterB + curWater.waterC));
            }
            //B->A
            if ((curWater.waterB + curWater.waterA) >= A) {
                waters.add(new Water(A, curWater.waterB-(A-curWater.waterA), curWater.waterC ));
            } else {
                waters.add(new Water(curWater.waterA + curWater.waterB, 0, curWater.waterC));
            }
            //C->A
            if (curWater.waterA + curWater.waterC >= A) {
                waters.add(new Water(A,curWater.waterB, curWater.waterC-(A- curWater.waterA)));
            } else {
                waters.add(new Water(curWater.waterA + curWater.waterC, curWater.waterB, 0));
            }
            //C->B
            if (curWater.waterB + curWater.waterC >= B) {
                waters.add(new Water(curWater.waterA,B, curWater.waterC-(B-curWater.waterB)));
            } else {
                waters.add(new Water(curWater.waterA, curWater.waterB + curWater.waterC, 0));
            }
        }

    }


}
