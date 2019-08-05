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
