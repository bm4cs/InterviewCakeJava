package net.bencode.interviewcake.linkedlist;

public class ReverseLinkedList {


    public static LinkedListNode reverseIteratively(LinkedListNode head) {

        LinkedListNode currentNode = head;
        LinkedListNode nextNode;
        LinkedListNode previousNode = null;

        while (currentNode != null) {

            nextNode = currentNode.next;

            // mutate
            currentNode.next = previousNode;

            // move forward
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }


    public static LinkedListNode reverseRecursive(LinkedListNode head) {

        // recursive recipe
        // 1. break condition
        // 2. do the work
        // 3. recurse call
        // 4. evaluation work

        if (head == null)
            return null;

        var newHead = _reverseRecursively(head, null);
        head.next = null;
        return newHead;
    }


    private static LinkedListNode _reverseRecursively(LinkedListNode currentNode, LinkedListNode previousNode) {

        // the old tail
        if (currentNode.next == null) {
            currentNode.next = previousNode;
            return currentNode;
        }

        var originalNext = currentNode.next;

        if (previousNode != null) {
            currentNode.next = previousNode;
        }

        return _reverseRecursively(originalNext, currentNode);
    }


}
