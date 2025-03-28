import java.util.*;

class Solution {
    static class Node{
        Node left;
        Node right;
        int idx;
        int x;
        int y;
        
        Node(int x,int y,int idx){
            this.idx=idx;
            this.x=x;
            this.y=y;
            this.left=null;
            this.right=null;
        }
    }
    //전위순회 정답 배열
    private static int[][] result;
    private static int idx1=0;
    private static int idx2=0;
    
    private static void preorder(Node node){
        if(node==null) return;
        
        result[0][idx1++]=node.idx;
        preorder(node.left);
        preorder(node.right);
    }
    
    //후위순회 정답 배열
    private static void postorder(Node node){
        if(node==null) return;
        
        postorder(node.left);
        postorder(node.right);
        result[1][idx2++]=node.idx;
    }
    private static void makeBinaryTree(Node parent,Node child){
        if(parent.x>child.x){
            if(parent.left==null){
                parent.left=child;
            }else{
                makeBinaryTree(parent.left,child);
            }
        }
        else if(parent.x<child.x){
            if(parent.right==null){
                parent.right=child;
            }else{
                makeBinaryTree(parent.right,child);
            }
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        int size=nodeinfo.length;
        Node[] nodes=new Node[size];
        result = new int[2][size];
        int idx=1;
        for(int[] arr : nodeinfo){
            Node node = new Node(arr[0],arr[1],idx);
            nodes[idx-1]=node;
            idx++;
        }
        Arrays.sort(nodes,(o1,o2)->(o2.y==o1.y ? o1.x-o2.x : o2.y-o1.y));
        
        Node parent=nodes[0];
        for(int i=1;i<size;i++){
            makeBinaryTree(parent,nodes[i]);
        }
        
        preorder(nodes[0]);
        postorder(nodes[0]);
        
        return result;
    }
}