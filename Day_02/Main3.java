import java.util.*;


abstract class CourseType {
    String title;

    public CourseType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract String getEvaluationMethod();
}


class ExamCourse extends CourseType {
    public ExamCourse(String title) {
        super(title);
    }

    @Override
    public String getEvaluationMethod() {
        return "Exam-Based Evaluation";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title) {
        super(title);
    }

    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based Evaluation";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String title) {
        super(title);
    }

    @Override
    public String getEvaluationMethod() {
        return "Research-Based Evaluation";
    }
}


class Course<T extends CourseType> {
    private T courseType;

    public Course(T courseType) {
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    public void showCourseDetails() {
        System.out.println("Course: " + courseType.getTitle() + " | Evaluation: " + courseType.getEvaluationMethod());
    }
}


class University {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println("Course: " + course.getTitle() + " | Evaluation: " + course.getEvaluationMethod());
        }
    }
}

public class Main3 {
    public static void main(String[] args) {
        
        Course<ExamCourse> math = new Course<>(new ExamCourse("Mathematics"));
        Course<AssignmentCourse> cs = new Course<>(new AssignmentCourse("Computer Science"));
        Course<ResearchCourse> ai = new Course<>(new ResearchCourse("Artificial Intelligence Research"));

        
        math.showCourseDetails();
        cs.showCourseDetails();
        ai.showCourseDetails();

        
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(new ExamCourse("Physics"));
        allCourses.add(new AssignmentCourse("Software Engineering"));
        allCourses.add(new ResearchCourse("Quantum Computing"));

        System.out.println("\n--- All Courses in University ---");
        University.displayAllCourses(allCourses);
    }
}

