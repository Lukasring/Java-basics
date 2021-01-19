public class LoopsExamples {
    public static void main(String[] args) {
        // 1 uzduotis
        // calculate averages
        int[] arr1 = {5, 6, 10, 15, 8, 4};
        int[] arr2 = {8, 5, 3};

        double arr1Average = calculateAverage(arr1);
        double arr2Average = calculateAverage(arr2);
        double difference = arr1Average - arr2Average;

        System.out.println("arr1 avg: " + arr1Average + " arr2 avg: " + arr2Average);
        System.out.println("Difference: " + difference);

        // 2 uzduotis
        // rasti tobuluosius skaicius
        findPerfectNumbers(1000);

        // 3 uzduotis
        // pirminiai skaiciai intervale
        findPrimeNumbersInInterval(1,100);

        // 4 uzduotis
        // apvalinimas iki nurodyto tikslumo
        System.out.println("\n1.23456789 -> " + floorToDecimals(1.23456789, 5));
    }

    public static double calculateAverage(int[] arr) {
        double sum = arraySum(arr);
        return sum / arr.length;
    }

    public static int arraySum(int[] arr) {
        int sum = 0;
        for(int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static void findPerfectNumbers(int limit) {
        if (limit < 1) {
            System.out.println("Search limit must be positive intiger!");
            return;
        }
        System.out.print("Perfect numbers 1.." + limit + ": ");
        for(int i=1;i<=limit;i++) {
            int divisorSum = 0;
            for(int j = i-1; j>0; j--) {
                if (i % j == 0) {
                    divisorSum += j;
                }
                if (divisorSum > i) {
                    break;
                }
            }
            if (divisorSum == i) {
                System.out.print(i + " ");
            }
        }
    }

    public static void findPrimeNumbersInInterval(int from, int to) {
        if (from <0 || to<0 || to<from) {
            System.out.println("Numbers can't be negative, from < to;");
            return;
        }
        System.out.printf("\nPrime numbers from %d to %d: ", from, to);
        for(int i = from; i<=to; i++) {
            if(isPrime(i)) {
                System.out.print(i + ", ");
            }
        }
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++){
            if (number % i == 0) return false;
        }
        return number > 1;
    }

    public static double floorToDecimals(double number, int decimals) {
        double precision = Math.pow(10.0, decimals);
        return Math.floor(number*precision)/precision;
    }
}
