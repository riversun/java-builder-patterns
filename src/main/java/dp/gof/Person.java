package dp.gof;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder Pattern of "GoF"
 * 
 * Generated with https://riversun.github.io/java-builder/
 *
 */
public class Person {

    private String name;
    private Integer age;
    private String gender;
    private Integer height;
    private String eyeColor;
    private String hairColor;
    private List<String> hobby = new ArrayList<String>();

    public Person() {

    }

    public Person(String name, Integer age, String gender, Integer height, String eyeColor, String hairColor, List<String> hobby) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.hobby = hobby;
    }

    public Person setName(String name) {
        this.name = name;
        return Person.this;
    }

    public String getName() {
        return this.name;
    }

    public Person setAge(Integer age) {
        this.age = age;
        return Person.this;
    }

    public Integer getAge() {
        return this.age;
    }

    public Person setGender(String gender) {
        this.gender = gender;
        return Person.this;
    }

    public String getGender() {
        return this.gender;
    }

    public Person setHeight(Integer height) {
        this.height = height;
        return Person.this;
    }

    public Integer getHeight() {
        return this.height;
    }

    public Person setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
        return Person.this;
    }

    public String getEyeColor() {
        return this.eyeColor;
    }

    public Person setHairColor(String hairColor) {
        this.hairColor = hairColor;
        return Person.this;
    }

    public String getHairColor() {
        return this.hairColor;
    }

    public Person setHobby(List<String> hobby) {
        this.hobby = hobby;
        return Person.this;
    }

    public Person addHobby(String hobby) {
        this.hobby.add(hobby);
        return Person.this;
    }

    public List<String> getHobby() {
        return this.hobby;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", height=" + height + ", eyeColor=" + eyeColor + ", hairColor=" + hairColor + ", hobby=" + hobby + "]";
    }

    public void show() {
        System.out.println(this);
    }
}

// ------------------------------------------
