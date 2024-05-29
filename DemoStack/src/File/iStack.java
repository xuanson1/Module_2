package File;

public interface iStack<E> {
    public void push(E item);
    E pop();
    E peek();
    boolean isEmpty();
    int search(int search);
    int getSize();

}
