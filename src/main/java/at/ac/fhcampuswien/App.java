package at.ac.fhcampuswien;

import java.util.Scanner;

public class App {

    Scanner scanner = new Scanner(System.in);

    //todo Task 1
    public void largestNumber() {
        double largestNumber = 0;
        double input = 42;
        int count = 1;

        while (input > 0) {
            System.out.print("Number " + count + ": ");
            input = scanner.nextDouble();

            if (input <= 0 && count == 1) {
                System.out.println("No number entered.");
                return;
            }

            if (input > largestNumber) {
                largestNumber = input;
            }

            count++;
        }

        System.out.printf("The largest number is %.2f\n", largestNumber);
    }

    //todo Task 2
    public void stairs() {
        System.out.print("n: ");
        int n = scanner.nextInt();
        int step = 1;

        if (n <= 0) {
            System.out.println("Invalid number!");
            return;
        }

        int digitsInRow = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < digitsInRow; j++) {
                System.out.print(step + " ");
                step++;
            }
            System.out.println();
            digitsInRow++;
        }
    }

    //todo Task 3
    public void printPyramid() {
        final int ROWS = 6;
        int starCount = 1;

        for (int i = 0; i < ROWS; i++) {
            int numberOfSpaces = ROWS - i - 1;
            for (int j = 0; j < numberOfSpaces; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < starCount; k++) {
                System.out.print("*");
            }

            System.out.println();
            starCount += 2;
        }
    }

    //todo Task 4
    public void printRhombus() {
        System.out.print("h: ");
        int height = scanner.nextInt();

        System.out.print("c: ");
        char selectedCharacter = scanner.next().charAt(0);

        if (height % 2 == 0) {
            System.out.println("Invalid number!");
            return;
        }

        int charactersInRow = 1;
        int halfHeight = height / 2;
        int spacesInRow = halfHeight - 1;

        for (int i = 0; i < halfHeight; i++) {
            for (int j = 0; j <= spacesInRow; j++) {
                System.out.print(" ");
            }
            spacesInRow--;

            printSymmetricalAsciiRow(selectedCharacter, charactersInRow);

            System.out.println();
            charactersInRow += 2;
        }

        charactersInRow = height;
        for (int i = 0; i < halfHeight + 1; i++) {
            for (int j = 0; j <= spacesInRow; j++) {
                System.out.print(" ");
            }
            spacesInRow++;

            printSymmetricalAsciiRow(selectedCharacter, charactersInRow);

            System.out.println();
            charactersInRow -= 2;
        }
    }

    private void printSymmetricalAsciiRow(int asciiIndex, int charactersInRow) {
        int halfOfCharactersInRow = charactersInRow / 2;
        for (int k = asciiIndex - halfOfCharactersInRow; k <= asciiIndex; k++) {
            System.out.print((char) k);
        }

        for (int k = asciiIndex - 1; k >= asciiIndex - halfOfCharactersInRow; k--) {
            System.out.print((char) k);
        }
    }

    //todo Task 5
    public void marks() {
        double average = 0;
        int sum = 0;
        int negativeMarks = 0;
        int input = 42;
        int count = 0;

        while (input > 0) {
            System.out.print("Mark " + (count + 1) + ": ");
            input = scanner.nextInt();

            if (input != 0 && (input < 1 || input > 5)) {
                System.out.println("Invalid mark!");
                continue;
            }

            if (input == 5) {
                negativeMarks++;
            }

            sum += input;
            count++;
        }

        int numberOfInputs = count - 1;
        if (numberOfInputs > 0) {
            average = (double) sum / numberOfInputs;
        }

        System.out.printf("Average: %.2f\n", average);
        System.out.printf("Negative marks: %d\n", negativeMarks);
    }

    //todo Task 6
    public void happyNumbers() {
        System.out.print("n: ");
        int n = scanner.nextInt();

        while (n != 1) {
            int squaredDigitSum = 0;

            while (n > 0) {
                int digit = n % 10;
                n /= 10;

                squaredDigitSum += Math.pow(digit, 2);
            }

            if (squaredDigitSum == 4) {
                System.out.println("Sad number!");
                return;
            }

            n = squaredDigitSum;
        }

        System.out.println("Happy number!");
    }

    public static void main(String[] args) {
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}