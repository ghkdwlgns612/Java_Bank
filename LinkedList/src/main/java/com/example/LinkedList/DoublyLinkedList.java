package com.example.LinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;
    private class Node {
        private Object data;
        private Node next;
        private Node prev;

        public Node(Object input) {
            this.data = input;
            this.next = null;
            this.prev = null;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public void addFirst(Object input) {
        Node newNode = new Node(input);
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        head = newNode;
        size++;
        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(Object input) {
        Node newNode = new Node(input);
        if (size == 0) {
            addFirst(input);
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    public Node node(int index) {
        if (index < size / 2) {
            Node x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public void add(int k, Object input) {
        Node prevNode = node(k-1);
        Node nextNode = prevNode.next;
        Node newNode = new Node(input);
        prevNode.next = newNode;
        newNode.next = nextNode;
        if (nextNode != null)
            nextNode.prev = newNode;
        newNode.prev = prevNode;
        size++;
        if (newNode.next == null)
            tail = newNode;
    }
    public Object removeFirst() {
        // 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경합니다.
        Node temp = head;
        head = temp.next;
        // 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담습니다.
        Object returnData = temp.data;
        temp = null;
        // 리스트 내에 노드가 있다면 head의 이전 노드를 null로 지정합니다.
        if (head != null)
            head.prev = null;
        size--;
        return returnData;
    }

    public Object remove(int k) {
        if (k == 0)
            return removeFirst();
        Node temp = node(k - 1);
        Node todoDeleted = temp.next;
        temp.next = temp.next.next;
        if (temp.next != null) {
            temp.next.prev = temp;
        }
        Object returnData = todoDeleted.data;
        if (todoDeleted == tail) {
            tail = temp;
        }
        todoDeleted = null;
        size--;
        return returnData;
    }
    public Object removeLast() {
        return remove(size - 1);
    }
    public Object get(int k) {
        Node temp = node(k);
        return temp.data;
    }
    public int indexOf(Object data) {
        Node temp = head;
        int index = 0;
        while (temp.data != data) {
            temp = temp.next;
            index++;
            if (temp == null)
                return -1;
        }
        return index;
    }
    public class ListIterator {
        private Node next;
        private Node lastReturned;
        private int nextIndex;
        ListIterator() {
            next = head;
        }

        public Object next() {
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public Object previous() {
            if (next == null)
                lastReturned = next = tail;
            else
                lastReturned = next = next.prev;
            nextIndex--;
            return lastReturned.data;
        }

        public void add(Object input) {
            Node newNode = new Node(input);
            if (lastReturned == null) {
                head = newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.prev = lastReturned;
                if (next != null) {
                    newNode.next = next;
                    next.prev = newNode;
                } else {
                    tail = newNode;
                }
            }
            lastReturned = newNode;
            nextIndex++;
            size++;
        }

        public void remove() {
            if(nextIndex==0)
                throw new IllegalStateException();
            Node pre = lastReturned.prev;
            Node nex = lastReturned.next;

            if(pre == null) {
                head = nex;
                head.prev = null;
                lastReturned = null;
            } else {
                pre.next = nex;
                lastReturned.prev = null;
            }

            if(nex == null) {
                tail = pre;
                tail.next = null;
            } else {
                nex.prev = pre;
            }

            if (next == null)
                lastReturned = tail;
            else
                lastReturned = next.prev;
            size--;
            nextIndex--;
        }
    }
}
