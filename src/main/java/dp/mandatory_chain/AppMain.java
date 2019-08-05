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
