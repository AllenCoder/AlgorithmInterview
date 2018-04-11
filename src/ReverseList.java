/**
 * Created by Allen on 2018/4/11.
 */
public class ReverseList {
    /*算法笔记 - 单链表反转(Java)
    * */

    public static Node reverseList(Node head) {
        Node p = new Node(0);
        Node q = new Node(0);
        Node r = new Node(0);

        p = head;
        q = head.next;
        p.next = null;
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        head = p;
        return head;
    }

    public static void main(String[] args) {
        int count = 9;
        Node t = new Node(1);
        Node x = t;
        for (int i = 2; i <= count; i++) {
            x = (x.next = new Node(i));
        }
        t = reverseList(t);
        while (t != null) {
            System.out.print(t.val + " ");
            t = t.next;
        }
    }

    public static class Node {
        int val;
        Node next;

        public Node(int v) {
            this.val = v;
        }
    }
}
