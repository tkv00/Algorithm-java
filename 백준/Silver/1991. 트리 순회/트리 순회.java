import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb_in=new StringBuilder();
    public static StringBuilder sb_post=new StringBuilder();
    public static StringBuilder sb_pre=new StringBuilder();
    public static class Node {
        char data;
        Node left;
        Node right;
        Node(char data){
            this.data=data;
            this.left=null;
            this.right=null;
        }

    }
    public static void inorder(Node node){
        if(node==null){
            return;
        }
        inorder(node.left);
        sb_in.append(node.data);
        inorder(node.right);

    }

    public static void postorder(Node node){
        if(node==null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        sb_post.append(node.data);

    }

    public static void preorder(Node node){
        if(node==null){
            return;
        }
        sb_pre.append(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        Node []tree=new Node[26];
        for(int i=0;i<26;i++){
            tree[i]=new Node((char)('A'+i));
        }
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            char parent,left,right;
            parent=st.nextToken().charAt(0);
            left=st.nextToken().charAt(0);
            right=st.nextToken().charAt(0);
           
            if(left!='.') tree[parent-'A'].left=tree[left-'A'];
            if(right!='.') tree[parent-'A'].right=tree[right-'A'];
        }

        preorder(tree[0]);
        inorder(tree[0]);
        postorder(tree[0]);

        System.out.println(sb_pre);
        System.out.println(sb_in);
        System.out.println(sb_post);

    }
}
