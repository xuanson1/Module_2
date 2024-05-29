package File;

public class User<T,K> {
    private T id;
    private String name;
    private K age;

    public User(T id, String name, K age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
