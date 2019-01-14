package com.zhl.map;

/**
 * Created by zhl on 18/12/20 下午5:34.
 */
public class Node {
    private Object data;
    public Node next;

    public Node(Object data){
        this.data = data;
    }

    public Object getData() {
        return data;
    }


    public static void main(String[] args) {
        Node node = new Node(1);
//        node.next = new Node(2);
        System.out.println(node.getData());
        System.out.println(node.next);
    }



}
