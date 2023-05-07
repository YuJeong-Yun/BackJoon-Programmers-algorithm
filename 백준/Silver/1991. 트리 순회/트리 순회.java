
import java.io.*;
import java.util.*;

class Tree {
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node findNode(Node node, char c) { // 해당 문자 가진 노드 찾는 함수
        if (root == null) {
            return null;
        }
        if (node.word == c) {
            return node;
        }

        Node find = null;
        if (node.left != null) { // 왼쪽 자식 있으면 왼쪽 서브 트리 탐색해서 찾음
            find = findNode(node.left, c);
        }
        if (find == null && node.right != null) { // 왼쪽 탐색 결과 null이고 오른쪽 자식 있으면 오른쪽 서브 트리 탐색
            find = findNode(node.right, c);
        }
        return find;
    }

    public void add(char p, char l, char r) {
        Node parent = findNode(root, p);
        if (l != '.') {
            parent.left = new Node(l);
        }
        if (r != '.') {
            parent.right = new Node(r);
        }

    }

    public void preOrder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append(node.word);
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    public void inOrder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        inOrder(node.left, sb);
        sb.append(node.word);
        inOrder(node.right, sb);
    }

    public void postOrder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.word);
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
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node root = new Node('A');
        Tree tree = new Tree(root);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            tree.add(c, l, r);
        }

        tree.preOrder(root, sb);
        sb.append("\n");
        tree.inOrder(root, sb);
        sb.append("\n");
        tree.postOrder(root, sb);

        System.out.println(sb.toString());
        br.close();
    }

}