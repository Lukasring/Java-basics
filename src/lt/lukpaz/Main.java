package lt.lukpaz;

import lt.lukpaz.fizzbuzz.FizzBuzz;

public class Main {

    public static void main(String[] args) {
        int start = 0;
        int range = 10;
        int result = 0;
        for(int i = start; i<range; i++) {
            if(i%2 != 0){
                continue;
            }
            result += i;
        }
        String text = "result is:";
        ConsolePrinter.printString(text);
        ConsolePrinter.printNumber(result);

        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.printFizzBuzz(50);
    }
}

class ConsolePrinter {
    static void printNumber(int number) {
        System.out.println(number);
    }
    static void printString(String text) {
        System.out.println(text);
    }
}
