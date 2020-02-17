package net.bencode.interviewcake.treesandgraphs;

public class SecondLargestItemInBST {

    public static int findSecondLargest(BinaryTreeNode rootNode) {

        //TODO: test edge cases.

        BinaryTreeNode currentNode = rootNode;

        while (true) {
            // case 1: at the largest, which has a left subtree
            if (currentNode.right == null && currentNode.left != null) {
                return findLargest(currentNode.left);
            }

            // case 2: at the parent of the largest, which has no left subtree
            if (currentNode.right != null
                && currentNode.right.left == null
                && currentNode.right.right == null) {
                return currentNode.value;
            }

            currentNode = currentNode.right;
        }

//        return 0;
    }

    // TODO: change this to an iterative implementation (recursive piles O(h) stack frames, needlessly blowing out space complexity)
    private static int findLargest(BinaryTreeNode node) {
        if (node.right != null) {
            return findLargest(node.right);
        }
        return node.value;
    }

}
