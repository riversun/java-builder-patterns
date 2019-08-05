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
