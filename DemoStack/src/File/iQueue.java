package File;

public interface iQueue<E> {
    boolean offer(E e);
    E poll();
    E peek();

}
