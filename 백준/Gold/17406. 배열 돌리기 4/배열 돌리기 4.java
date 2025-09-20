import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Point{
        int row;
        int col;

        Point(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    private static int[][] map;
    private static int N,M,K;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static boolean[] visited;
    private static int[][] orders;
    private static int result=Integer.MAX_VALUE;
    private static int getMinArray(int[][] arr){

        int min=Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=0;j<arr[0].length;j++){
                sum+=arr[i][j];
            }
            min=Math.min(min,sum);
        }

        return min;
    }

    private static int[][] operation(int[][]arr,Point p1,Point p2){
        //p1:좌상단 p2:우하단
        int rowCnt=arr.length;
        int colCnt=arr[0].length;

        int[][] copy=new int[rowCnt][colCnt];

        for(int i=0;i<rowCnt;i++){
            copy[i]= Arrays.copyOf(arr[i],colCnt);
        }


        int top=p1.row;
        int down=p2.row;
        int left=p1.col;
        int right=p2.col;

        while(top<=down && left<=right){
            List<Point> list=new ArrayList<>();
            List<Integer> values=new ArrayList<>();
            //위에 채우기
            for(int i=left;i<=right;i++){
                list.add(new Point(top,i));
                values.add(arr[top][i]);
            }

            //오른쪽 채우기
            for(int i=top+1;i<down;i++){
                list.add(new Point(i,right));
                values.add(arr[i][right]);
            }

            //아래 채우기
            for(int i=right;i>=left;i--){
                list.add(new Point(down,i));
                values.add(arr[down][i]);
            }

            //왼쪽 채우기
            for(int i=down-1;i>=top+1;i--){
                list.add(new Point(i,left));
                values.add(arr[i][left]);
            }

            Collections.rotate(values,1);

            for(int i=0;i<list.size();i++){
                Point now=list.get(i);
                copy[now.row][now.col]=values.get(i);
            }

            top++;
            down--;
            left++;
            right--;
        }

        return copy;
    }

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        map=new int[N][M];
        visited=new boolean[K];
        orders=new int[K][3];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            orders[i]=new int[]{r,c,s};

            //(r-s,c-s)  (r+s,c+s)
            Point startPoint=new Point(r-s-1,c-s-1);
            Point endPoint=new Point(r+s-1,c+s-1);

            int[][] arr=operation(map,startPoint,endPoint);
        }
    }

    private static void DFS(int depth,int[][] arr){
        if(depth==K){
            result=Math.min(result,getMinArray(arr));
            return;
        }

        for(int i=0;i<K;i++){
            if(!visited[i]){
                visited[i]=true;
                int[][] nextMap=operation(arr,
                        new Point(orders[i][0]-orders[i][2]-1,orders[i][1]-orders[i][2]-1),
                        new Point(orders[i][0]+orders[i][2]-1,orders[i][1]+orders[i][2]-1)
                );
                DFS(depth+1,nextMap);
                visited[i]=false;
            }
        }

    }
    
    public static void main(String[] args) throws IOException {
        init();
        DFS(0,map);
        System.out.print(result);
    }
}
