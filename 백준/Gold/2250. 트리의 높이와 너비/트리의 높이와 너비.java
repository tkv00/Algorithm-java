import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //행 - depth
    //열 0열 - 각 레벨별 최소 열 /  1열 -  각 레벨별 최대 열
    private static int[][] arr;
    private static boolean[] isChild;
    private static class Node{
        int index;
        Node left;
        Node right;
        int row;
        int col;

        Node(int index){
            this.index=index;
            this.left=null;
            this.right=null;
            this.row=0;
            this.col=0;
        }

        void addLeft(Node node){
            if(left==null) this.left=node;
        }

        void addRight(Node node){
            if(right==null) this.right=node;
        }

        int getData(){
            return this.index;
        }

        void setRow(int row){
            this.row=row;
        }

        void setCol(int col){
            this.col=col;
        }
    }

    private static void buildTree() throws IOException {
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            int parent=Integer.parseInt(st.nextToken());
            int left=Integer.parseInt(st.nextToken());
            int right=Integer.parseInt(st.nextToken());

            if(tree[parent]==null){
                tree[parent]=new Node(parent);
            }

            if(left!=-1){
                if(tree[left]==null) tree[left]=new Node(left);
                tree[parent].addLeft(tree[left]);
                isChild[left]=true;
            }
            if(right!=-1){
                if(tree[right]==null) tree[right]=new Node(right);
                tree[parent].addRight(tree[right]);
                isChild[right]=true;
            }
        }
    }

    //레벨 넓이 측정
    private static void DFS(Node now,int depth){
        //중위 순화
        if(now!=null) {
            DFS(now.left,depth+1);

            now.setRow(depth);
            now.setCol(colIndex);
            colIndex++;
            maxDepth=Math.max(maxDepth,depth);

            DFS(now.right,depth+1);
        }
    }

    private static int colIndex;
    private static Node[] tree;
    private static int N;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int maxDepth;
    private static int maxWidth;

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        tree=new Node[N+1];
        isChild=new boolean[N+1];
        colIndex=1;
        maxDepth=0;
        maxWidth=0;
    }
    public static void main(String[] args) throws IOException {
        init();
        buildTree();

        //루트 노드 찾기
        int root=-1;
        for(int i=1;i<=N;i++){
            if(tree[i]!=null && !isChild[i]){
                root=i;
                break;
            }
        }
        DFS(tree[root],1);

        arr=new int[maxDepth+1][2];
        for(int i=1;i<=maxDepth;i++){
            arr[i][0]=Integer.MAX_VALUE;
            arr[i][1]=Integer.MIN_VALUE;
        }

        for(int i=1;i<=N;i++){
            //최솟값
            arr[tree[i].row][0]=Math.min(arr[tree[i].row][0],tree[i].col);
            //최댓값
            arr[tree[i].row][1]=Math.max(arr[tree[i].row][1],tree[i].col);

            maxWidth=Math.max(arr[tree[i].row][1]-arr[tree[i].row][0]+1,maxWidth);
        }


        for(int i=1;i<=maxDepth;i++){
            if(arr[i][1]-arr[i][0]+1 == maxWidth){
                System.out.print(i + " "+ maxWidth);
                return;
            }
        }

    }
}