import java.util.*;

class Solution {
    static class Node {
        int x, y, num;
        Node left, right;

        Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    List<Integer> preorderList = new ArrayList<>();
    List<Integer> postorderList = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }

        nodes.sort((a, b) -> {
            if (a.y == b.y) {
                return a.x - b.x;
            }
            return b.y - a.y;
        });

        Node root = nodes.get(0);

        for (int i = 1; i < nodes.size(); i++) {
            insert(root, nodes.get(i));
        }

        preorder(root);
        postorder(root);

        int[][] answer = new int[2][nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = preorderList.get(i);
            answer[1][i] = postorderList.get(i);
        }

        return answer;
    }

    void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }

    void preorder(Node node) {
        if (node == null)
            return;

        preorderList.add(node.num);
        preorder(node.left);
        preorder(node.right);
    }

    void postorder(Node node) {
        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        postorderList.add(node.num);
    }
}