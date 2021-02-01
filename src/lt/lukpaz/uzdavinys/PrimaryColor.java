package lt.lukpaz.uzdavinys;

public class PrimaryColor implements Color{
    private final int color;
    public PrimaryColor(int color) {
        this.color = color;
    }
    @Override
    public int getColor() {
        return this.color;
    }
}
