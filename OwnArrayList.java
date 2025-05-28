package acn;

import java.util.*;
/*


 */
public class OwnArrayList {

    private Object[] myItem;
    private int size;


    public OwnArrayList() {
        myItem = new Object[10];
    }

    public Object get(int index) {
        if (index < size) {
            return myItem[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void add(Object obj) {
        if (myItem.length - size <= 5) {
            increaseArraySize();
        }
        myItem[size++] = obj;
    }

    public Object remove(int tmp) {
        if (tmp < size) {
            Object obj = myItem[tmp];
            while (tmp < size) {
                myItem[tmp] = myItem[tmp+1];
                tmp++;
            }
            size--;
            return obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void increaseArraySize() {
        myItem = Arrays.copyOf(myItem, myItem.length * 2);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {

        OwnArrayList al = new OwnArrayList();
        System.out.println("size "+al.size);


        al.add(new Integer(3));
        al.add(new Integer(5));
        al.add(new Integer(23));
        al.add(new Integer(17));
        al.add(new Integer(3));
        al.add(new Integer(8));
        al.add(new Integer(30));
        al.add(new Integer(12));
        al.add(new Integer(33));
        al.add(new Integer(91));
        al.add(new Integer(38));

        al.add(new Integer(233));
        al.add(new Integer(543));
        al.add(new Integer(123));
        al.add(new Integer(31));
        al.add(new Integer(312));
        al.add(new Integer(348));
        al.add(new Integer(234));
        al.add(new Integer(421));
        al.add(new Integer(45));
        al.add(new Integer(11));
        al.add("sdwsd");

        System.out.println("size "+al.size);

        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));

        }

        System.out.println("==========");
        al.add(new Integer(99));

       System.out.println("=====remove =====");
        al.remove(1);
        System.out.println("==========");



        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));

        }


    }
}
