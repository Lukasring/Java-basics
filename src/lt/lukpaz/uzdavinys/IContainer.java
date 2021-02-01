package lt.lukpaz.uzdavinys;

public interface IContainer {
    void add(Color color);
    void remove(int index);
    int containerSize();

    Color get(int index);
    void printAll();
}
