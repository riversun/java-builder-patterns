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
