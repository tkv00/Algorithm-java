import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point{
        int row;
        int col;
        Point(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    static int N;
    static int L;
    static int R;
    static StringTokenizer st;
    static int[][]map;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static boolean[][] visited;
    static int day=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());


        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());

        map=new int[N][N];
        visited=new boolean[N][N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        while (true){
            visited=new boolean[N][N];
            boolean move=false;

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j]){
                        int size=bfs(i,j);
                        if(size>1){
                            move=true;
                        }
                    }
                }
            }
            if(!move)break;
            day++;
        }
        System.out.println(day);



    }
    //경계
    static boolean isValid(int x,int y){
        if(x<0 || x>=N || y<0 || y>=N) return false;
        return true;
    }
    //문제 범위
    static boolean isValid2(int x1,int y1,int x2,int y2){
        int t=Math.abs(map[x1][y1]-map[x2][y2]);
        if(t>=L && t<=R)return true;
        return false;
    }

    static int bfs(int x,int y){
        Queue<Point> queue=new LinkedList<>();
        List<Point> union=new ArrayList<>();

        queue.add(new Point(x,y));
        visited[x][y]=true;

        int sum=0;
        while (!queue.isEmpty()){
            Point point=queue.poll();
            int nowRow=point.row;
            int nowCol= point.col;
            union.add(new Point(nowRow,nowCol));
            sum+=map[nowRow][nowCol];
            for(int i=0;i<4;i++){
                int newRow=nowRow+dx[i];
                int newCol=nowCol+dy[i];
                if(isValid(newRow,newCol)&&!visited[newRow][newCol]&&isValid2(nowRow,nowCol,newRow,newCol)){
                    queue.add(new Point(newRow,newCol));
                    visited[newRow][newCol]=true;

                }
            }
        }
        if(union.size()>1){
            int avg=sum/union.size();
            for(Point p:union){
                map[p.row][p.col]=avg;
            }
        }
        return union.size();


    }

}
