package info.vladyslav.cl.javaBasics.u04patterns.gof_3_behavioral.beh04iterator.iter02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorInjection {
    private Object[] objectsData;
    private int size;

    // вызов объекта внутреннего класса через метод
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    // внутренний класс с итератором
    private class IteratorImpl implements Iterator<Object> {
        int cursor;       // index of next element to return

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Object next() {
            if (!hasNext())
                throw new NoSuchElementException();
            int i = cursor;
            cursor = i + 1;
            return objectsData[i];
        }

        @Override
        public void remove() {
            IteratorInjection.this.remove(cursor);
        }
    }

    public void remove(int index) {
        if (index == size-1){
            objectsData[size-1] = null;
            size--;
        }else{
            for (int i = index; i < size-1; i++) {
                objectsData[i] = objectsData[i + 1];
            }
            objectsData[size-1] = null;
            size--;
        }
    }

    // вызов итератора вручную через вызов интерфейса Итератор + предача ему встроенного итератора
    public static void main(String[] args) {
        IteratorInjection array = new IteratorInjection();
        Iterator iter = array.iterator();
        iter.remove();
    }
}
