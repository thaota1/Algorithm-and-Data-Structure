// Define an enum to represent student performance categories
enum StudentType {
    EXCELLENT, OK, FAILURE
}

class Student {
    private String firstName;
    private String lastName;
    private int grade;
    private StudentType type;

    // Static variables to count students in each category
    static int excellentCount = 0;
    static int okCount = 0;
    static int failureCount = 0;

    // Static variables to store the total grades of each category
    static int excellentTotal = 0;
    static int okTotal = 0;
    static int failureTotal = 0;

    public Student(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.type = determineType();
        
        // Categorize and update counts and totals
        if (type == StudentType.EXCELLENT) {
            excellentCount++;
            excellentTotal += grade;
        } else if (type == StudentType.OK) {
            okCount++;
            okTotal += grade;
        } else {
            failureCount++;
            failureTotal += grade;
        }
    }

    // Determine the student type based on the grade
    private StudentType determineType() {
        if (grade > 89) {
            return StudentType.EXCELLENT;
        } else if (grade >= 60 && grade <= 89) {
            return StudentType.OK;
        } else {
            return StudentType.FAILURE;
        }
    }

    // Override the toString method to print student details
    @Override
    public String toString() {
        return firstName + " " + lastName + " with grade " + grade + " is " + type;
    }

    // Static method to print category statistics
    public static void printStatistics() {
        System.out.println("\nCategory Statistics:");
        if (excellentCount > 0)
            System.out.println("Excellent: " + excellentCount + " students, Average Grade: " + (double)excellentTotal / excellentCount);
        if (okCount > 0)
            System.out.println("OK: " + okCount + " students, Average Grade: " + (double)okTotal / okCount);
        if (failureCount > 0)
            System.out.println("Failure: " + failureCount + " students, Average Grade: " + (double)failureTotal / failureCount);
    }
}
