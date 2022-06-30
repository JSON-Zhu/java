package com.linklist.test;

import org.junit.Test;

import java.util.Random;

/**
 * LinkedListReverse
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/26 5:55
 **/
public class LinkedListReverse {

    public static void main(String[] args) {
        LinkedListReverse linkedListReverse = new LinkedListReverse();
        Node node = linkedListReverse.test3();
        System.out.println("::::");
        linkedListReverse.test4(node);

    }

    @Test
    public Node test3() {
        Node head = new Node();
        head.value=-1;
        Node last;
        last=head;
        for (int i = 0; i < 5; i++) {
            Node node = new Node();
            node.value=i;
            node.next=null;
            last.next=node;
            last=node;
        }
        int i = 1;
        Node cur=head.next;
        while (cur!= null) {
            System.out.println(i++ + "::" + cur.value);
            cur=cur.next;
        }
        return head;
    }

    @Test
    public void test45(){
        for (int i = 0; i < 100; i++) {
            System.out.println(new Random().nextInt(3));
        }
    }

    @Test
    public void  test4(Node header){
        Node pre=null;
        Node cur=header.next;
        Node reversedHeader=new Node();
        while (cur!=null){
            Node temp = cur.next;
            if(temp==null){
                reversedHeader.next=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        int i = 1;
        Node cur2=reversedHeader.next;
        while (cur2!= null) {
            System.out.println(i++ + "::" + cur2.value);
            cur2=cur2.next;
        }
    }

    class Node {
        private Node head;
        private Integer value;
        private Node next;

        public Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node() {

        }
    }
}
