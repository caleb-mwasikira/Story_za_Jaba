package Bank;

public class CreditCard {
    final private String customer;
    final private String bank;
    final private String account;

    final private double limit; // The amount of debt a credit card can accrue
    protected double debt; // Debt (amount of money owed) accrued on a credit card

    public CreditCard(String _customer, String _bank) {
        this.customer = _customer;
        this.bank = _bank;
        this.account = this.generateAccountNumber(Bank.ACC_NUM_SIZE);
        this.limit = 2_000;
        this.debt = 0.0;

        this.printCreditCardStatement();
    }

    public void printCreditCardStatement() {
        System.out.println("Credit card: " + this.customer + "@" + this.bank);
        System.out.println("Account Number: " + this.account);
        System.out.println("Limit: " + this.limit);
        System.out.println("Balance: " + this.getBalance() + "\n\n");
    }

    /**
     * Function to generate a random string of length n
     */
    private String generateAccountNumber(int n) {
        // choose a Character random from this String
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of alphaNumericString
        StringBuilder buffer = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to alphaNumericString variable length
            int index
                    = (int) (alphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of buffer
            buffer.append(alphaNumericString
                    .charAt(index));
        }

        return buffer.toString();
    }

    public String getCustomer() {
        return this.customer;
    }

    public String getBank() {
        return this.bank;
    }

    public String getAccount() {
        return this.account;
    }

    public double getLimit() {
        return this.limit;
    }

    /**
     * Amount of credit (borrow-able money) left on a card
     */
    public double getBalance() {
        return this.limit - this.debt;
    }

    /**
     * Accumulation of debt
     *
     * @return boolean represents whether the transaction was successful or not
     */
    public boolean charge(double price) {
        System.out.println("Charging " + price + " on credit card " + this.account);

        if (price <= 0) {
            return false;
        }

        if ((this.debt + price) > limit) {
            // Cannot accrue further debt
            System.out.println("Transaction failed. Credit limit reached!");
            return false;
        }

        // Make transaction and increase credit card's debt
        this.debt += price;
        System.out.println("Transaction successful.");
        return true;
    }

    /**
     * Payment of debt(amount of money owed) accrued on credit card
     */
    public void makePayment(double amount) {
        if (amount <= 0) {
            return;
        }

        System.out.println("Received payment of " + amount + " on credit card " + this.account);
        this.debt -= amount;
    }
}
