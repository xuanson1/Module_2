public abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getInfo() {
        return "Person {Name: " + name + ", Age: " + age;
    }
}
