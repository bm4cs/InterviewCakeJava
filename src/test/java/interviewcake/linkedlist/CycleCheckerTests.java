package interviewcake.linkedlist;

import net.bencode.interviewcake.linkedlist.LinkedListNode;
import org.junit.Test;

import static net.bencode.interviewcake.linkedlist.CycleChecker.containsCycle;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CycleCheckerTests {


    @Test
    public void linkedListWithNoCycleTest() {
        final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[] {1, 2, 3, 4});
        final boolean result = containsCycle(nodes[0]);
        assertFalse(result);
    }

    @Test
    public void cycleLoopsToBeginningTest() {
        final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[] {1, 2, 3, 4});
        nodes[3].next = nodes[0];
        final boolean result = containsCycle(nodes[0]);
        assertTrue(result);
    }

    @Test
    public void cycleLoopsToMiddleTest()  {
        final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[] {1, 2, 3, 4, 5});
        nodes[4].next = nodes[2];
        final boolean result = containsCycle(nodes[0]);
        assertTrue(result);
    }

    @Test
    public void twoNodeCycleAtEndTest() {
        final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[] {1, 2, 3, 4, 5});
        nodes[4].next = nodes[3];
        final boolean result = containsCycle(nodes[0]);
        assertTrue(result);
    }

    @Test
    public void emptyListTest() {
        final boolean result = containsCycle(null);
        assertFalse(result);
    }

    @Test
    public void oneElementLinkedListNoCycleTest() {
        final LinkedListNode node = new LinkedListNode(1);
        final boolean result = containsCycle(node);
        assertFalse(result);
    }

    @Test
    public void oneElementLinkedListCycleTest() {
        final LinkedListNode node = new LinkedListNode(1);
        node.next = node;
        final boolean result = containsCycle(node);
        assertTrue(result);
    }

    private static LinkedListNode[] valuesToLinkedListNodes(int[] values) {
        final LinkedListNode[] nodes = new LinkedListNode[values.length];
        for (int i = 0; i < values.length; ++i) {
            nodes[i] = new LinkedListNode(values[i]);
            if (i > 0) {
                nodes [i - 1].next = nodes[i];
            }
        }
        return nodes;
    }
}
