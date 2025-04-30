import java.util.*;
import java.util.stream.*;

class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    String transactionDate;
    boolean isFraudulent;

    public Transaction(String transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }
}

class FraudStats {
    String policyNumber;
    int count;
    double totalAmount;

    public FraudStats(String policyNumber, int count, double totalAmount) {
        this.policyNumber = policyNumber;
        this.count = count;
        this.totalAmount = totalAmount;
    }

    public String toString() {
        return policyNumber + " | Fraud Count: " + count + " | Total Fraud Amount: $" + totalAmount;
    }
}

public class FraudDetector {

    public static List<FraudStats> detectFraud(List<Transaction> transactions) {
        Map<String, List<Transaction>> grouped = transactions.stream()
            .filter(t -> t.isFraudulent && t.amount > 10000)
            .collect(Collectors.groupingBy(t -> t.policyNumber));

        List<FraudStats> alerts = grouped.entrySet().stream()
            .map(entry -> {
                String policy = entry.getKey();
                List<Transaction> fraudTxns = entry.getValue();
                int count = fraudTxns.size();
                double total = fraudTxns.stream().mapToDouble(t -> t.amount).sum();
                return new FraudStats(policy, count, total);
            })
            .filter(fs -> fs.count > 5 || fs.totalAmount > 50000)
            .collect(Collectors.toList());

        return alerts;
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("T1", "P1", 12000, "2024-01-01", true),
            new Transaction("T2", "P1", 15000, "2024-01-03", true),
            new Transaction("T3", "P1", 13000, "2024-01-04", true),
            new Transaction("T4", "P1", 14000, "2024-01-05", true),
            new Transaction("T5", "P1", 16000, "2024-01-06", true),
            new Transaction("T6", "P1", 11000, "2024-01-07", true),
            new Transaction("T7", "P2", 60000, "2024-01-02", true),
            new Transaction("T8", "P2", 8000, "2024-01-03", true),
            new Transaction("T9", "P3", 20000, "2024-01-10", false)
        );

        List<FraudStats> flagged = detectFraud(transactions);
        System.out.println("ALERT: Suspicious Policies");
        flagged.forEach(System.out::println);
    }
}

