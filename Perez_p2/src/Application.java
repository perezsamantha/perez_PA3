public class Application {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        double interestRate;

        System.out.println("Month\tSaver 1\t\tSaver 2");
        System.out.println("-------------------------------");

        interestRate = 0.04;
        SavingsAccount.modifyInterestRate(interestRate);
        System.out.println("Interest rate set to " + (interestRate * 100) + "%");

        for (int i = 1; i <= 12; i++) {
            System.out.print(i + "\t\t");
            saver1.calculateMonthlyInterest();
            System.out.printf("%.2f", saver1.getSavingsBalance());
            System.out.print("\t\t");
            saver2.calculateMonthlyInterest();
            System.out.printf("%.2f", saver2.getSavingsBalance());
            System.out.println();
        }

        interestRate = 0.05;
        SavingsAccount.modifyInterestRate(interestRate);
        System.out.println("Interest rate set to " + (interestRate * 100) + "%");

        System.out.print("13 \t\t");
        saver1.calculateMonthlyInterest();
        System.out.printf("%.2f", saver1.getSavingsBalance());
        System.out.print("\t\t");
        saver2.calculateMonthlyInterest();
        System.out.printf("%.2f", saver2.getSavingsBalance());
    }
}
