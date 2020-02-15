package net.bencode.interviewcake.treesandgraphs;


public class DepthFirstSearchRecursive {

    public static boolean search(BinaryTreeNode node, int needle) {

        System.out.printf("Searching node %d\n", node.value);

        if (node.value == needle) {
            System.out.println("The needle has been acquired");
            return true;
        }

        if (node.left != null) {
            if (search(node.left, needle)) {
                return true;
            }
        }

        if (node.right != null) {
            if (search(node.right, needle)) {
                return true;
            }
        }

        return false;
    }
}
