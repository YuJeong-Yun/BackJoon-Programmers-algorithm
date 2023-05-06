import java.io.*;
import java.util.*;

class Tree {
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node findNode(Node node, char c) {
        if (root == null) {
            return null;
        }
        if (node.word == c) {
            return node;
        }

        Node find = null;
        if (node.left != null) {
            find = findNode(node.left, c);
        }
        if (find == null && node.right != null) {
            find = findNode(node.right, c);
        }
        return find;
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.word);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.word);
        inOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.word);
    }
}

class Node {
    char word;
    Node left, right;

    public Node(char word) {
        this.word = word;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Node root = new Node('A');
        Tree tree = new Tree(root);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            Node left = new Node(st.nextToken().charAt(0));
            Node right = new Node(st.nextToken().charAt(0));

            Node findNode = tree.findNode(root, c);
            if (left.word != '.') {
                findNode.left = left;
            }
            if (right.word != '.') {
                findNode.right = right;
            }
        }

        tree.preOrder(root);
        System.out.println();
        tree.inOrder(root);
        System.out.println();
        tree.postOrder(root);

        bw.flush();
        bw.close();
        br.close();
    }

}