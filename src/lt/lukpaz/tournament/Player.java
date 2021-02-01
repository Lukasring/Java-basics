package lt.lukpaz.tournament;

public class Player extends Person{
    private static int count;
    private final int id;

    public Player(String name) {
        super(name);
        ++count;
        id = count;
    }

    public int getId() {
        return id;
    }
}
