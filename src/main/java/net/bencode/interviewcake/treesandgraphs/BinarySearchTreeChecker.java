package net.bencode.interviewcake.treesandgraphs;

public class BinarySearchTreeChecker {

    public static boolean isBinarySearchTree(BinaryTreeNode root) {

        return isBinarySearchTreeRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBinarySearchTreeRecursive(BinaryTreeNode node, int lower, int upper) {

        if (node == null) {
            return true;
        }

        if (node.value < lower || node.value > upper) {
            return false;
        }

        return isBinarySearchTreeRecursive(node.left, lower, node.value)
            && isBinarySearchTreeRecursive(node.right, node.value, upper);
    }

}
