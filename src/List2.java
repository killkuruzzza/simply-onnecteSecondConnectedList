package src;

public class List2 {
    private Node head;
    private Node tail;

    private class Node {
        private Node next;

        private Node prev;

        private int value;
    }
    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
            head.prev = node;
        } else {
            tail = node;
        }
        head = node;
    }

    public void removeFirst() {
        if (head != null && head.next != null) {
            head.next.prev = null;
            head = head.next;
        } else  {
            head = null;
            tail = null;
        }
    }

    public void addLast(int value) {
        Node node = new Node();
        node.value = value;
        if (tail != null) {
            node.prev = tail;
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
    }

    public void removeLast() {
        if (tail != null && tail.prev != null) {
            tail.prev.next = null;
            tail = tail.prev;
        } else  {
            head = null;
            tail = null;
        }
    }
    public void sort() {
        boolean needSort;
        do {
            needSort = false;
            Node node = head;
            while (node != null && node.next != null){
                if (node.value > node.next.value){
                    Node before = node.prev;
                    Node after = node.next.next;
                    Node current = node;
                    Node next = node.next;

                    current.next = after;
                    current.prev = next;
                    next.next = current;
                    next.prev = before;
                    if (before != null){
                        before.next = next;
                    } else {
                        head = next;
                    }
                    if (after != null) {
                        after.prev = current;
                    } else  {
                        tail = current;
                    }

                    needSort = true;
                }
                node = node.next;
            }
        } while (needSort);
    }
}
