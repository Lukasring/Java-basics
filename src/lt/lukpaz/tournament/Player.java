package lt.lukpaz.tournament;

public class Player {
    String name;
    public Player(String name) {
        setName(name);
    }

    public void setName(String name) {
        if(name.length()<2) {
            throw new IllegalArgumentException("Name must be at least 2 characters!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
