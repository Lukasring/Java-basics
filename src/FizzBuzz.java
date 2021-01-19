public class FizzBuzz {
    public void printFizzBuzz(int number) {
        if (number < 1) {
            System.out.println("Number must be greater than 0");
            return;
        }

        for(int i = 1; i<=number; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }
}
