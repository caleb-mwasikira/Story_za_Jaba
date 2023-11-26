import Bank.CreditCard;

public class Main {
    public static int NUM_TRANSACTIONS = 10;

    public static void main(String[] args) {
        CreditCard card = new CreditCard("John Doe", "Bank of America");

        for (int i = 0; i < NUM_TRANSACTIONS; i++) {
            double randomPrice = (1000 * Math.random());

            card.charge(randomPrice);
            System.out.println("Balance is now " + card.getBalance() + "\n");
        }

        card.printCreditCardStatement();
    }
}


