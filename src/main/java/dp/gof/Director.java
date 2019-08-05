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
