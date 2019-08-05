# Overview

**Introduce some builder patterns for Java**

It is licensed under [MIT](https://opensource.org/licenses/MIT).

## Thinking about "Good" builder pattern

- Ensure that mandatory properties are set
- Being able to set properties to flow without pain in use
- Mistakes in setting properties can be reduced
- Option properties may use Option<>

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
package dp.effective_java;

public class AppMain {

    public static void main(String[] args) {

        new dp.effective_java.Person.Builder()
                .name("Tom")
                .age(20)
                .gender("male")
                .height(200)
                .eyeColor("blue")
                .hairColor("blonde")
                .addHobby("Programming")
                .addHobby("Skiing")
                .build()
                .show();
    }
}

```

**Builder class**

```Java
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

```

# Lombok Builder Pattern

**About**

Builder pattern generated by Lombok when you add "@Builder" annotation into your source code.

**Main class**

```Java
package dp.lombok;

public class AppMain {

    public static void main(String[] args) {

        dp.lombok.Person.builder()
                .name("Tom")
                .age(20)
                .gender("male")
                .height(200)
                .eyeColor("blue")
                .hairColor("blonde")
                .addHobby("Programming")
                .addHobby("Skiing")
                .build()
                .show();
    }
}

```

**Builder class**

```Java
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

```

# GoF Builder pattern

**About**

Classic design pattern from GoF.

**Main class**

```Java
package dp.gof;

public class AppMain {

    public static void main(String[] args) {

        Builder builder = new PersonBuilder();

        Director director = new Director(builder);
        director.construct();

        dp.gof.Person person = builder.getResult();

        person.show();

    }
}

```

**Builder class**

```Java
package dp.gof;

import java.util.List;

public interface Builder {

    public void name(String name);

    public void age(Integer age);

    public void gender(String gender);

    public void height(Integer height);

    public void eyeColor(String eyeColor);

    public void hairColor(String hairColor);

    public void hobby(List<String> hobby);

    Person getResult();
}

```

```Java
package dp.gof;

import java.util.Arrays;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.name("Tom");
        builder.age(20);
        builder.gender("male");
        builder.height(200);
        builder.eyeColor("brown");
        builder.hairColor("brown");
        builder.hobby(Arrays.asList("Programming", "Skiing"));
    }
}

```

```java
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

```

```Java
package dp.gof;

import java.util.List;

public class PersonBuilder implements Builder {
    private Person person;

    public PersonBuilder() {
        this.person = new Person();
    }

    @Override
    public void name(String name) {
        this.person.setName(name);
    }

    @Override
    public void age(Integer age) {
        this.person.setAge(age);
    }

    @Override
    public void gender(String gender) {
        this.person.setGender(gender);
    }

    @Override
    public void height(Integer height) {
        this.person.setHeight(height);
    }

    @Override
    public void eyeColor(String eyeColor) {
        this.person.setEyeColor(eyeColor);
    }

    @Override
    public void hairColor(String hairColor) {
        this.person.setHairColor(hairColor);
    }

    @Override
    public void hobby(List<String> hobby) {
        this.person.setHobby(hobby);
    }

    @Override
    public Person getResult() {

        if (this.person.getName() == null) {
            throw new NullPointerException("The property \"name\" is null. "
                    + "Please set the value by \"builder.name()\" at Director class. "
                    + "The properties \"name\", \"age\", \"gender\" and \"height\" are required.");
        }
        if (this.person.getAge() == null) {
            throw new NullPointerException("The property \"age\" is null. "
                    + "Please set the value by \"builder.age()\" at Director class. "
                    + "The properties \"name\", \"age\", \"gender\" and \"height\" are required.");
        }
        if (this.person.getGender() == null) {
            throw new NullPointerException("The property \"gender\" is null. "
                    + "Please set the value by \"builder.gender()\" at Director class. "
                    + "The properties \"name\", \"age\", \"gender\" and \"height\" are required.");
        }
        if (this.person.getHeight() == null) {
            throw new NullPointerException("The property \"height\" is null. "
                    + "Please set the value by \"builder.height()\" at Director class. "
                    + "The properties \"name\", \"age\", \"gender\" and \"height\" are required.");
        }

        return this.person;
    }
}

// ------------------------------------------

```

# Telescoping Constructor pattern

**About**

Construct object by enumerating variables in arguments.

**Main class**

```Java
package dp.telescoping;

import java.util.Arrays;

public class AppMain {

    public static void main(String[] args) {
        Person person = new dp.telescoping.Person("Tom", 20, "male", 200, "blue", "blonde", Arrays.asList("Programming", "Skiing"));
        person.show();
    }
}

```

**Builder class**

```Java
package dp.telescoping;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder Pattern of "Telescoping Constructor"
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

```

# Builder pattern source code generator online

I developed the souce code generator online.
You can instantly generate Builder patterns: "Effective Java", "GoF", "Telescoping Constructor", "Lombok", "Mandatory Properties"

https://riversun.github.io/java-builder/
