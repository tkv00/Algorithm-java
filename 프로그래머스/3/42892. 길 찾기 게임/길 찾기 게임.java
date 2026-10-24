import java.util.*;
import java.io.*;

class Solution {
    static class Node{
        int x;
        int y;
        int idx;
        Node left;
        Node right;
        
        Node(int x,int y,int idx){
            this.x=x;
            this.y=y;
            this.idx=idx;
            this.left = null;
            this.right = null;
        }
        
        void addNode(Node node){
            //왼쪽
            if(node.x < this.x){
                if(this.left==null) this.left = node;
                else{
                    this.left.addNode(node);
                }
            }
            //오른쪽
            else{
                if(this.right==null) this.right=node;
                else{
                    this.right.addNode(node);
                }
            }
        }

        @Override
        public String toString(){
            return "x="+x+" y="+y+" id="+idx;
        }
    }
    static List<Node> nodes;
    static Node root;
    static int preIdx;
    
    static void preorder(Node node){
        if(node == null) return;
        
        preArr[preIdx++] = node.idx;
        preorder(node.left);
        preorder(node.right);
    }
    
    static void postorder(Node node){
        if(node == null) return;
        
        postorder(node.left);
        postorder(node.right);
        postArr[preIdx++]=node.idx;
    }
    
    static int[] preArr;
    static int[] postArr;
    
    public int[][] solution(int[][] nodeinfo) {
        nodes = new ArrayList<>();
        int idx=1;
        
        for(int[] info:nodeinfo){
            nodes.add(new Node(info[0],info[1],idx++));
        }
        
        preArr = new int[nodes.size()];
        postArr = new int[nodes.size()];
        
        nodes.sort((a,b)->{
            return b.y-a.y;
        });
        
        root = nodes.get(0);
        
        for(int i=1;i<nodes.size();i++){
            root.addNode(nodes.get(i));
        }
        
        preIdx=0;
        preorder(root);
        preIdx=0;
        postorder(root);
        
        return new int[][]{preArr,postArr};
    }
}