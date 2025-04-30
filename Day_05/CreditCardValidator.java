public class CreditCardValidator {
    public static boolean isValidCreditCard(String cardNumber) {
        if (cardNumber.length() != 16) return false;

        if (cardNumber.startsWith("4")) {
            return true;
        } else if (cardNumber.startsWith("5")) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String[] cardNumbers = {"4111222233334444", "5111222233334444", "6111222233334444", "411122223333444"};

        for (String cardNumber : cardNumbers) {
            System.out.println(cardNumber + " → " + (isValidCreditCard(cardNumber) ? "Valid" : "Invalid"));
        }
    }
}

