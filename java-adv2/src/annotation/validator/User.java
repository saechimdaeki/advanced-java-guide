package annotation.validator;

public class User {
    @NotEmpty(message = "이름이 비엇습니다.")
    private String name;
    @Range(min = 1, max = 100, message = "나이는 1과 100사이여야 합니다")
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
