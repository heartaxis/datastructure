package com.ds.v3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    public TreeNode left, right;
    public int data;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Tree {

    static TreeNode prev = null;
    static TreeNode head;

    public void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + "  ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void preorderNonRec(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr = null;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            System.out.print(curr.data + " ");

            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + "  ");
            inorder(root.right);
        }
    }

    public void inorderNonRec(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    public void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void postorderNonRec(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode temp = stack1.pop();
            stack2.push(temp);

            if (temp.left != null)
                stack1.push(temp.left);
            if (temp.right != null)
                stack1.push(temp.right);
        }

        while (!stack2.isEmpty()) {
            TreeNode temp = stack2.pop();
            System.out.print(temp.data + " ");
        }
    }


    public void insert(TreeNode root, int data) {
        if (data < root.data) {
            if (root.left != null) {
                insert(root.left, data);
            } else {
                root.left = new TreeNode(data);
                System.out.println(data + " inserted left");
            }
        } else {
            if (root.right != null) {
                insert(root.right, data);
            } else {
                root.right = new TreeNode(data);
                System.out.println(data + " inserted right");
            }
        }
    }

    public void insertNoRec(TreeNode root, int data) {
        TreeNode newNode = new TreeNode(data);
        TreeNode curr = root;
        TreeNode temp = null;

        while (curr != null) {
            temp = curr;
            if (data < curr.data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if (temp == null) {
            temp = newNode;
        } else if (data < temp.data) {
            temp.left = newNode;
            System.out.println(data + " inserted left");
        } else {
            temp.right = newNode;
            System.out.println(data + " inserted right");
        }
    }

    public int findMax(TreeNode root) {
        int max = root.data;

        if (root.left != null) {
            max = Math.max(max, findMax(root.left));
        }

        if (root.right != null) {
            max = Math.max(max, findMax(root.right));
        }
        return max;
    }

    public int findMaxNonRec(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = root.data;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (temp.data > max)
                max = temp.data;
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        return max;
    }

    public int findMin(TreeNode root) {
        int min = root.data;

        if (root.left != null) {
            min = Math.min(min, findMin(root.left));
        }

        if (root.right != null) {
            min = Math.min(min, findMin(root.right));
        }
        return min;
    }

    public int findMinNonRec(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int min = root.data;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (temp.data < min)
                min = temp.data;
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        return min;
    }

    public boolean isNodeExists(TreeNode root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;

        boolean res1 = isNodeExists(root.left, key);

        boolean res2 = isNodeExists(root.right, key);

        return res1 || res2;
    }

    public boolean isNodeExistsNonRec(TreeNode root, int key) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (temp.data == key)
                return true;
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        return false;
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int lDepth = height(root.left);
            int rDepth = height(root.right);

            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public int heightNonRec(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int height = 0;

        while (true) {
            int nodeCount = q.size();
            if (nodeCount == 0)
                return height;
            height++;

            while (nodeCount > 0) {
                TreeNode newnode = q.remove();
                if (newnode.left != null)
                    q.add(newnode.left);
                if (newnode.right != null)
                    q.add(newnode.right);
                nodeCount--;
            }
        }
    }

    public TreeNode lca(TreeNode root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        TreeNode left = lca(root.left, n1, n2);
        TreeNode right = lca(root.right, n1, n2);

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public void zigzagTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                root = s1.pop();
                System.out.print(root.data + " ");
                if (root.left != null) {
                    s2.push(root.left);
                }
                if (root.right != null) {
                    s2.push(root.right);
                }
            }
            while (!s2.isEmpty()) {
                root = s2.pop();
                System.out.print(root.data + " ");
                if (root.right != null) {
                    s1.push(root.right);
                }
                if (root.left != null) {
                    s1.push(root.left);
                }
            }
        }
    }

    public void btt2dll(TreeNode root) {
        if (root == null)
            return;

        btt2dll(root.left);

        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        btt2dll(root.right);
    }

    public void printList(TreeNode root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);
        Tree tree = new Tree();
        tree.insertNoRec(root, 20);
        tree.insertNoRec(root, 4);
        tree.insertNoRec(root, 124);
        tree.insertNoRec(root, 432);
        tree.insertNoRec(root, 49);

        System.out.println("");
        //  tree.preorder(root);
        tree.preorderNonRec(root);
        System.out.println("-----100  20  4  49  124  432-----");
        //   tree.inorder(root);
        tree.inorderNonRec(root);
        System.out.println("-----4  20  49  100  124  432-----");
        // tree.postorder(root);
        tree.postorderNonRec(root);
        System.out.println("-----4  49  20  432  124  100-----");
        System.out.println(tree.findMax(root));
        System.out.println(tree.findMaxNonRec(root));
        System.out.println(tree.findMin(root));
        System.out.println(tree.findMinNonRec(root));
        System.out.println(tree.isNodeExists(root, 100));
        System.out.println(tree.isNodeExistsNonRec(root, 42));
        System.out.println(tree.height(root));
        System.out.println(tree.heightNonRec(root));
        System.out.println(tree.lca(root, 4, 432).data);
        tree.zigzagTraversal(root);
        tree.btt2dll(root);
        System.out.println("");

        tree.printList(head);

    }

}
