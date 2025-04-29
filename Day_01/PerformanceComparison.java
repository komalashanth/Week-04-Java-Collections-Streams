import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class PerformanceComparison {
    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();
        Random random = new Random();

        List<Policy> policies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            policies.add(new Policy(
                "PN" + i,
                "Holder" + i,
                LocalDate.now().plusDays(random.nextInt(365)),
                i % 2 == 0 ? "Health" : "Auto",
                random.nextDouble() * 10000
            ));
        }

        long start = System.currentTimeMillis();
        system.addPolicies(policies);
        long end = System.currentTimeMillis();
        System.out.println("Time to add policies to all sets (HashSet, LinkedHashSet, TreeSet): " + (end - start) + " ms");

       
    }
}


