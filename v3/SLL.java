package com.ds.v3;


import java.util.HashMap;
import java.util.Map;

class Node {
    public Node next;
    public Node random;
    public int data;

    public Node(int data) {
        this.data = data;
    }
}

public class SLL {
    private Node head;
    private int size = 0;

    public void show() {
        Node temp = head;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

    public int size() {
        int cntr = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            cntr++;
        }
        return cntr;
    }

    public void add(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = temp;
        }
    }

    public void add(int index, int data) {
        Node temp = new Node(data);
        if (index == 0) {
            temp.next = head;
            head = temp;
            return;
        }
        if (head != null) {
            Node curr = head;
            Node prev = head;
            int cntr = 0;
            while (cntr < index) {
                prev = curr;
                curr = curr.next;
                cntr++;
            }
            prev.next = temp;
            temp.next = curr;
        }
    }

    public void remove(int data) {
        if (head == null) {
            System.out.println(new RuntimeException("remove: list is empty"));
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node curr = head;
        Node prev = head;
        while (curr != null) {
            if (curr.data == data) {
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void removeByIndex(int x) {
        if (head == null) {
            System.out.println(new RuntimeException("remove: list is empty"));
        }
        if (x == 0) {
            head = head.next;
            return;
        }
        Node curr = head;
        Node prev = head;
        int cntr = 0;
        while (cntr < x) {
            prev = curr;
            curr = curr.next;
            cntr++;
        }
        prev.next = curr.next;

    }

    public void removeGreaterThanX(int x) {
        if (head == null) {
            System.out.println(new RuntimeException("remove: list is empty"));
            return;
        } else {
            Node curr = head;
            Node prev = head;
            int cntr = 0;
            while (curr != null) {
                if (curr.data > x) {
                    if (cntr == 0) {
                        head = head.next;
                        curr = head;
                    } else {
                        prev.next = curr.next;
                        curr = curr.next;
                    }
                } else {
                    prev = curr;
                    curr = curr.next;
                    cntr++;
                }
            }
        }
    }

    public void reverse() {
        Node temp = null;
        Node curr = null;
        while (head != null) {
            curr = head.next;
            head.next = temp;
            temp = head;
            head = curr;
        }
        head = temp;
    }

    public int getFromLast(int index) {
        int newIndex = size - index;
        Node curr = head;
        while (newIndex > 0) {
            curr = curr.next;
            newIndex--;
        }
        return curr.data;
    }

    public int getMiddle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public boolean checkLoopExist() {
        Node slow = head;
        Node fast = head.next;
        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            } else if (fast == slow || fast.next == slow) {
                return true;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }


        }
    }

    public int getLast3rdNode() {
        Node slow = head;
        Node fast = head.next.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

    public int getLast2ndNode() {
        Node slow = head;
        Node fast = head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

    public void sortedMerge(Node l1, Node l2) {
        Node dummyHead = new Node(0);
        Node curr = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;
        head = dummyHead.next;
    }

    public static  Node cloneRandomPointer(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> cloneMap = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            cloneMap.put(curr, new Node(curr.data));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {

            cloneMap.get(curr).next = cloneMap.get(curr.next);

            cloneMap.get(curr).random = cloneMap.get(curr.random);

            curr = curr.next;
        }
        return cloneMap.get(head);
    }

    public static void print(Node head) {
        Node ptr = head;
        while (ptr != null) {
            System.out.println("Data = " + ptr.data +
                    ", Random = " + ptr.random.data);
            ptr = ptr.next;
        }
    }


    public static void main(String[] args) {
       /* SLL sll = new SLL();
        sll.add(10);
        sll.add(20);
        sll.add(30);
        // sll.add(3, 40);
        sll.show();

        SLL sll1 = new SLL();
        sll1.add(5);
        sll1.add(15);
        sll1.add(25);
        sll1.show();

        SLL head1 = new SLL();
        head1.sortedMerge(sll.head, sll1.head);
        head1.show();

        head1.removeGreaterThanX(1);
        // sll.remove(30);
        // sll.removeByIndex(0);
        // sll.show();
        // sll.reverse();
        head1.show();*/

        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next.next = new Node(4);
        start.next.next.next.next = new Node(5);

        // 1's random points to 3
        start.random = start.next.next;

        // 2's random points to 1
        start.next.random = start;

        // 3's and 4's random points to 5
        start.next.next.random = start.next.next.next.next;
        start.next.next.next.random = start.next.next.next.next;

        // 5's random points to 2
        start.next.next.next.next.random = start.next;

        System.out.println("Original list : ");
        print(start);

        System.out.println("Cloned list : ");
        Node cloned_list = cloneRandomPointer(start);
        print(cloned_list);
    }

}
