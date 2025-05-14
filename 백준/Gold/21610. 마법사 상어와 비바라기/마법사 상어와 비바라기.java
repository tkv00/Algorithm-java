import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Move{
        int dir;
        int move;
        public Move(int dir,int move){
            this.dir=dir;
            this.move=move;
        }
    }
    private static class Node{
        int row;
        int col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    //←, ↖, ↑, ↗, →, ↘, ↓, ↙
    private static int[] dRow=new int[]{0,-1,-1,-1,0,1,1,1};
    private static int[] dCol=new int[]{-1,-1,0,1,1,1,0,-1};
    private static int arrSize;
    private static int[][] map;
    private static boolean[][] visited;
    private static int moveCnt=0;
    private static StringTokenizer st;
    private static Queue<Node> cloudInfoQueue=new LinkedList<>();
    private static boolean isValid(int row,int col){
        if(row<0 || row>=arrSize || col<0 || col>=arrSize)
            return false;
        return true;
    }
    private static void moving(Move move) {
        int size=cloudInfoQueue.size();
        Queue<Node> afterCloud=new LinkedList<>();
        //1. 구름 이동
        for (int i=0;i<size;i++){
            Node now=cloudInfoQueue.poll();
            int newRow=(arrSize+now.row+move.move*dRow[move.dir-1])%arrSize;
            int newCol=(arrSize+now.col+move.move*dCol[move.dir-1])%arrSize;

            if(newRow<0) newRow+=arrSize;
            if (newCol<0) newCol+=arrSize;
            //2. 구름 있는 칸 바구니 물의 양 1증가
            map[newRow][newCol]+=1;
            afterCloud.offer(new Node(newRow,newCol));
            visited[newRow][newCol]=true;
        }
        while (!afterCloud.isEmpty()){
            Node node=afterCloud.poll();
            int newRow=node.row;
            int newCol=node.col;
            //4번 먼저
            int cnt=0;
            for (int j=1;j<=7;j+=2){
                int crossRow=newRow+dRow[j];
                int crossCol=newCol+dCol[j];
                if(isValid(crossRow,crossCol)&&map[crossRow][crossCol]>0)
                    cnt++;
            }
            map[newRow][newCol]+=cnt;
        }


        //5. 바구니에 저장된 물의 양 2이상 모든 칸 구름 생김 처리
        for (int i=0;i<arrSize;i++){
            for (int j=0;j<arrSize;j++){
                if(!visited[i][j]&&map[i][j]>=2){
                    cloudInfoQueue.offer(new Node(i,j));
                    //물의 양 2 감소
                    map[i][j]-=2;
                }
            }
        }
        //방문 배열 초기화
        visited=new boolean[arrSize][arrSize];
    }



    //물의 양 총합 출력
    private static int sumOfMap(){
        int sum=0;
        for (int i=0;i<arrSize;i++){
            for(int x:map[i]){
                sum+=x;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        arrSize=Integer.parseInt(st.nextToken());
        moveCnt=Integer.parseInt(st.nextToken());
        map=new int[arrSize][arrSize];
        visited=new boolean[arrSize][arrSize];

        //처음 구름 위치 표시
        cloudInfoQueue.offer(new Node(arrSize-1,0));
        cloudInfoQueue.offer(new Node(arrSize-1,1));
        cloudInfoQueue.offer(new Node(arrSize-2,0));
        cloudInfoQueue.offer(new Node(arrSize-2,1));

        for (int i=0;i<arrSize;i++){
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<arrSize;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0;i<moveCnt;i++){
            st=new StringTokenizer(br.readLine());
            int d=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            moving(new Move(d,s));

        }

        System.out.println(sumOfMap());
    }
}
