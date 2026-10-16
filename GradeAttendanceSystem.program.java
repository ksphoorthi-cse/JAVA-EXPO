
import java.util.Scanner;

public class GradeAttendanceSystem {

    public static double calculateAttendancePercentage(int attended, int total) {
        if (total == 0) return 0.0;
        return (attended * 100.0) / total;
    }

    public static double getGradePoint(double marks) {
        if (marks >= 90) return 4.0;
        else if (marks >= 80) return 3.5;
        else if (marks >= 70) return 3.0;
        else if (marks >= 60) return 2.5;
        else if (marks >= 50) return 2.0;
        else return 0.0;
    }

    public static String getGrade(double marks) {
        if (marks >= 90) return "A";
        else if (marks >= 80) return "B";
        else if (marks >= 70) return "C";
        else if (marks >= 60) return "D";
        else if (marks >= 50) return "E";
        else return "F";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalSubjects = 3;
        int totalClasses = 40;

        String[] subjects = {
            "Mathematics", "Computer Science", "English"
        };

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] names = new String[n];
        double[] cgpa = new double[n];

        int[][] attendance = new int[n][totalSubjects];
        double[][] marks = new double[n][totalSubjects];

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter student name: ");
            names[i] = sc.nextLine();

            double totalPoints = 0;

            for (int j = 0; j < totalSubjects; j++) {
                System.out.println("Subject: " + subjects[j]);

                System.out.print("Classes attended (out of 40): ");
                attendance[i][j] = sc.nextInt();

                System.out.print("Enter marks (0-100): ");
                marks[i][j] = sc.nextDouble();

                totalPoints += getGradePoint(marks[i][j]);
            }
            sc.nextLine();

            cgpa[i] = totalPoints / totalSubjects;
        }

        System.out.println("\n--- UNIVERSITY REPORT ---");

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent: " + names[i]);
            System.out.printf("CGPA: %.2f%n", cgpa[i]);

            for (int j = 0; j < totalSubjects; j++) {
                double percent = calculateAttendancePercentage(
                    attendance[i][j], totalClasses
                );

                System.out.printf(
                    "%s | Marks: %.1f | Grade: %s | Attendance: %.1f%%",
                    subjects[j], marks[i][j], getGrade(marks[i][j]), percent
                );

                if (percent < 75)
                    System.out.print(" | Low attendance");
                else if (marks[i][j] < 50)
                    System.out.print(" | Failed");
                else
                    System.out.print(" | Passed");

                System.out.println();
            }
        }

        sc.close();
    }
}


