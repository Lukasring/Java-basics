package lt.lukpaz.uzdavinys;

public class Uzdavinys {
    public static void main(String[] args) {
        Container colorContainer = new Container(new PrimaryColor(0), new PrimaryColor(1));
//        PrimaryColor red = new PrimaryColor(0xff0000);
//        PrimaryColor blue = new PrimaryColor(0x0000FF);
//        PrimaryColor yellow = new PrimaryColor(0xFFFF00);

//        colorContainer.add(red);
//        colorContainer.add(yellow);
//        colorContainer.add(blue);
        colorContainer.add(new PrimaryColor(2));
        colorContainer.add(new SecondaryColor(3));
        colorContainer.add(new SecondaryColor(4));
        colorContainer.add(new SecondaryColor(5));


        System.out.println("size: " + colorContainer.containerSize());
        colorContainer.printAll();

        colorContainer.remove(4);

        System.out.println("size: " + colorContainer.containerSize());
        colorContainer.printAll();

        Color col1 = colorContainer.get(1);
        System.out.println(col1.getColor());

    }
}
