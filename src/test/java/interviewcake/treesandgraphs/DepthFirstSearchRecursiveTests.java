package interviewcake.treesandgraphs;

import net.bencode.interviewcake.treesandgraphs.BinaryTreeNode;
import net.bencode.interviewcake.treesandgraphs.DepthFirstSearchRecursive;
import net.bencode.interviewcake.treesandgraphs.SuperBalanced;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DepthFirstSearchRecursiveTests {

    @Test
    public void fullTreeTest() {
        var root = new BinaryTreeNode(5);
        var a = root.insertLeft(8);
        var b = root.insertRight(6);
        a.insertLeft(1);
        a.insertRight(2);
        b.insertLeft(3);
        b.insertRight(4);
        final boolean result = DepthFirstSearchRecursive.search(root, 2);
        assertTrue(result);
    }
}
