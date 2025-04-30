import java.util.*;
import java.util.stream.*;

class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    String claimDate;
    String status;

    public Claim(String claimId, String policyNumber, double claimAmount, String claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
}

class PolicyClaimStats {
    String policyNumber;
    double totalAmount;
    double averageAmount;

    public PolicyClaimStats(String policyNumber, double totalAmount, double averageAmount) {
        this.policyNumber = policyNumber;
        this.totalAmount = totalAmount;
        this.averageAmount = averageAmount;
    }

    public String toString() {
        return policyNumber + " | Total: $" + totalAmount + " | Average: $" + averageAmount;
    }
}

public class ClaimsAnalyzer {

    public static List<PolicyClaimStats> analyzeClaims(List<Claim> claims) {
        Map<String, List<Claim>> groupedClaims = claims.stream()
            .filter(c -> c.status.equals("Approved") && c.claimAmount > 5000)
            .collect(Collectors.groupingBy(c -> c.policyNumber));

        List<PolicyClaimStats> statsList = groupedClaims.entrySet().stream()
            .map(entry -> {
                String policy = entry.getKey();
                List<Claim> policyClaims = entry.getValue();
                double total = policyClaims.stream().mapToDouble(c -> c.claimAmount).sum();
                double avg = total / policyClaims.size();
                return new PolicyClaimStats(policy, total, avg);
            })
            .sorted(Comparator.comparingDouble((PolicyClaimStats pcs) -> -pcs.totalAmount))
            .limit(3)
            .collect(Collectors.toList());

        return statsList;
    }

    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("C1", "P100", 6000, "2024-01-10", "Approved"),
            new Claim("C2", "P100", 7000, "2024-01-15", "Approved"),
            new Claim("C3", "P200", 8000, "2024-02-01", "Rejected"),
            new Claim("C4", "P200", 9000, "2024-02-05", "Approved"),
            new Claim("C5", "P300", 15000, "2024-03-12", "Approved"),
            new Claim("C6", "P300", 2000, "2024-03-15", "Approved"),
            new Claim("C7", "P400", 12000, "2024-04-01", "Approved"),
            new Claim("C8", "P400", 4000, "2024-04-03", "Approved"),
            new Claim("C9", "P500", 3000, "2024-05-05", "Approved")
        );

        List<PolicyClaimStats> result = analyzeClaims(claims);
        System.out.println("Top 3 Policies by Total Claim Amount:");
        result.forEach(System.out::println);
    }
}

