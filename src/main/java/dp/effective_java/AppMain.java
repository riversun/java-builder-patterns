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
