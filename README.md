# Overview

Builder patterns for Java

It is licensed under [MIT](https://opensource.org/licenses/MIT).

# Mandatory Properties Chain

**About**

Builder pattern that can forcibly set the mandatory property in the correct order.

**Main class**

```Java
package dp.mandatory_chain;

import java.util.Arrays;

public class AppMain {

    public static void main(String[] args) {

        dp.mandatory_chain.Person.builder()
                .name("Tom")
                .age(20)
                .gender("male")
                .height(200)
                .eyeColor("blue")
                .hairColor("blonde")
                .hobby(Arrays.asList("Programming", "Skiing"))
                .build()
                .show();
    }
}

```

**Builder class**

```Java
package dp.mandatory_chain;

import java.util.List;
import java.util.Optional;

/**
 * Builder Pattern of "Mandatory Properties Chain"
 *
 * Generated with https://riversun.github.io/java-builder/
 *
 */
public class Person {

    private final String name;// Required
    private final Integer age;// Required
    private final String gender;// Required
    private final Integer height;// Required
    private final Optional<String> eyeColor;// Optional(use Optional<String>)
    private final Optional<String> hairColor;// Optional(use Optional<String>)
    private final Optional<List<String>> hobby;// Optional(use Optional<List<String>>)

    Person(Builder.Builder1 builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.gender = builder.gender;
        this.height = builder.height;
        this.eyeColor = builder.eyeColor;
        this.hairColor = builder.hairColor;
        this.hobby = builder.hobby;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        public Builder1 name(String name) {
            return new Builder1(name);
        }

        public static final class Builder1 {
            final String name;
            Integer age;
            String gender;
            Integer height;
            Optional<String> eyeColor;
            Optional<String> hairColor;
            Optional<List<String>> hobby;

            private Builder1(String name) {
                this.name = name;
            }

            public Builder2 age(Integer age) {
                this.age = age;
                return new Builder2(Builder1.this);
            }
        }

        public static final class Builder2 {
            final Builder1 builder;

            private Builder2(Builder1 builder) {
                this.builder = builder;
            }

            public Builder3 gender(String gender) {
                this.builder.gender = gender;
                return new Builder3(this.builder);
            }
        }

        public static final class Builder3 {
            final Builder1 builder;

            private Builder3(Builder1 builder) {
                this.builder = builder;
            }

            public Builder4 height(Integer height) {
                this.builder.height = height;
                return new Builder4(this.builder);
            }
        }

        public static final class Builder4 {
            final Builder1 builder;

            private Builder4(Builder1 builder) {
                this.builder = builder;
            }

            public Builder4 eyeColor(String eyeColor) {
                this.builder.eyeColor = Optional.of(eyeColor);
                return this;
            }

            public Builder4 hairColor(String hairColor) {
                this.builder.hairColor = Optional.of(hairColor);
                return this;
            }

            public Builder4 hobby(List<String> hobby) {
                this.builder.hobby = Optional.of(hobby);
                return this;
            }

            public Person build() {
                return new Person(this.builder);
            }
        }
    }

    public String name() {
        return this.name;
    }

    public Integer age() {
        return this.age;
    }

    public String gender() {
        return this.gender;
    }

    public Integer height() {
        return this.height;
    }

    public Optional<String> eyeColor() {
        return this.eyeColor;
    }

    public Optional<String> hairColor() {
        return this.hairColor;
    }

    public Optional<List<String>> hobby() {
        return this.hobby;
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
```

# Effective Java Builder Pattern

**About**

Builder pattern introduced in effective java. It is also adopted by Okhttp etc.

**Main class**

```Java
```

**Builder class**

```Java
```
