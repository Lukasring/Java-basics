package lt.lukpaz.school;

public class MultiplicationTable {
    public static void main(String[] args) {
//        for(int i = 1; i<=10; i++) {
//            printTable(i);
//        }
        printTablesInARow();
        System.out.println("\n");
        printMultiplicationMatrix();
    }

    static void printTable(int number) {
        System.out.print("\n");
        for(int i = 1; i<=10; i++) {
            System.out.printf("%d * %d = %d\n", i, number, i*number);
        }
    }

    static void printTablesInARow() {
        int min = 1;
        int max = 10;
        for (int i = min; i<=max; i++) {
            System.out.print("\n");
            for(int j = min; j<=max; j++) {
                System.out.printf("|%2d * %2d = %-2d|\t", i, j, i*j);
            }
        }
    }

    static void printMultiplicationMatrix() {
        int min = 1;
        int max = 10;
        //first line
        System.out.printf("%3s", "*");
        for (int i = min; i<=max; i++) {
            System.out.printf("%3d ", i);
        }
        for(int i = min; i<=max; i++) {
            System.out.printf("\n%3d", i);
            for(int j = min; j<=max; j++) {
                System.out.printf("%3d ", i*j);
            }

        }
    }
}
