package lt.lukpaz.tournament;

public abstract class Person {
    String name;
    Person() {
        this.name = "No name";
    }

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
