package LinkList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author StarLeaf-Roxy
 * @since 2026/9/21
 */

public class SinglyLinkedList implements Iterable<Integer>{
    // private Node head = null;
    private Node head = new Node(666, null);

    // 从头部添加数据
    public void addFirst(int value) {
        // this.head = new Node(value, this.head);
        // 有了哨兵后 加入链表的头部可以直接调用insert 然后给索引0的地方插入就好了
        insert(0, value);
    }

    // 遍历链表1
    public void loop1(Consumer<Integer> consumer) {
        Node p = head.next;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next; // 让他指向下一个Node 其实就是让他赋值下一个Node的类
        }
    }

    // 遍历链表2
    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head.next; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            // 有了哨兵节点 要从head的下一个地方开始遍历
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != null;
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
        int value;
        Node next;

        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node findLast() {
         // if (head == null) {
         //     return null;
         // }

         Node p;
         // 不知道尾部所以要一个一个遍历到最后 这里复杂度就是n了
         for (p = head; p.next != null; p = p.next) {

         }

         return p;
    }

    public void addLast(int value) {
        Node last = findLast();
        // if (last == null) {
        //     addFirst(value);
        //     return;
        // }

        // last的下一个就指着新的值以及last的下一个的下个指针指向null
        last.next = new Node(value, null);
    }

    private Node findNode(int index) {
        // 因为有了哨兵 所以从-1开始 -1代表哨兵的位置
        int i = -1;
        // 然后遍历要从head的下一个开始也就是哨兵的位置
        for (Node p = this.head; p != null; p = p.next, i ++) {
            if (index == i) {
                return p;
            }
        }
        return null;
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
    }

    public int get(int index) {
        Node node = findNode(index);
        if (node != null) {
            return node.value;
        }
        throw illegalIndex(index);
    }

    // 插入
    public void insert(int index, int value) {
        // 第一个元素 直接添加
        // 有了哨兵 不需要调用addFirst
        // if (index == 0) {
        //     addFirst(value);
        //     return;
        // }
        Node prev = findNode(index - 1);
        if (prev == null) {
            // 找不到
            throw illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    // 删除第一个
    public void removeFirst() {
        // if (head == null) {
        //     throw new IllegalArgumentException("链表为空");
        // }
        // this.head = head.next;
        // 有哨兵了 直接调用remove删除索引0也就是第一个位置就好了
        remove(0);
    }

    // 删除指定链表位置元素
    public void remove(int index) {
        // 有了哨兵之后 可以不用对索引0做特殊处理了
        // if (index == 0) {
        //     // 这里对第一个元素的特殊处理
        //     removeFirst();
        //     return;
        // }

        // 获得要删除节点的上一个节点
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }

        // 通过上一个节点获取当前要删除的节点
        Node removed = prev.next;
        if (removed == null) {
            throw illegalIndex(index);
        }

        // 让当前要删除节点的上一节点的下一个指针 当前节点指针的下一个位置的元素
        prev.next = removed.next;
    }
}
