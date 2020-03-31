package net.bencode.interviewcake.linkedlist;

public class CycleChecker {

    public static boolean containsCycle(LinkedListNode firstNode) {

        // check if the linked list contains a cycle

        LinkedListNode slowRunner = firstNode;
        LinkedListNode fastRunner = firstNode;

        while (fastRunner != null && fastRunner.next != null) {

            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            if (slowRunner == fastRunner) {
                return true;
            }
        }

        return false;
    }


}
