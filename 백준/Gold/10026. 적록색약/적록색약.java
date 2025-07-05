import java.util.*;
import java.io.*;
public class Main {
    private static char[][] map;
    private static int N;

    private static Queue<Node> colorQ=new LinkedList<>();
    private static Queue<Node> nonColorQ=new LinkedList<>();
    private static int cnt;
    private static int nonCnt;
    private static boolean[][] visited;
    private static boolean[][] visitedNonColor;
    private static int[] dx=new int[]{0,0,1,-1};
    private static int[] dy=new int[]{1,-1,0,0};
    private static boolean isValid(int row,int col){
        return row>=0 && row<N && col>=0 && col<N ;
    }
    private static boolean sameColor(int row,int col,int newRow,int newCol){
        char nowColor=map[row][col];
        char nextColor=map[newRow][newCol];
        return nowColor==nextColor||
                (nowColor=='R' && nextColor=='G') ||
                (nowColor=='G' && nextColor=='R');
    }
    private static class Node{
        int row;
        int col;
        char color;
        Node(int row,int col,char color){
            this.row=row;
            this.col=col;
            this.color=color;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new char[N][N];
        for(int i=0;i<N;i++){
            String str=br.readLine();
            map[i]=str.toCharArray();
        }
        visited=new boolean[N][N];
        visitedNonColor=new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                //적록 색약이 아닌 경우
                if(!visited[i][j]){
                    colorQ.offer(new Node(i,j,map[i][j]));
                    visited[i][j]=true;
                    while(!colorQ.isEmpty()){
                        Node now=colorQ.poll();
                        for(int k=0;k<4;k++){
                            int newRow=now.row+dx[k];
                            int newCol=now.col+dy[k];
                            if(isValid(newRow,newCol)&&
                                    !visited[newRow][newCol] &&
                                    (map[newRow][newCol]==map[now.row][now.col])){
                                colorQ.offer(new Node(newRow,newCol,map[newRow][newCol]));
                                visited[newRow][newCol]=true;
                            }
                        }
                    }
                    cnt++;
                }

                //적록 색약인 경우
                if(!visitedNonColor[i][j]){
                    nonColorQ.offer(new Node(i,j,map[i][j]));
                    visitedNonColor[i][j]=true;
                    while(!nonColorQ.isEmpty()){
                        Node now=nonColorQ.poll();
                        for(int k=0;k<4;k++){
                            int newRow=now.row+dx[k];
                            int newCol=now.col+dy[k];
                            if(isValid(newRow,newCol)&&
                                !visitedNonColor[newRow][newCol]&&
                                    sameColor(now.row,now.col,newRow,newCol)
                            ){
                                nonColorQ.offer(new Node(newRow,newCol,map[newRow][newCol]));
                                visitedNonColor[newRow][newCol]=true;
                            }
                        }
                    }
                    nonCnt++;
                }
            }
        }
        System.out.print(cnt+" "+nonCnt);

    }
}
