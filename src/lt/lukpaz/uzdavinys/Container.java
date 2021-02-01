package lt.lukpaz.uzdavinys;

public class Container implements IContainer{
    private Color[] colors;
    private int size;

    public Container(Color... colors) {
        this.colors = colors;
        this.size = this.colors.length;
    }

    @Override
    public void add(Color color) {
        Color[] newColors = new Color[ size + 1];
        if(size > 0) {
            System.arraycopy(this.colors, 0, newColors, 0, size);
        }
        newColors[size] = color;
        this.colors = newColors;
        this.size = this.colors.length;
    }
    @Override
    public void remove(int index) {
        if(index < 0 || index > size-1) {
            System.err.println("Container delete index out of bounds!");
            return;
        }
        Color[] newColors = new Color[ size - 1];
        // nukopijuojam nuo 0 iki iskerpamo el
        System.arraycopy(this.colors, 0, newColors, 0, index);
        // nukopijuojame likusius
        int remaining = size - 1 - index;
        System.arraycopy(this.colors, index+1, newColors, index, remaining);

        this.colors = newColors;
        this.size = this.colors.length;
    }
    @Override
    public int containerSize() {
        return this.size;
    }

    @Override
    public Color get(int index) {
        if (index > this.size - 1 || index < 0) {
            System.err.println("Acceptable values: 0.."+ (containerSize()-1));
            System.err.println("Returning last element!");
            return this.colors[size-1];
        }
        return this.colors[index];
    }

    @Override
    public void printAll() {
        if (containerSize() < 1) {
            System.out.println("No elements in container!");
            return;
        }

        for (int i = 0; i<this.size; i++) {
            Color c = this.colors[i];
            System.out.println(i+1 + ") Color hex: " + String.format("0x%06X", c.getColor()));
        }
    }
}
