package DataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class SortedBinaryTree<T extends Comparable<T>> {

    class Node<N extends Comparable<N>> {

        N value;
        Node<N> left, right;
        int height;

        public Node(N value) {
            this.value = value;
            this.height = 1;
        }

        public Node(N value, Node<N> left, Node<N> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public N getValue() {
            return this.value;
        }

    }

    class Traversal<R extends Comparable<R>> {

        private Node<R> root;

        public Traversal(Node<R> root) {
            this.root = root;
        }

        public void inorder() {
            inorder(this.root);
        }

        public void preorder() {
            preorder(this.root);
        }

        public void postorder() {
            postorder(this.root);
        }

        public void levelorder() {
            levelorder(this.root);
        }

        public void interval(R min, R max) {
            interval(this.root, min, max);
        }

        private void inorder(Node<R> node) {
            if (node != null) {
                inorder(node.left);
                System.out.println(node.getValue());
                inorder(node.right);
            }
        }

        private void preorder(Node<R> node) {
            if (node != null) {
                System.out.println(node.getValue());
                preorder(node.left);
                preorder(node.right);
            }
        }

        private void postorder(Node<R> node) {
            if (node != null) {
                postorder(node.left);
                postorder(node.right);
                System.out.println(node.getValue());
            }
        }

        private void levelorder(Node<R> node) {
            Queue<Node<R>> queue = new LinkedList<Node<R>>();
            if (node != null) {
                queue.add(node);
            }
            while (!queue.isEmpty()) {
                node = queue.remove();
                System.out.println(node.getValue());
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        private void interval(Node<R> node, R min, R max) {
            if (node != null) {
                if (0 > node.getValue().compareTo(min)) {
                    interval(node.right, min, max);
                } else if (0 < node.getValue().compareTo(max)) {
                    interval(node.left, min, max);
                } else {
                    System.out.println(node.getValue());
                    interval(node.left, min, max);
                    interval(node.right, min, max);
                }
            }
        }

    }

    private Node<T> root;

    public void add(T x) {
        this.root = insertAt(this.root, x);
    }

    public T remove(T x) {
        Node<T> removed = new Node<T>(null);
        this.root = removeAt(this.root, x, removed);
        return removed.getValue();
    }

    public int height() {
        return calcHeight(this.root);
    }

    public int size() {
        return calcSize(this.root);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public Traversal<T> traversal() {
        return new Traversal<T>(this.root);
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        if (root.right != null) {
            printTree(root.right, out, true, "");
        }
        out.append(root.value + "\n");
        if (root.left != null) {
            printTree(root.left, out, false, "");
        }
        return out.toString();
    }

    private Node<T> insertAt(Node<T> node, T x) {
        if (node == null) {
            return new Node<T>(x);
        } else {
            if (x.compareTo(node.getValue()) <= 0) {
                node.left = insertAt(node.left, x);
            } else {
                node.right = insertAt(node.right, x);
            }
            return node;
        }
    }

    private Node<T> findReplaceAt(Node<T> node, Node<T> replacement) {
        if (node.right != null) {
            node.right = findReplaceAt(node.right, replacement);
        } else {
            replacement.value = node.value;
            node = node.left;
        }
        return node;
    }

    private Node<T> removeAt(Node<T> node, T x, Node<T> removed) {
        if (node == null) {
            return null;
        } else {
            if (x.compareTo(node.getValue()) == 0) {
                removed.value = node.value;
                if (node.left == null) {
                    node = node.right;
                } else if (node.right == null) {
                    node = node.left;
                } else {
                    node.left = findReplaceAt(node.left, node);
                }
            } else if (x.compareTo(node.getValue()) < 0) {
                node.left = removeAt(node.left, x, removed);
            } else {
                node.right = removeAt(node.right, x, removed);
            }
            return node;
        }
    }

    private int calcHeight(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(calcHeight(node.left), calcHeight(node.right));
        }
    }

    private int calcSize(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + calcSize(node.left) + calcSize(node.right);
        }
    }

    private void printTree(Node<T> node, StringBuilder out, boolean isRight, String indent) {
        if (node.right != null) {
            printTree(node.right, out, true,
                    indent + (isRight ? "        " : " |      "));
        }
        out.append(indent);
        if (isRight) {
            out.append(" /");
        } else {
            out.append(" \\");
        }
        out.append("----- ");
        out.append(node.value + "\n");
        if (node.left != null) {
            printTree(node.left, out, false,
                    indent + (isRight ? " |      " : "        "));
        }
    }

    public static void main(String[] args) {
        SortedBinaryTree<Integer> tree = new SortedBinaryTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(8);
        tree.add(17);
        tree.add(12);
        tree.add(1);
        tree.add(9);
        tree.add(11);
        System.out.println(tree.toString());
        SortedBinaryTree<Integer>.Traversal<Integer> traversal = tree.traversal();
        traversal.inorder();
    }
}
