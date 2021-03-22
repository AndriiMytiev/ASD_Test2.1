package com.company;

import java.util.ArrayList;

public class MyList {
    private int capacity;
    private final float loadFactor = 0.75F;
    private int[] array;
    private int size = 0;

    public int getCapacity() {
        return capacity;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getLoadFactor() {
        return loadFactor;
    }

    public void getElement(int index){
        System.out.println(array[index-1]);
    }
    public void setElement(int value, int index){
        if (index <= this.size) {
            if (value >= 0) {
                this.array[index - 1] = value;
            }
        }
        else {
            int[] array2 = new int[index-this.size];
            for (int i = 0; i < index-this.size; i++) {
                array2[i]=0;
            }
            int[] array3 = new int[this.size+array2.length];
            int count = 0;
            for(int i = 0; i<this.size; i++) {
                array3[i] = array[i];
                count++;
            }
            for(int j = 0;j<array2.length;j++) {
                array3[count++] = array2[j];
            }
            if (value >= 0) {
                array3[index - 1] = value;
            }
            this.array = array3;
        }
    }

    public MyList() {
        this.capacity = 16;
        this.array = new int[this.capacity];
    }

    public MyList(int capacity) {
        if (capacity > 1) {
            this.capacity = capacity;
        }
        this.array = new int[this.capacity];
    }

    private void checkSpace() {
        if (this.getCapacity() * this.getLoadFactor() <= this.size) {
            this.extendCapacity();
        }
    }

    private void extendCapacity() {
        int[] prevArray = this.array;
        int newCapacity = this.getCapacity() * 2;
        this.array = new int[newCapacity];
        System.arraycopy(prevArray, 0, this.array, 0, this.size);
        this.setCapacity(newCapacity);
    }

    public void insert(int value, Object Index) { //Space - O(1), Time - O(n)
        int index = (Integer) Index;
        if (value >= 0) {
            if (index < 1 || index > this.size + 1) {
                return;
            }
            if (index == this.size + 1) {
                this.array[size] = value;
                this.size++;
                this.checkSpace();
                return;
            }
            int newIndex = index - 1;
            for (int i = this.size; i > newIndex; i--) { //Space - O(1), Time - O(n)
                this.array[i] = this.array[i - 1];
            }
            this.array[newIndex] = value;
            this.size++;

            this.checkSpace();
            }
    }


    public void sort_nonempty(){ //Space - O(n), Time - O(n)
        ArrayList<Integer> index = new ArrayList<>(); //Space - O(1), Time - O(1)
        ArrayList<Integer> elements = new ArrayList<>(); //Space - O(1), Time - O(1)
        for (int i = 0; i < array.length; i++){ //Space - O(1), Time - O(n)
            if(array[i] != 0){
                index.add(i);
                elements.add(array[i]);
            }
        }
        int n = elements.size();
        for (int j = 1; j < n; j++) { //Space - O(1), Time - O(n^2)
            int key = elements.get(j);
            int i = j-1;
            while ( (i > -1) && ( elements.get(i) > key ) ) {
                elements.set(i + 1, elements.get(i));
                i--;
            }
            elements.set(i + 1, key);
        }
        for (int i = 0; i < index.size(); i++) { //Space - O(1), Time - O(n)
            array[index.get(i)] = elements.get(i);
        }

    }
    public void getDistance(){ //Space - O(n), Time - O(n)
        ArrayList<Integer> distance = new ArrayList<>(); //Space - O(1), Time - O(1)
        ArrayList<Integer> index = new ArrayList<>(); //Space - O(1), Time - O(1)
        for (int i = 0; i < array.length; i++){ //Space - O(n), Time - O(n)
            if(array[i] != 0){
                index.add(i);
            }
        }
        for (int i = 0; i < index.size()-1; i++) { //Space - O(n), Time - O(n)
            int res = index.get(i+1) - index.get(i);
            distance.add(res);
        }
        for (int i = 0; i < distance.size(); i++) {
            System.out.print(distance.get(i) + " ");
        }
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }
}