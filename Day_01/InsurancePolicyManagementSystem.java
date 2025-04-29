import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManagementSystem {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("All Policies (HashSet):");
        for (Policy p : hashSetPolicies) {
            System.out.println(p);
        }
    }

    public void displayPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);

        System.out.println("Policies Expiring Within 30 Days (TreeSet):");
        for (Policy p : treeSetPolicies) {
            if (!p.getExpiryDate().isAfter(threshold)) {
                System.out.println(p);
            }
        }
    }

    public void displayPoliciesByCoverageType(String coverageType) {
        System.out.println("Policies with Coverage Type: " + coverageType);
        for (Policy p : hashSetPolicies) {
            if (p.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(p);
            }
        }
    }

    public void findDuplicatePolicies() {
        Map<String, Integer> map = new HashMap<>();
        for (Policy p : hashSetPolicies) {
            map.put(p.getPolicyNumber(), map.getOrDefault(p.getPolicyNumber(), 0) + 1);
        }

        System.out.println("Duplicate Policies:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Policy Number: " + entry.getKey() + ", Count: " + entry.getValue());
            }
        }
    }
}

