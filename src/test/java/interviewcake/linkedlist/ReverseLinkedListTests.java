package interviewcake.linkedlist;

import net.bencode.interviewcake.linkedlist.LinkedListNode;
import net.bencode.interviewcake.linkedlist.ReverseLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListTests {

    @Test
    public void GivenAThreeNodeSinglyLinkedListWhenReversedRecursivelyThenTheNodesGetRelinkedInReverseOrder() {
        var node1 = new LinkedListNode(1);
        var node2 = new LinkedListNode(2);
        var node3 = new LinkedListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        var head = ReverseLinkedList.reverseRecursive(node1);
        Assert.assertSame(node3, head);
        Assert.assertSame(node2, head.next);
        Assert.assertSame(node1, head.next.next);
    }

    // edge case
    @Test
    public void GivenAnEmptyListWhenReversedRecursivelyThenNothingIsDone() {
        var head = ReverseLinkedList.reverseRecursive(null);
        Assert.assertNull(head);
    }

    // edge case
    @Test
    public void GivenASingleElementListWhenReversedRecursivelyThenAlgorithmDoesntHaveAHeartAttack() {
        var node1 = new LinkedListNode(1);
        var head = ReverseLinkedList.reverseRecursive(node1);
        Assert.assertSame(node1, head);
    }


    @Test
    public void GivenAThreeNodeSinglyLinkedListWhenReversedIterativelyThenTheNodesGetRelinkedInReverseOrder() {
        var node1 = new LinkedListNode(1);
        var node2 = new LinkedListNode(2);
        var node3 = new LinkedListNode(3);
//iteravly
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        var head = ReverseLinkedList.reverseIteratively(node1);
        Assert.assertSame(node3, head);
        Assert.assertSame(node2, head.next);
        Assert.assertSame(node1, head.next.next);
    }

    // edge case
    @Test
    public void GivenAnEmptyListWhenReversedIterativelyThenNothingIsDone() {
        var head = ReverseLinkedList.reverseIteratively(null);
        Assert.assertNull(head);
    }

    // edge case
    @Test
    public void GivenASingleElementListWhenReversedIterativelyThenAlgorithmDoesntHaveAHeartAttack() {
        var node1 = new LinkedListNode(1);
        var head = ReverseLinkedList.reverseIteratively(node1);
        Assert.assertSame(node1, head);
    }
}
