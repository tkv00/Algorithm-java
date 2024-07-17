import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class Move {
        int x;
        int y;

        Move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int width;
    public static int height;
    public static int x;
    public static int y;
    public static int orderNum;
    public static ArrayList<Move> move;
    public static StringTokenizer st;
    public static int[][] map;
    public static int[] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        orderNum = Integer.parseInt(st.nextToken());
        map = new int[height][width];

        //주사위 순서 맨위,앞,맨아래,뒤,왼쪽,오른쪽
        dice = new int[6];

        //이동정보 저장
        move = new ArrayList<>();
        move.add(new Move(0, 1));//동쪽
        move.add(new Move(0, -1));//서쪽
        move.add(new Move(-1, 0));//북쪽
        move.add(new Move(1, 0));//남쪽

        //맵정보 입력받기
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int nowX = x, nowY = y;
        //명령정보 입력 및 결과 출력
        for (int i = 0; i < orderNum; i++) {
            int num = Integer.parseInt(st.nextToken());

            //예외처리해야할듯
            Move moving = move.get(num - 1);
            int newX = nowX + moving.x;
            int newY = nowY + moving.y;

            // 맵 범위를 벗어나면 이동하지 않음
            if (newX < 0 || newX >= height || newY < 0 || newY >= width) {
                continue;
            }
            nowX = newX;
            nowY = newY;
            diceMove(num);

            //이동한 칸에 쓰인 수가 0인경우
            if (map[nowX][nowY] == 0) {
                map[nowX][nowY] = dice[2]; //주사위 바닥면에 쓰인 수가 칸에 복사
                //System.out.println(dice[0]);
            } else {
                dice[2] = map[nowX][nowY];
                map[nowX][nowY] = 0;
                //  System.out.println(dice[0]);
            }

            System.out.println(dice[0]);


        }
        // System.out.println(Arrays.toString(dice));


    }

    //주사위 움직이기 함수
    public static void diceMove(int move) {
        int first = dice[0];
        int second = dice[1];
        int third = dice[2];
        int fourth = dice[3];
        int fifth = dice[4];
        int sixth = dice[5];

        switch (move) {
            case 1:
                //동쪽
                dice[0] = fifth;
                dice[2] = sixth;
                dice[4] = third;
                dice[5] = first;
                break;
            //서쪽
            case 2:
                dice[0] = sixth;
                dice[2] = fifth;
                dice[4] = first;
                dice[5] = third;
                break;
            //남쪽
            case 3:
                dice[0] = fourth;
                dice[1] = first;
                dice[2] = second;
                dice[3] = third;
                break;
            //북쪽
            case 4:
                dice[0] = second;
                dice[1] = third;
                dice[2] = fourth;
                dice[3] = first;
                break;

        }
    }

    //
}
