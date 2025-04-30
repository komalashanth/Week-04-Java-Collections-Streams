import java.util.*;
import java.util.stream.*;

class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

class RiskAssessment {
    String holderId;
    String name;
    double riskScore;

    public RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    public String toString() {
        return holderId + " | " + name + " | Risk Score: " + riskScore;
    }
}

public class RiskAssessor {

    public static Map<String, List<RiskAssessment>> assessRisk(List<PolicyHolder> holders) {
        List<RiskAssessment> assessments = holders.stream()
            .filter(h -> h.policyType.equals("Life") && h.age > 60)
            .map(h -> new RiskAssessment(h.holderId, h.name, h.premiumAmount / h.age))
            .sorted(Comparator.comparingDouble((RiskAssessment r) -> -r.riskScore))
            .collect(Collectors.toList());

        Map<String, List<RiskAssessment>> categorized = assessments.stream()
            .collect(Collectors.groupingBy(r -> r.riskScore > 0.5 ? "High Risk" : "Low Risk"));

        return categorized;
    }

    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
            new PolicyHolder("H1", "Alice", 65, "Life", 40000),
            new PolicyHolder("H2", "Bob", 70, "Life", 30000),
            new PolicyHolder("H3", "Charlie", 62, "Health", 20000),
            new PolicyHolder("H4", "David", 75, "Life", 25000),
            new PolicyHolder("H5", "Eve", 80, "Life", 50000),
            new PolicyHolder("H6", "Frank", 59, "Life", 60000)
        );

        Map<String, List<RiskAssessment>> result = assessRisk(holders);

        result.forEach((category, list) -> {
            System.out.println(category + ":");
            list.forEach(System.out::println);
            System.out.println();
        });
    }
}

