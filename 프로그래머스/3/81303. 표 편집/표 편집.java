import java.util.*;

class Solution {
    private static final char UP='U';
    private static final char DOWN='D';
    private static final char DELETE='C';
    private static final char RESTORE='Z';
    private static class Node{
        Node prev=null;
        Node next=null;
        boolean deleted;
        Node moveDown(int cnt){
            Node now=this;
            for(int i=0;i<cnt;i++){
                now=now.next;
            }
            return now;
        }
        Node moveUp(int cnt){
            Node now=this;
            for(int i=0;i<cnt;i++){
                now=now.prev;
            }
            return now;
        }
        
        void restore(){
            this.deleted=false;
            Node prev=this.prev;
            Node next=this.next;
            
            if(prev!=null){
                prev.next=this;
            }
            if(next!=null){
                next.prev=this;
            }
        }
        
        
        Node delete(){
            this.deleted=true;
            Node prev=this.prev;
            Node next=this.next;
            
            if(prev!=null) prev.next=next;
            if(next!=null){
                 next.prev=prev;
                return next;
            }
            return prev;
        }
        
    }
    public String solution(int n, int k, String[] cmd) {
        Stack<Node> removedNode=new Stack<>();
        Node[] nodeList=new Node[n];
        
        for(int i=0;i<n;i++){
            nodeList[i]=new Node();
            if(i>0) {
                nodeList[i-1].next=nodeList[i];
                nodeList[i].prev=nodeList[i-1];    
            }
        }
        Node current=nodeList[k];
        
        for(String query:cmd){
            String[] orders=query.split(" ");
            char order=orders[0].charAt(0);
            
            switch(order){
                case UP:
                    current=current.moveUp(Integer.parseInt(orders[1]));
                    break;
                case DOWN:
                    current=current.moveDown(Integer.parseInt(orders[1]));
                    break;
                case DELETE:
                    removedNode.push(current);
                    current=current.delete();
                    break;
                case RESTORE:
                    Node node=removedNode.pop();
                    node.restore();
                    break;
            }
        }
        
        StringBuilder sb=new StringBuilder();
        for(Node node:nodeList){
            if(node.deleted) sb.append("X");
            else sb.append("O");
        }
        return sb.toString();
    }
}