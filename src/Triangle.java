public class Triangle {
    public static void main(String[] args) {
        int[][] data = {{3, 4, 5},{2, 10, 8},{5, 6, 5},{5, 5, 5}};

        for (int[] triangleData : data) {
            System.out.print("a=" + triangleData[0] + " b=" + triangleData[1] + " c=" + triangleData[2]);
            if(isTriangle(triangleData)){
                triangleType(triangleData);
                System.out.print(" P=" + calculatePerimeter(triangleData));
                System.out.println(" S=" +roundToDecimal(calculateArea(triangleData)));
            } else {
                System.out.println(" Can't be triangle! ");
            }
        }
    }

    public static boolean isTriangle(int[] sides) {
        return sides[0] < sides[1] + sides [2] && sides[1] < sides[0] + sides [2] && sides[2] < sides[0] + sides[1];
    }

    public static int calculatePerimeter(int[] sides) {
        int sum = 0;
        for(int side : sides) {
            sum += side;
        }
        return sum;
    }

    public static double calculateArea(int[] sides) {
        double p = calculatePerimeter(sides) / 2.0;
        return Math.sqrt(p*(p-sides[0])*(p-sides[1])*(p-sides[2]));
    }

    public static void triangleType(int[] data) {
        if(data[0] == data[1] && data[1] == data[2]){
            System.out.println(" Lygiakrastis ");
        } else if (data[0] == data[1] || data[1] == data[2] || data[2] == data[0]){
            System.out.print(" Lygiasonis ");
        } else {
            System.out.print(" Ivairiakrastis ");
        }
    }

    public static double roundToDecimal(double number) {
        return Math.round(number*100.0)/100.0;
    }
}
