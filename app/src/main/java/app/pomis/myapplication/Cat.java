package app.pomis.myapplication;

/**
 * Created by romanismagilov on 20.10.15.
 */
public class Cat {
    private String name;
    private String description;

    public Cat(String _name, String _description){
        name = _name;
        description = _description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
