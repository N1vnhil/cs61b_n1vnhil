package deque;

import java.util.Iterator;

public class ArrayDeque<T>{

    int size;
    int capacity = 8;
    T[] items;
    int p = 0;    //p point to the first item

    public ArrayDeque(){
        items = (T[]) new Object[capacity];
    }

    private void resize(int i){
        T[] temp = (T[]) new Object[i];
        if(p+size<=capacity){
            System.arraycopy(items, p, temp, 0, size);
        }
        else{
            System.arraycopy(items, p, temp, 0, capacity-p);
            System.arraycopy(items, 0, temp, capacity-p, p+size-capacity);
        }
        items = temp;
        p = 0;
    }

    public void addFirst(T item){
        if(size==capacity){
            resize(capacity*2);
            capacity *= 2;
        }


        //set first item by pointer p, then renew p value
        if(p-1<0){
            items[p-1+capacity] = item;
            p = p - 1 + capacity;
        }else{
            items[p-1] = item;
            p -= 1;
        }

        size += 1;

    }

    public void addLast(T item){
        if(size==capacity){
            resize(capacity*2);
            capacity *= 2;
        }

        if(p+size<capacity){
            items[p+size] = item;
        }else{
            items[p+size-capacity] = item;
        }
        size += 1;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        System.out.print("[");
        for(int i=0; i<size; i++){
            System.out.print(items[i]);
            if(i!=size-1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public T removeFirst(){
        T val = items[p];
        items[p] = null;
        if(p+1<capacity){
            p += 1;
        }else{
            p = p + 1 - capacity;
        }
        size -= 1;
        if(size < capacity/4 && size > 4){
            resize(capacity/4);
        }
        return val;
    }

    public T removeLast(){
        T val;
        if(p+size-1<capacity) {
            val = items[p + size - 1];
            items[p + size - 1] = null;
        }else{
            val = items[p + size - 1 - capacity];
            items[p + size - 1 - capacity] = null;
        }
        size -= 1;
        if(size < capacity/4 && size > 4){
            resize(capacity/4);
        }
        return val;
    }

    public T get(int i){
        if(p+i<capacity) return items[p+i];
        else return items[p+i-capacity];
    }

    public static void main(String[] args){
        ArrayDeque<Integer> ls= new ArrayDeque<>();
        for(int i=0; i<20; i++){
            ls.addLast(i);
            ls.addFirst(i);
        }
        ls.printDeque();
    }

}
