package LinkList;

import java.util.Iterator;

/**
 *
 * @author StarLeaf-Roxy
 * @since 2026/9/30
 */
public class DoubleLinkedListSentinel implements Iterable<Integer>{
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null, -1, null);

    public DoubleLinkedListSentinel() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    // 添加第一个
    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    // 添加最后一个
    public void addLast(int value) {
        Node a = sentinel.prev; // 头哨兵
        Node b = sentinel; // 尾哨兵
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    // 删除第一个
    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node a = sentinel;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    // 删除最后一个
    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node a = removed.prev;
        Node b = sentinel;
        a.next = b;
        b.prev = a;
    }

    // 根据值删除
    public void removeByValue(int value) {
        Node removed = findByValue(value);
        if (removed == null) {
            return; // 不用删
        }

        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    public Node findByValue(int value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
}
