package deque;

import java.util.Iterator;

public class ArrayDeque<T>{


    private int size;
    private T[] list;
    private int length=8;

    public ArrayDeque(){
        list = (T[]) new Object[length];
        size = 0;
    }

    public void addFirst(T item){
        if(size==length){
            length *= 2;
        }
        T[] a = (T[]) new Object[length];
        a[0] = item;
        System.arraycopy(list, 0, a, 1, size);
        list = a;
        size += 1;
    }

    public void addLast(T item){
        if(size==length){
            length *= 2;
            T[] a = (T[]) new Object[length];
            System.arraycopy(list, 0, a, 0, size);
            list = a;
        }
        list[size] = item;
        size += 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        System.out.print("[");
        for(int i=0; i<size; i++){
            System.out.print(list[i]);
            if(i==size-1) continue;
            System.out.print(" ");
        }
        System.out.print("]");
        System.out.println();
    }

    public T removeFirst(){
        T item = list[0];
        T[] a = (T[]) new Object[length];
        System.arraycopy(list, 1, a, 0, size-1);
        list = a;
        size -= 1;
        return item;
    }

    public T removeLast(){
        T item = list[size-1];
        T[] a = (T[]) new Object[length];
        System.arraycopy(list, 0, a, 0, size-1);
        list = a;
        size -= 1;
        return item;
    }

    public T get(int index){
        return list[index-1];
    }

    //public Iterator<T> iterator(){}
    //public boolean equals(Object o){}

}
