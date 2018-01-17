package arrayList;

import java.util.Arrays;

public class ArrayList<T> {
    private int size;
    private T[] arr;
    private int capacity;

    public ArrayList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = (T[]) new Object[capacity];
    }

    public ArrayList() {
        this(4);
    }

    public int getCount() {
        return this.size;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException();
        }
        return this.arr[index];
    }

    public void add(T element) {
        if (this.size >= this.capacity) {
            this.grow();
        }

        this.arr[this.size] = element;
        this.size++;
    }

    public T removeAt(int index) {
        T item = this.get(index);
        shiftLeft(index);

        if (this.size - 1 < this.capacity / 3) {
            this.shrink();
        }
        this.size--;
        return item;
    }

    private void shiftLeft(int index) {
        for (int i = index; i <this.size - 1 ; i++) {
            this.arr[i] = this.arr[i+1];
        }
        this.arr[this.size-1] = null;
    }

    public void set(int i, T item) {
        if (i < 0 || i >= size) {
            throw new IllegalArgumentException();
        }
        this.arr[i] = item;
    }

    private void shrink() {

        this.capacity /= 2;
        T[] newArr = Arrays.copyOf(this.arr, this.capacity);
        this.arr = newArr;
    }

    private void grow() {
        this.capacity *= 2;
        T[] newArr = Arrays.copyOf(this.arr, this.capacity);
        this.arr = newArr;
    }
}
