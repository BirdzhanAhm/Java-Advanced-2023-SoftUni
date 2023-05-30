/*5. Average Students Grades
        Write a program, which reads the name of a student and their grades and adds them to the student record, then
        prints grades along with their average grade – ordered the output by the students' names.
        Input
        On the first line N – the number of students, then on the next, N lines student name with grade.
        Hints
        • Use a TreeMap (String -> ArrayList<Double>).
        • Check if the name exists before adding the grade. If it doesn't, add it to the map.
        • Pass through all key-value pairs in the map and print the results.
        • Think of a way to get the average grades for each student.
        o You can do that with an ordinary loop or with Stream API.
        */

import java.util.*;

public class P05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> mapStudentDate = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String[] inputDate = scanner.nextLine().split(" ");
            String name = inputDate[0];
            Double grade = Double.parseDouble(inputDate[1]);

            if (!mapStudentDate.containsKey(name)) {
                mapStudentDate.put(name, new ArrayList<>());
                mapStudentDate.get(name).add(grade);
            } else {
                mapStudentDate.get(name).add(grade);
            }
        }

        for (Map.Entry<String, List<Double>> entry : mapStudentDate.entrySet()) {
            double avg = 0;
            System.out.print(entry.getKey() + " -> ");

            for (Double number : entry.getValue()) {
                avg += number;
                System.out.printf("%.2f ", number);
            }
            avg /= entry.getValue().size();
            System.out.printf("(avg: %.2f)%n", avg);

        }
    }
}
