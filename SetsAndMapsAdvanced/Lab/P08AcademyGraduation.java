/*
8. Academy Graduation
        Write a program that:
        • Reads from console number of students for a track.
        • Reads on pair of rows:
        o The first line is the name of the student.
        o The second line is his score for a different number of courses.
        • Print on console "{name} is graduated with {average scores)".
*/


import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numStudents = Integer.parseInt(scanner.nextLine());
        Map<String, Double[]> gradesPerStudent = new TreeMap<>();

        for (int i = 0; i < numStudents; i++) {
            String name = scanner.nextLine();
            String[] inputocenki = scanner.nextLine().split(" ");
            Double[] grades = new Double[inputocenki.length];

            for (int j = 0; j < inputocenki.length; j++) {
                grades[j] = Double.parseDouble(inputocenki[j]);
            }
            gradesPerStudent.put(name, grades);
        }

        for (String name : gradesPerStudent.keySet()) {
            Double[] grades = gradesPerStudent.get(name);
            double sum = 0;
            for (Double gradess : grades) {
                sum += gradess;
            }
            //DecimalFormat decimalFormat = new DecimalFormat("#.########");
            //System.out.printf("%s is graduated with %s%n", name, decimalFormat.format(sum / grades.length));

            System.out.printf("%s is graduated with %s%n", name, Double.toString(sum / grades.length));
        }
    }
}
