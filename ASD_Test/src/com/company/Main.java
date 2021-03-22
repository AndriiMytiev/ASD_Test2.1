package com.company;

public class Main {

    public static void main(String[] args) {
        MyList list = new MyList();
        list.insert(7, 1);
        list.insert(11, 2);
        list.insert(0, 3);
        list.insert(0, 4);
        list.insert(9, 5);
        list.insert(5, 6);
        list.insert(0, 7);
        list.insert(8, 8);
        list.insert(0, 9);
        list.insert(0, 10);
        list.insert(33, 11);
        list.insert(12, 12);
        list.insert(0, 13);
        list.insert(0, 14);
        list.insert(15, 15);
        list.sort_nonempty();
        list.getElement(2);
        list.setElement(3, 15);
        list.print();
        list.getDistance();
    }
}