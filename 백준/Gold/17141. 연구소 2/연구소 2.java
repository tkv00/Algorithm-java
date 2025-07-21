import java.io.*;
import java.util.*;
public class Main {
    private static class Node{
        int row;
        int col;

        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    //N : 연구소 크가  M : 바이러스 개수
    private static int N,M;
    private static StringTokenizer st;
    private static int[][] map;
    private static ArrayList<Node> virusPoint=new ArrayList<>();
    private static ArrayList<Node> selectedVirus=new ArrayList<>();
    private static int[][] copyMap;
    private static int[] dx=new int[]{0,0,1,-1};
    private static int[] dy=new int[]{1,-1,0,0};
    private static int time;
    private static int minTime=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());

                //바이러스를 놓을 수 있는 경우
                if(map[i][j]==2) virusPoint.add(new Node(i,j));
            }
        }

        DFS(0,0);

        System.out.print(minTime==Integer.MAX_VALUE ? -1 : minTime);
    }

    private static void BFS(ArrayList<Node> selected){
        copyMap=new int[N][N];
        Queue<Node> q=new LinkedList<>(selected);
        boolean[][] visited=new boolean[N][N];
        time=0;

        for(Node node:selected){
            q.offer(node);
            visited[node.row][node.col]=true;
        }

        while(!q.isEmpty()){
            Node now=q.poll();

            for(int i=0;i<4;i++){
                int newRow=now.row+dx[i];
                int newCol=now.col+dy[i];
                if(isValid(newRow,newCol) &&
                    map[newRow][newCol]!=1 &&
                        !visited[newRow][newCol]
                ){
                    copyMap[newRow][newCol]=copyMap[now.row][now.col]+1;
                    time=Math.max(time,copyMap[newRow][newCol]);
                    visited[newRow][newCol]=true;
                    q.offer(new Node(newRow,newCol));
                }
            }
        }
        if(isPossible(visited)){
            minTime=Math.min(time,minTime);
        }
    }

    private static boolean isValid(int row,int col){
        return row>=0 && row<N && col>=0 && col<N;
    }
    private static void DFS(int start,int count){
        if(count==M){
            BFS(selectedVirus);
            return;
        }

        for(int i=start;i<virusPoint.size();i++){
            selectedVirus.add(virusPoint.get(i));
            DFS(i+1,count+1);
            selectedVirus.remove(selectedVirus.size()-1);
        }
    }


    private static boolean isPossible(boolean[][] visited){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if((map[i][j]==0 || map[i][j]==2) && !visited[i][j]) return false;
            }
        }
        return true;
    }


}
