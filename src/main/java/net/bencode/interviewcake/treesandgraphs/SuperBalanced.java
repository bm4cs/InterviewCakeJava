package net.bencode.interviewcake.treesandgraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SuperBalanced {

    public static class NodeDepthPair {
        public BinaryTreeNode node;
        public int depth;

        public NodeDepthPair(BinaryTreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static boolean isBalanced(BinaryTreeNode treeRoot) {
//        return isBalancedIterative(treeRoot);
        depths.clear();
        return isBalancedRecursive(new NodeDepthPair(treeRoot, 0));
    }

    public static boolean isBalancedIterative(BinaryTreeNode treeRoot) {

        List<Integer> depthList = new ArrayList<>(3);

        Stack<NodeDepthPair> nodes = new Stack<>();
        nodes.push(new NodeDepthPair(treeRoot, 0));

        while (!nodes.empty()) {

            NodeDepthPair depthNodePair = nodes.pop();

            if (depthNodePair.node.left == null && depthNodePair.node.right == null) {
                if (!depthList.contains(depthNodePair.depth)) {
                    depthList.add(depthNodePair.depth);
                }

                if (depthList.size() > 2 ||
                        (depthList.size() == 2 && Math.abs(depthList.get(0) - depthList.get(1)) > 1)
                ) {
                    return false;
                }
            }

            if (depthNodePair.node.left != null) {
                nodes.push(new NodeDepthPair(depthNodePair.node.left, depthNodePair.depth + 1));
            }

            if (depthNodePair.node.right != null) {
                nodes.push(new NodeDepthPair(depthNodePair.node.right, depthNodePair.depth + 1));
            }
        }

        return true;
    }


    static List<Integer> depths = new ArrayList<>(3);

    public static boolean isBalancedRecursive(NodeDepthPair depthNodePair) {

        System.out.printf("DFS recursively scanning at node %d\n", depthNodePair.node.value);

        if (depthNodePair.node.left == null && depthNodePair.node.right == null) {
            if (!depths.contains(depthNodePair.depth)) {
                depths.add(depthNodePair.depth);
            }

            if (depths.size() > 2 ||
                    (depths.size() == 2 && Math.abs(depths.get(0) - depths.get(1)) > 1)
            ) {
                return false;
            }
        }

        if (depthNodePair.node.left != null) {
            if (!isBalancedRecursive(new NodeDepthPair(depthNodePair.node.left, depthNodePair.depth + 1))) {
                return false;
            }
        }

        if (depthNodePair.node.right != null) {
            if (!isBalancedRecursive(new NodeDepthPair(depthNodePair.node.right, depthNodePair.depth + 1))) {
                return false;
            }
        }

        return true;
    }
}
