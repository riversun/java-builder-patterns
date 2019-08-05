package dp.lombok;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder Pattern of "Lombok"
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
    private List<String> hobby;

    Person(String name, Integer age, String gender, Integer height, String eyeColor, String hairColor, List<String> hobby) {

        if (name == null) {
            throw new NullPointerException("The property \"name\" is null. "
                    + "Please set the value by \"name()\". "
                    + "The properties \"name\", \"age\", \"gender\" and \"height\" are required.");
        }
        if (age == null) {
            throw new NullPointerException("The property \"age\" is null. "
                    + "Please set the value by \"age()\". "
                    + "The properties \"name\", \"age\", \"gender\" and \"height\" are required.");
        }
        if (gender == null) {
            throw new NullPointerException("The property \"gender\" is null. "
                    + "Please set the value by \"gender()\". "
                    + "The properties \"name\", \"age\", \"gender\" and \"height\" are required.");
        }
        if (height == null) {
            throw new NullPointerException("The property \"height\" is null. "
                    + "Please set the value by \"height()\". "
                    + "The properties \"name\", \"age\", \"gender\" and \"height\" are required.");
        }

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.hobby = hobby;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {

        private String name;
        private Integer age;
        private String gender;
        private Integer height;
        private String eyeColor;
        private String hairColor;
        private List<String> hobby = new ArrayList<String>();

        PersonBuilder() {
        }

        public PersonBuilder name(String name) {
            this.name = name;
            return PersonBuilder.this;
        }

        public PersonBuilder age(Integer age) {
            this.age = age;
            return PersonBuilder.this;
        }

        public PersonBuilder gender(String gender) {
            this.gender = gender;
            return PersonBuilder.this;
        }

        public PersonBuilder height(Integer height) {
            this.height = height;
            return PersonBuilder.this;
        }

        public PersonBuilder eyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
            return PersonBuilder.this;
        }

        public PersonBuilder hairColor(String hairColor) {
            this.hairColor = hairColor;
            return PersonBuilder.this;
        }

        public PersonBuilder hobby(List<String> hobby) {
            this.hobby = hobby;
            return PersonBuilder.this;
        }

        public PersonBuilder addHobby(String hobby) {
            this.hobby.add(hobby);
            return PersonBuilder.this;
        }

        public Person build() {
            return new Person(this.name, this.age, this.gender, this.height, this.eyeColor, this.hairColor, this.hobby);
        }

        @Override
        public String toString() {
            return "Person.PersonBuilder(name=" + this.name + ", age=" + this.age + ", gender=" + this.gender + ", height=" + this.height + ", eyeColor=" + this.eyeColor + ", hairColor="
                    + this.hairColor + ", hobby=" + this.hobby + ")";
        }
    }

    @Override
    public String toString() {
        return "Person(name=" + this.name + ", age=" + this.age + ", gender=" + this.gender + ", height=" + this.height + ", eyeColor=" + this.eyeColor + ", hairColor=" + this.hairColor + ", hobby="
                + this.hobby + ")";
    }

    public void show() {
        System.out.println(this);
    }
}
