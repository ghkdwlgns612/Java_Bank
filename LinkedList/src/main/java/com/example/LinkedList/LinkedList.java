package com.example.LinkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;
    private class Node {
        private Object data;
        private Object next;
        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public void addFirst(Object input) {
        Node newNode = new Node(input);

        newNode.next = head;
        head = newNode;
        size++;
        if(head.next == null){
            tail = head;
        }
    }

    public void addLast(Object input) {
        Node newNode = new Node(input);
        if (size == 0) {
            size++;
            addFirst(input);
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public Node node(int index) {
        Node x = head;
        for (int i=0;i < index;i++)
            x = (Node) x.next;
        return x;
    }

    public void add(int k, Object input) {
        if (k == 0){
            addFirst(input);
        } else {
            Node x = node(k - 1);
            Node x_next = (Node) x.next;
            Node newNode = new Node(input);
            x.next = newNode;
            newNode.next = x_next;
            size++;
            if (newNode.next == null)
                tail = newNode;
        }
    }

    public String toString() {
        String res = "";
        if (head == null)
            return "[]";
        Node start = head;
        res += "[";
        while(start.next != null) {
            res += start.data + " ,";
            start = (Node) start.next;
        }
        res += start.data;
        return res + "]";
    }

    public Object removeFirst(){
        Node node = head;
        head = (Node) node.next;
        size--;
        Object removeNode = node.data;
        node = null;
        return removeNode;
    }

    public Object remove(int k) {
        Node node = node(k - 1);
        Node todoDeleted = (Node) node.next;
        node.next = ((Node) node.next).next;
        Object returnData = todoDeleted.data;
        if (returnData == null)
            tail = node;
        todoDeleted = null;
        size--;
        return returnData;
    }

    public int size() {
        return size;
    }

    public Object get(int k) {
        Node res = node(k);
        return res.data;
    }

    public int indexOf(Object data) {
        Node temp = head;
        int index = 0;
        while(temp.data != data) {
            temp = (Node) temp.next;
            index++;
            if(temp == null)
                return -1;
        }
        return index;
    }

    public ListIterator listIterator() {
        return new ListIterator();
    }

    public class ListIterator {

        private LinkedList.Node next;
        private LinkedList.Node lastReturned;
        private int nextIndex;

        ListIterator() {
            next = head;
        }

        public Object next() {
            lastReturned = next;
            next = (LinkedList.Node) next.next;
            nextIndex++;
            return lastReturned.data;
        }

        public boolean hasNext() {
            return nextIndex < size();
        }

        public void add(Object input){
            LinkedList.Node newNode = new Node(input);
            if (lastReturned == null) {
                head = newNode;
                newNode.next = null;
            } else {
                lastReturned.next = newNode;
                newNode.next = next;
            }
            lastReturned = newNode;
            nextIndex++;
            size++;
        }

        public void remove() {
            if (nextIndex == 0) {
                throw new IllegalStateException();
            }
            LinkedList.this.remove(nextIndex-1);
            nextIndex--;
        }
    }
}
