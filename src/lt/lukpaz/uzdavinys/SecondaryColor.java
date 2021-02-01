package lt.lukpaz.uzdavinys;

public class SecondaryColor implements Color{
    private final int color;

    public SecondaryColor(int hex) {
        this.color = hex;
    }

    @Override
    public int getColor() {
        return color;
    }
}
