import java.security.SecureRandom;
import java.util.Scanner;
import java.lang.Math;

public class MathProgram {
    static Scanner scnr = new Scanner(System.in);

    public static void askQuestions(double a, double b, int type, int choice) {
        SecureRandom ran = new SecureRandom();
        int index;
        double studentInput;
        double totalPercentage;

        int amountCorrect = 0;
        int numQuestions = 10;
        int val = type;
        String[] instruction = {"plus", "times", "minus", "divided by"};

        if (type == 5) {
            for (int i = 0; i < numQuestions; i++) {
                val = ran.nextInt(4) + 1;
                index = val - 1;
                System.out.printf("How much is %.0f %s %.0f?", a, instruction[index], b);
                if (index == 3) {
                    System.out.print(" (Please round to two decimal places)");
                }
                System.out.println();
                studentInput = scnr.nextDouble();
                amountCorrect += generateResponse(a, b, studentInput, val);
                a = difficultyLevel(choice);
                b = difficultyLevel(choice);
            }
        }
        else {
            index = val - 1;
            for (int i = 0; i < numQuestions; i++) {
                System.out.printf("How much is %.0f %s %.0f?", a, instruction[index], b);
                if (index == 3) {
                    System.out.print(" (Please round to two decimal places)");
                }
                System.out.println();
                studentInput = scnr.nextDouble();
                amountCorrect += generateResponse(a, b, studentInput, val);
                a = difficultyLevel(choice);
                b = difficultyLevel(choice);
            }
        }

        totalPercentage = ((double)amountCorrect / numQuestions) * 100;

        System.out.println("Number of correct answers: " + amountCorrect);
        System.out.println("Number of incorrect answers: " + (numQuestions - amountCorrect));
        System.out.printf("Your score: %.0f%%%n", totalPercentage);
        if (totalPercentage < 75) {
            System.out.println("Please ask your teacher for extra help.");
        } else {
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
        System.out.println();
    }

    public static int generateResponse(double a, double b, double c, int type) {
        SecureRandom ran = new SecureRandom();
        int val = ran.nextInt(4) + 1;
        boolean correct = false;
        double ans = 0.0;
        final double THRESHOLD = 0.0001;

        switch (type) {
            case 1:
                ans = a + b;
                break;
            case 2:
                ans = a * b;
                break;
            case 3:
                ans = a - b;
                break;
            case 4:
                ans = a / b;
                ans = (double)Math.round(ans * 100) / 100;
                break;
        }

        if (Math.abs(ans - c) < THRESHOLD) {
            correct = true;
        }

        if (correct) {
            switch (val) {
                case 1:
                    System.out.println("Very good!");
                    break;
                case 2:
                    System.out.println("Excellent!");
                    break;
                case 3:
                    System.out.println("Nice work!");
                    break;
                case 4:
                    System.out.println("Keep up the good work!");
                    break;
            }
            System.out.println();
            return 1;
        }
        else {
            switch (val) {
                case 1:
                    System.out.println("No, Please try again.");
                    break;
                case 2:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 3:
                    System.out.println("Don't give up!");
                    break;
                case 4:
                    System.out.println("No. Keep trying.");
                    break;
            }
            System.out.println();
            return 0;
        }
    }

    public static double difficultyLevel(int choice) {
        SecureRandom ran = new SecureRandom();
        double r1 = 0.0;

        switch (choice) {
            case 1:
                r1 = ran.nextInt(9) + 1;
                break;
            case 2:
                r1 = ran.nextInt(99) + 1;
                break;
            case 3:
                r1 = ran.nextInt(999) + 1;
                break;
            case 4:
                r1 = ran.nextInt(9999) + 1;
                break;
        }
        return r1;
    }

    public static int problemType() {
        int choice;
        System.out.println("Select type of problem to be studied:");
        System.out.println("1 - Addition");
        System.out.println("2 - Multiplication");
        System.out.println("3 - Subtraction");
        System.out.println("4 - Division");
        System.out.println("5 - Mixture");
        choice = scnr.nextInt();
        return choice;
    }

    public static void main(String[] args) {
        double r1;
        double r2;

        boolean keepGoing = true;
        int contVal, choice, type;

        while (keepGoing) {
            System.out.println("Welcome to the Mathematics Review Program!");
            System.out.println();

            System.out.println("Select difficulty level (1 - 4): ");
            choice = scnr.nextInt();
            r1 = difficultyLevel(choice);
            r2 = difficultyLevel(choice);
            type = problemType();

            askQuestions(r1, r2, type, choice);

            System.out.println("Would you like to begin a new session? (1 for yes, 2 for no)");
            contVal = scnr.nextInt();
            if (contVal == 1) {
                keepGoing = true;
            } else {
                keepGoing = false;
            }
        }
    }
}