package File;

public class MyStack<E> implements iStack<E> {
    private E[] element;
    private int size = 0;
    public MyStack() {
        element = (E[]) new Object[size];

    }

    @Override
    public void push(E item) {
        E[] newElement = (E[]) new Object[element.length + 1];
        for (int i = 0; i < element.length; i++) {
            newElement[i] = element[i];
        }
        newElement[element.length] = item;
        element = newElement;
    }

    @Override
    public E pop() {
        E itemtop = element [element.length - 1];
        //remove itemtop
        E[] newElement = (E[]) new Object[element.length - 1];
        for (int i = 0; i < element.length - 1;i++){
            newElement[i] = element[i];
        }
        element = newElement;
        return itemtop;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int search(int search) {
        for (int i = 0; i < element.length; i++) {
            if (element[i].equals(search)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return element.length;
    }
}
