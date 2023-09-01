package src;

public class List1 {
    private Node head;

    private class Node {
        private Node next;
        private int value;
    }
    public void addFirst(int value){
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void removeFirst(){
        if (head != null){
            head = head.next;
        }
    }

    public boolean contains(int value){
        Node node = head;
        while (node != null){
            if (node.value == value){
                return true;
            }
            node = node.next;
        }
        return false;
    }
    public void addLast(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
    }


    public void removeLast() {
        if (head != null) {
            Node node = head;
            while (node.next != null) {
                if (node.next.next == null) {
                    node.next = null;
                    return;
                }
                node = node.next;
            }
            head = null;
        }
    }
}
