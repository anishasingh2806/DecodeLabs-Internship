import java.util.Scanner;

// ==========================================
// 1. DATA LAYER (STUDENT DATA MODEL)
// ==========================================
/**
 * Represents the Student Data Entity.
 * Responsible solely for holding raw state variables (Single Responsibility Principle).
 */
class Student {
    private final String name;
    private final int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int[] getMarks() {
        return marks;
    }
}

// ==========================================
// 2. LOGIC LAYER (RULES EXECUTION CORE ENGINE)
// ==========================================
/**
 * Acts as a lightweight Business Rules Management System (BRMS).
 * Encapsulates all calculation logic and logical ladders.
 */
class GradeCalculator {

    public int calculateTotalMarks(Student student) {
        int total = 0; // The Accumulator Loop (Page 13)
        for (int mark : student.getMarks()) {
            total += mark;
        }
        return total;
    }

    public double calculateAveragePercentage(int totalMarks, int totalSubjects) {
        if (totalSubjects == 0) return 0.0;
        // Preserving Precision via explicit double type casting to avoid integer division truncation (Page 15)
        return (double) totalMarks / totalSubjects;
    }

    public char assignGrade(double percentage) {
        // The Logic Ladder: Checking the strictest conditions first from the top bucket downward (Page 16)
        if (percentage >= 90.0) {
            return 'A';
        } else if (percentage >= 80.0) {
            return 'B';
        } else if (percentage >= 70.0) {
            return 'C';
        } else if (percentage >= 60.0) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public String evaluatePassStatus(char grade) {
        // Custom feature implementation: Portfolio Pass/Fail indicator (Page 25)
        return (grade != 'F') ? "PASSED" : "FAILED";
    }
}

// ==========================================
// 3. PRESENTATION LAYER (REPORT GENERATOR VIEW)
// ==========================================
/**
 * Manages clean layout formatting and final data delivery presentations.
 */
class ReportGenerator {

    public void displayPerformanceReport(Student student, int totalMarks, double averagePercentage, char grade, String status) {
        System.out.println("\n=============================================");
        System.out.println("          ACADEMIC PERFORMANCE REPORT        ");
        System.out.println("=============================================");
        System.out.printf(" Student Name      : %s\n", student.getName());
        System.out.printf(" Total Subjects    : %d\n", student.getMarks().length);
        System.out.printf(" Total Marks Earned: %d\n", totalMarks);
        
        // Mastering Precision Specifiers: Employs %.2f%% to avoid ugly decimal tail values (Page 18 & 19)
        System.out.printf(" Average Percentage: %.2f%%\n", averagePercentage);
        System.out.printf(" Assigned Grade    : Grade %c\n", grade);
        System.out.println("---------------------------------------------");
        System.out.printf(" Final Outcome     : Status -> %s\n", status);
        System.out.println("=============================================");
    }
}

// ==========================================
// 4. MAIN ORCHESTRATION LAYER (THE RUNTIME ENTRY)
// ==========================================
public class DecodeLabs_Java_P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeCalculator calculator = new GradeCalculator();
        ReportGenerator reportGenerator = new ReportGenerator();

        System.out.println("=============================================");
        System.out.println("    DECODELABS DETERMINISTIC GRADE ENGINE    ");
        System.out.println("=============================================");

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine().trim();

        int numberOfSubjects = 0;
        // Prompt for subject counts securely
        while (true) {
            System.out.print("Enter Number of Subjects to Evaluate: ");
            try {
                // Robust String Parsing Strategy to completely neutralize the Scanner Buffer Trap (Page 11)
                numberOfSubjects = Integer.parseInt(scanner.nextLine().trim());
                if (numberOfSubjects > 0) {
                    break;
                }
                System.out.println("Error: Total count must be at least 1.");
            } catch (NumberFormatException e) {
                System.out.println("Malformed Token: Please input a clean integer digit.");
            }
        }

        int[] subjectMarks = new int[numberOfSubjects];

        // Iterative Data Acquisition Loop with Defensive Boundaries (Page 17)
        for (int i = 0; i < numberOfSubjects; i++) {
            while (true) {
                System.out.printf("Enter marks for Subject %d (0-100): ", (i + 1));
                try {
                    // Protecting buffer lines using strict string parsing directly
                    int mark = Integer.parseInt(scanner.nextLine().trim());
                    
                    // Defensive Programming Boundaries validation verification
                    if (mark >= 0 && mark <= 100) {
                        subjectMarks[i] = mark;
                        break; // Data authenticated, exit validation loop
                    }
                    System.out.println("Validation Error: Score parameters break threshold boundaries! Must fall between 0 and 100.");
                } catch (NumberFormatException e) {
                    System.out.println("Malformed Token: Non-numeric parameters rejected. Input whole integers only.");
                }
            }
        }

        // Initialize entities and execute internal logic flow (Page 20)
        Student student = new Student(name, subjectMarks);
        int totalMarks = calculator.calculateTotalMarks(student);
        double averagePercentage = calculator.calculateAveragePercentage(totalMarks, numberOfSubjects);
        char assignedGrade = calculator.assignGrade(averagePercentage);
        String passStatus = calculator.evaluatePassStatus(assignedGrade);

        // Print final report presentation layer
        reportGenerator.displayPerformanceReport(student, totalMarks, averagePercentage, assignedGrade, passStatus);

        scanner.close();
    }
}
