package dp.effective_java;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder Pattern of "Effective Java"
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

    public static class Builder {

        private String name;
        private Integer age;
        private String gender;
        private Integer height;
        private String eyeColor;
        private String hairColor;
        private List<String> hobby = new ArrayList<String>();

        public Builder() {
        }

        Builder(String name, Integer age, String gender, Integer height, String eyeColor, String hairColor, List<String> hobby) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.height = height;
            this.eyeColor = eyeColor;
            this.hairColor = hairColor;
            this.hobby = hobby;
        }

        public Builder name(String name) {
            this.name = name;
            return Builder.this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return Builder.this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return Builder.this;
        }

        public Builder height(Integer height) {
            this.height = height;
            return Builder.this;
        }

        public Builder eyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
            return Builder.this;
        }

        public Builder hairColor(String hairColor) {
            this.hairColor = hairColor;
            return Builder.this;
        }

        public Builder hobby(List<String> hobby) {
            this.hobby = hobby;
            return Builder.this;
        }

        public Builder addHobby(String hobby) {
            this.hobby.add(hobby);
            return Builder.this;
        }

        public Person build() {
            if (this.name == null) {
                throw new NullPointerException("The property \"name\" is null. "
                        + "Please set the value by \"name()\". "
                        + "The properties \"name\", \"age\", \"gender\" and \"height\" are required.");
            }
            if (this.age == null) {
                throw new NullPointerException("The property \"age\" is null. "
                        + "Please set the value by \"age()\". "
                        + "The properties \"name\", \"age\", \"gender\" and \"height\" are required.");
            }
            if (this.gender == null) {
                throw new NullPointerException("The property \"gender\" is null. "
                        + "Please set the value by \"gender()\". "
                        + "The properties \"name\", \"age\", \"gender\" and \"height\" are required.");
            }
            if (this.height == null) {
                throw new NullPointerException("The property \"height\" is null. "
                        + "Please set the value by \"height()\". "
                        + "The properties \"name\", \"age\", \"gender\" and \"height\" are required.");
            }

            return new Person(this);
        }
    }

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.gender = builder.gender;
        this.height = builder.height;
        this.eyeColor = builder.eyeColor;
        this.hairColor = builder.hairColor;
        this.hobby = builder.hobby;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", height=" + height + ", eyeColor=" + eyeColor + ", hairColor=" + hairColor + ", hobby=" + hobby + "]";
    }

    public void show() {
        System.out.println(this);
    }
}
