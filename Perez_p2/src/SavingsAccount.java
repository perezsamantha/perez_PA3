class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double initialAmount) {
        this.savingsBalance = initialAmount;
    }

    public void calculateMonthlyInterest() {
        this.savingsBalance += this.savingsBalance * annualInterestRate / 12;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public static void modifyInterestRate(double newInterestRate) {
        annualInterestRate = newInterestRate;
    }
}
