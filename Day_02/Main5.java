import java.util.*;


abstract class JobRole {
    String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public abstract String getRequiredSkills();
}


class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    @Override
    public String getRequiredSkills() {
        return "Java, Data Structures, Algorithms, System Design";
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }

    @Override
    public String getRequiredSkills() {
        return "Python, Machine Learning, Statistics, SQL";
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }

    @Override
    public String getRequiredSkills() {
        return "Leadership, Roadmapping, Agile, Communication";
    }
}


class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public void processResume() {
        System.out.println("Processing resume of: " + jobRole.getCandidateName());
        System.out.println("Required Skills: " + jobRole.getRequiredSkills());
    }

    public T getJobRole() {
        return jobRole;
    }
}


class ResumeScreeningSystem {
    public static <T extends JobRole> void screenResume(Resume<T> resume) {
        System.out.println("Screening for role: " + resume.getJobRole().getClass().getSimpleName());
        resume.processResume();
    }

    public static void screenMultipleResumes(List<? extends JobRole> candidates) {
        for (JobRole role : candidates) {
            System.out.println("Screening candidate: " + role.getCandidateName());
            System.out.println("Skills matched: " + role.getRequiredSkills());
            System.out.println("---");
        }
    }
}


public class Main5 {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice"));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob"));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Charlie"));


        ResumeScreeningSystem.screenResume(seResume);
        ResumeScreeningSystem.screenResume(dsResume);
        ResumeScreeningSystem.screenResume(pmResume);

        System.out.println("\n--- Batch Screening ---");

        List<JobRole> candidateList = new ArrayList<>();
        candidateList.add(new SoftwareEngineer("David"));
        candidateList.add(new DataScientist("Eva"));
        candidateList.add(new ProductManager("Frank"));

        ResumeScreeningSystem.screenMultipleResumes(candidateList);
    }
}

