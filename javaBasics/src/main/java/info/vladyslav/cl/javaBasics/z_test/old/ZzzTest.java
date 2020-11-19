package info.vladyslav.cl.javaBasics.z_test.old;

import java.util.Arrays;

public class ZzzTest<E> {
    public ZzzTest() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    int size;
    Object[] elementData;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;
    int modCount = 0;

    public void add(E e) {
        int minCapacity = size + 1; // Increments modCount!!
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        modCount++;

        // overflow-conscious code
        if (minCapacity - elementData.length > 0) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0)
                newCapacity = minCapacity;
            // minCapacity is usually close to size, so this is a win:
            Object[] temp = new Object[newCapacity];
            for (int i = 0; i < elementData.length; i++) {
                temp[i] = elementData[i];
            }
            elementData = temp;
        }
        elementData[size++] = e;
    }


    @Override
    public String toString() {
        return "ZzzTest{" +
                "size=" + size +
                ", elementData=" + Arrays.toString(elementData) +
                '}';
    }

    public static void main(String[] args) {
        ZzzTest<Integer> zzzTest = new ZzzTest<Integer>();
        zzzTest.add(1);
        zzzTest.add(2);
        zzzTest.add(2);
        zzzTest.add(2);
        zzzTest.add(2);
        zzzTest.add(2);
        zzzTest.add(2);

        System.out.println(zzzTest);
    }

}
