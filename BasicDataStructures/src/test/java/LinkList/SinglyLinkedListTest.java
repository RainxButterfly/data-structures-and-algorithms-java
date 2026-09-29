package LinkList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author StarLeaf-Roxy
 * @since 2026/9/21
 */
class SinglyLinkedListTest {
    @Test
    public void test1() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);
        singlyLinkedList.loop1((e) -> {
            System.out.println(e);
        });
    }

    @Test
    public void test2() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);
        for (Integer value : singlyLinkedList) {
            System.out.println(value);
        }
    }

    @Test
    public void test3() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);
        int i = singlyLinkedList.get(2);
        System.out.println(i);
    }

    @Test
    public void test4() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);
        singlyLinkedList.removeFirst();

        for (Integer i : singlyLinkedList) {
            System.out.println(i);
        }

        System.out.println("==================");
        singlyLinkedList.removeFirst();
        for (Integer i : singlyLinkedList) {
            System.out.println(i);
        }

        System.out.println("==================");
        singlyLinkedList.removeFirst();
        for (Integer i : singlyLinkedList) {
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("测试 get")
    public void test5() {
        SinglyLinkedList list = getLinkedList();
        assertIterableEquals(List.of(1, 2, 3, 4), list);
    }

    private SinglyLinkedList getLinkedList() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);
        return singlyLinkedList;
    }
}