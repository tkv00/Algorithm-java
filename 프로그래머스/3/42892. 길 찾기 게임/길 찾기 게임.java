import java.util.*;

class Solution {
    private static class Node{
        Node left;
        Node right;
        int index;
        int x;
        int y;
        
        Node(int index,int x,int y){
            this.index=index;
            this.x=x;
            this.y=y;
            this.left=null;
            this.right=null;
        }
        
        private void addLeft(Node node){
            this.left=node;
        }
        
        private void addRight(Node node){
            this.right=node;
        }
        
        private int getIndex(){
            return this.index;
        }
    }
    private static void buildTree(Node parent,Node child){
        if(child.y >= parent.y) return;
        
        //왼쪽 자식
        if(child.x<parent.x){
            if(parent.left==null) parent.addLeft(child);
            else buildTree(parent.left,child);
        }
        
        //오른쪽 자식
        if(child.x>parent.x ){
            if(parent.right==null) parent.addRight(child);
            else buildTree(parent.right,child);
        }
    }
    
    //전위 순회
    private static void preOrder(int depth,Node node){
        if(node==null) return;
        pre[preIdx++]=node.index;
        preOrder(depth+1,node.left);
        preOrder(depth+1,node.right);
    }
    
    //후위 순회
    private static void postOrder(int depth,Node node){
        if(node==null) return;
        postOrder(depth+1,node.left);
        postOrder(depth+1,node.right);
        post[postIdx++]=node.index;
    }
    
    private static Node[] nodes;
    private static Node root;
    private static int[] pre; //전위 순회
    private static int[] post; //후위 순회
    private static int preIdx;
    private static int postIdx;
    public int[][] solution(int[][] nodeinfo) {
        nodes=new Node[nodeinfo.length];
        preIdx=0;
        postIdx=0;
        
        for(int i=0;i<nodeinfo.length;i++){
            nodes[i]=new Node(i+1,nodeinfo[i][0],nodeinfo[i][1]);
        }
        
        pre=new int[nodeinfo.length];
        post=new int[nodeinfo.length];
        
        Arrays.sort(nodes,(a,b)->a.y==b.y ? a.x-b.x : b.y-a.y);
        root=nodes[0];
        
        for(int i=1;i<nodeinfo.length;i++){
            buildTree(root,nodes[i]);
        }
        
        preOrder(0,root);
        postOrder(0,root);
        
        return new int[][]{pre,post};
       
    }
}