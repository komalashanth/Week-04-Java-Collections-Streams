import java.util.*;
import java.util.stream.*;

class InsurancePolicy {
    String policyNumber;
    String holderName;
    double premiumAmount;

    public InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Holder: " + holderName + ", Premium: $" + premiumAmount;
    }
}

public class InsuranceApplication {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("P123", "John Doe", 1500),
            new InsurancePolicy("P124", "Jane Smith", 800),
            new InsurancePolicy("P125", "Mary Johnson", 2500),
            new InsurancePolicy("P126", "Robert Brown", 1800),
            new InsurancePolicy("P127", "Michael White", 2100)
        );

        List<InsurancePolicy> highPremiumPolicies = policies.stream()
            .filter(policy -> policy.premiumAmount > 1200)
            .collect(Collectors.toList());
        highPremiumPolicies.forEach(System.out::println);

        List<InsurancePolicy> sortedByHolderName = policies.stream()
            .sorted(Comparator.comparing(policy -> policy.holderName))
            .collect(Collectors.toList());
        sortedByHolderName.forEach(System.out::println);

        double totalPremium = policies.stream()
            .mapToDouble(policy -> policy.premiumAmount)
            .sum();
        System.out.println("Total Premium: $" + totalPremium);

        policies.forEach(policy -> System.out.println(policy));

        List<InsurancePolicy> premiumRangePolicies = policies.stream()
            .filter(policy -> policy.premiumAmount >= 1000 && policy.premiumAmount <= 2000)
            .collect(Collectors.toList());
        premiumRangePolicies.forEach(System.out::println);

        InsurancePolicy highestPremiumPolicy = policies.stream()
            .max(Comparator.comparingDouble(policy -> policy.premiumAmount))
            .orElse(null);
        System.out.println(highestPremiumPolicy);

        Map<Character, List<InsurancePolicy>> policiesByInitial = policies.stream()
            .collect(Collectors.groupingBy(policy -> policy.holderName.charAt(0)));
        policiesByInitial.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach(System.out::println);
        });

        double averagePremium = policies.stream()
            .mapToDouble(policy -> policy.premiumAmount)
            .average()
            .orElse(0);
        System.out.println("Average Premium: $" + averagePremium);

        List<InsurancePolicy> sortedByPremium = policies.stream()
            .sorted(Comparator.comparingDouble(policy -> policy.premiumAmount))
            .collect(Collectors.toList());
        sortedByPremium.forEach(System.out::println);

        boolean anyExceeds = policies.stream()
            .anyMatch(policy -> policy.premiumAmount > 2000);
        System.out.println(anyExceeds);

        Map<String, Long> premiumRangeCount = policies.stream()
            .collect(Collectors.groupingBy(policy -> {
                if (policy.premiumAmount <= 1000) return "$0-$1,000";
                else if (policy.premiumAmount <= 2000) return "$1,001-$2,000";
                else return ">$2,000";
            }, Collectors.counting()));
        premiumRangeCount.forEach((range, count) -> System.out.println(range + ": " + count));

        List<String> uniqueHolderNames = policies.stream()
            .map(policy -> policy.holderName)
            .distinct()
            .collect(Collectors.toList());
        uniqueHolderNames.forEach(System.out::println);
    }
}

