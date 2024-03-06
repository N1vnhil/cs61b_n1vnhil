package deque;

import javax.swing.*;
import java.util.Iterator;
import java.util.Objects;

public class LinkedListDeque<T> {

    private class Node{

        public T item;
        public Node pre;
        public Node next;

        public Node(T x, Node p, Node n){
            item = x;
            pre = p;
            next = n;
        }
    }

    private int size;
    private Node sentinel;

    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        size = 0;
    }

    public void addFirst(T item){
        Node first;
        if(size>0) {
            first = new Node(item, sentinel, sentinel.next);
            sentinel.next.pre = first;
            sentinel.next = first;
        }else{
            first = new Node(item, sentinel, sentinel);
            sentinel.next = first;
            sentinel.pre = first;
        }
        size += 1;
    }

    public void addLast(T item){
        Node last;
        if(size>0){
            last = new Node(item, sentinel.pre, sentinel);
            sentinel.pre.next = last;
            sentinel.pre = last;
        }else{
            last = new Node(item, sentinel, sentinel);
            sentinel.next = last;
            sentinel.pre = last;
        }
        size += 1;
    }

    public boolean isEmpty(){
        if(size>0){return false;}
        return true;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node p = sentinel;
        System.out.print("[");
        for(int i=0; i<size; i++){
            p = p.next;
            System.out.print(p.item);
            if(i==size-1) continue;
            System.out.print(" ");
        }
        System.out.print("]");
        System.out.println();
    }

    public T removeFirst(){
        if(size==0){
            return null;
        }
        Node p;
        Node first = sentinel.next;
        if(size>1){
            p=sentinel.next.next;
            p.pre = sentinel;
            sentinel.next = p;
        }
        if(size==1){
            sentinel.next = null;
            sentinel.pre = null;
        }

        size -= 1;
        return first.item;
    }

    public T removeLast(){
        if(size==0){
            return null;
        }
        T last = sentinel.pre.item;
        if(size>1){
            sentinel.pre.pre.next = sentinel;
            sentinel.pre = sentinel.pre.pre;
        }
        if(size==1){
            sentinel.next = null;
            sentinel.pre = null;
        }

        size -= 1;
        return last;
    }

    public T get(int index){
        Node p = sentinel;
        for(int i=0; i<index; i++){
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index){
        Node p = sentinel;
        if(index!=0){
            p = p.next;
            return getRecursive(index--);
        }
        return p.item;
    }

    //public Iterator<T> iterator(){}
    //public boolean equals(Object o){}

    public static void main(String args[]){
        LinkedListDeque<Integer> list = new LinkedListDeque<Integer>();
        list.addLast(3);
        list.printDeque();
        list.removeFirst();
        list.removeLast();
        list.printDeque();

    }
}
