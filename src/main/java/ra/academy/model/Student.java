package ra.academy.model;

public class Student {
    private Integer id;
    private String name;
    private int age;
    private boolean gen;

    public Student(String name, int age, boolean gen) {
        this.name = name;
        this.age = age;
        this.gen = gen;
    }

    public Student() {

    }

    public Student(Integer id, String name, int age, boolean gen) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gen = gen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGen() {
        return gen;
    }

    public void setGen(boolean gen) {
        this.gen = gen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
