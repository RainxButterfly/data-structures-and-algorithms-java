package LinkList;

/**
 *
 * @author StarLeaf-Roxy
 * @since 2026/9/29
 */

import java.util.Iterator;

// 双向链表
public class DoubleLinkedList implements Iterable<Integer> {
    static class Node {
        Node prev; // 上一个节点指针
        int value; // 值
        Node next; // 下一个节点指针

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head; // 头指针
    private Node tail; // 尾指针

    public DoubleLinkedList() {
        head = new Node(null, 666, null);
        tail = new Node(null, 888, null);
        head.next = tail;
        tail.prev = head;
    }

    public Node findNode(int index) {
        int i = -1; // 从头哨兵开始
        for (Node p = head; p != tail; p = p.next, i ++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public void addFirst(int value) {
        insert(0, value);
    }

    public void removeFirst() {
        remove(0);
    }

    public void addLast(int value) {
        Node last = tail.prev;
        Node added = new Node(last, value, tail);
        last.next = added;
        tail.prev = added;
    }

    public void removeLast(int value) {
        Node removed = tail.prev;
        // 如果里面没有元素 指向上一个就是头哨兵 是不能删除的
        if (removed == head) {
            throw illegalIndex(0);
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    public void insert(int index, int value) {
        // 通过index-1找到的是上一个节点的位置 如果是index找到的是下一个节点的位置
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        // 上一个节点指向的下一个就是下一个节点
        Node next = prev.next;
        // 创建要插入的节点 让他的上一节节点指向的是prev 然后他的下一个节点指向的是next
        Node inserted = new Node(prev, value, next);
        // 让上一个节点的下一个指向inserted
        prev.next = inserted;
        // 让下一个节点的上一个指针指向inserted
        next.prev = inserted;
    }

    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next;
        if (removed == tail) {
            throw illegalIndex(index);
        }
        Node next = removed.next;

        prev.next = next;
        next.prev = prev;
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            // 遍历的位置应该要是头哨兵的下一个位置
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
