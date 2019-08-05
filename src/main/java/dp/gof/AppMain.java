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
