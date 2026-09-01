import java.util.*;
import java.io.*;

public class Main {
    //참가자들 이동거리 합
    private static int total;
    private static StringTokenizer st;
    private static BufferedReader br;

    //사람이 있는 곳은 10부터 명명
    private static int[][] map;
    private static int N;
    private static int M;
    private static int K;
    private static int time;

    private static List<Position> humans;
    private static Position exit;

    private int humanCount;

    private final static int[] dx = new int[]{1,-1,0,0};
    private final static int[] dy = new int[]{0,0,1,-1};

    private static class Position{
        int row;
        int col;

        public Position(int row,int col){
            this.row=row;
            this.col=col;
        }

        public static Position rotate(
            int sr,
            int sc,
            int size,
            int row,
            int col
        ){
            int newRow = sr + (col - sc);
            int newCol = sc + (size - 1 - (row - sr));

            return new Position(newRow, newCol);
            
        }

        @Override
        public int hashCode(){
            return Objects.hash(row,col);
        }

        @Override
        public boolean equals(Object o){
            if(!(o instanceof Position)) return false;

            Position p = (Position) o;

            return p.row==this.row && p.col==this.col;
        }
    }

private static void init() throws IOException {
    br=new BufferedReader(new InputStreamReader(System.in));
    st=new StringTokenizer(br.readLine());
    humans = new ArrayList<>();
    total=0;

    N=Integer.parseInt(st.nextToken());
    M=Integer.parseInt(st.nextToken());
    K=Integer.parseInt(st.nextToken());

    map = new int[N+1][N+1];
    

    for(int i=1;i<=N;i++){
        st = new StringTokenizer(br.readLine());
        for(int j=1;j<=N;j++){
            map[i][j]=Integer.parseInt(st.nextToken());
        }
    }

    for(int i=0;i<M;i++){
        st=new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        humans.add(new Position(row,col));
    }

    st = new StringTokenizer(br.readLine());
    int er = Integer.parseInt(st.nextToken());
    int ec = Integer.parseInt(st.nextToken());
    
    exit = new Position(er,ec);
}

private static void rotation(int sr,int sc,int size){
    int[][] temp = new int[size][size];

    // 벽 회전
    for (int r = 0; r < size; r++) {
        for (int c = 0; c < size; c++) {

            temp[c][size - 1 - r]
                    = map[sr + r][sc + c];
        }
    }

    // 다시 map에 넣으면서 벽 내구도 감소
    for (int r = 0; r < size; r++) {
        for (int c = 0; c < size; c++) {

            int value = temp[r][c];

            if (value > 0) {
                value--;
            }

            map[sr + r][sc + c] = value;
        }
    }

    //사람도 회전
    for(Position human:humans){
        if(isInside(human.row,human.col,sr,sc,size)){
            Position rotatedPosition =
                human.rotate(sr,sc,size,human.row,human.col);

            human.row = rotatedPosition.row;
            human.col = rotatedPosition.col;
        }
    }

    //출구 회전
    Position rotatedExit = exit.rotate(sr,sc,size,exit.row,exit.col);
    exit.row=rotatedExit.row;
    exit.col=rotatedExit.col;
}

private static boolean isInside(
            int row,
            int col,
            int sr,
            int sc,
            int size
    ) {

        return sr <= row
                && row < sr + size
                && sc <= col
                && col < sc + size;
    }

private static boolean isValid(int row,int col){
    return row>=1 && row<=N && col>=1 && col<=N;
}


//거리 계산
private static int calculate(int r1,int r2,int c1,int c2){
    return Math.abs(r1-r2)+Math.abs(c1-c2);
}

//참가자 움직이기
private static void move(){
    //참가자들의 새로운 좌표 저장소
    List<Position> nextHumans = new ArrayList<>();
   

    for(Position pos:humans){
        int previousDistance = calculate(pos.row,exit.row,pos.col,exit.col);
         boolean moved = false;
        for(int dir=0;dir<4;dir++){
            int nr=pos.row+dx[dir];
            int nc=pos.col+dy[dir];

            if(!isValid(nr,nc)) continue;
            if(map[nr][nc]>0) continue;

            int newDistance=calculate(nr,exit.row,nc,exit.col);

            if(newDistance>=previousDistance) continue;

            total++;
            moved = true;

            if(nr!=exit.row || nc!=exit.col){
                nextHumans.add(new Position(nr,nc));
            }

            break;
        }

        if(!moved) nextHumans.add(pos);
    }

    humans = nextHumans;
}

//정사각형 선택하기
private static int[] select(){
    
    for(int size=1;size<=N;size++){
        for(int sr=1;sr+size-1<=N;sr++){
            for(int sc=1;sc+size-1<=N;sc++){
                //출구가 범위내에 들어가 있는가
                int er = sr+size-1;
                int ec = sc+size-1;

                if(
                    !(exit.row>=sr 
                    && exit.row<=er
                    && exit.col>=sc
                    && exit.col<=ec)
                ){
                    continue;
                }

                boolean hasHuman=false;

                for(Position human:humans){
                    if(human.row>=sr && human.row<=er && human.col>=sc && human.col<=ec){
                        hasHuman=true;
                        break;
                    }
                }

                if(hasHuman){
                    return new int[]{sr,sc,size};
                }
            }
        }
    }


    return null;
}


public static void main(String[] args) throws IOException {
    // Please write your code here.

    init();

    for(int time=0;time<K;time++){
        move();
        if(humans.isEmpty()) break;

        int[] square = select();

        rotation(square[0],square[1],square[2]);
    }

    //정답 출력
    System.out.println(total);
    System.out.print(exit.row+" "+exit.col);
}
}