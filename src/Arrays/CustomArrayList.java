package Arrays;

import java.util.AbstractList;
import java.util.Arrays;

public class CustomArrayList<T> extends AbstractList<T> {
    public static final int DEFAULT_INITIAL_CAPACITY  = 5;
    private int size =0;
    private Object[] elements;

    public CustomArrayList(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    @Override
    public boolean add(T t) {
       if(elements.length == size){
           resize();
       }
       elements[size++] = t;
       return true;
    }

    public void resize(){
        int newSize = elements.length + (elements.length >>1); // 1.5 times
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public T get(int index) {
        if(index > size || index <0)
            throw  new IndexOutOfBoundsException("Index passed is out of bound");
        @SuppressWarnings("unchecked")
        T element = (T) elements[index];
        return element;
    }

    @Override
    public int indexOf(Object obj){
        for(int i = 0; i<size ; i++){
            if(elements[i] != null && obj != null && elements[i] == obj)
                return i;
        }
        return -1;
    }

    @Override
    public boolean contains(Object obj){
        return indexOf(obj) >= 0;

    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index){
        if(index > size || index <0)
         throw new IndexOutOfBoundsException("Index passes is out of bound");
        T removeElement = (T) elements[index];
        System.arraycopy(elements, index+1, elements, index, size - index -1);
        elements[--size] = null;
        return removeElement;
    }


    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args){
        CustomArrayList<Integer> list = new CustomArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(5);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println(list.size);
        list.add(3);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        System.out.println(list );
        System.out.println(list.size);
//        System.out.println(list.get(10));// to demo index out of bound exception
        System.out.println(list.contains(11));



    }
}
