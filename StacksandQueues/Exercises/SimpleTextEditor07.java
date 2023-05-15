import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); //Broy Komandi
        ArrayDeque<String> stack = new ArrayDeque<>(); // Steck za sahranenie na poslednite promeni
        StringBuilder currentText = new StringBuilder(); //Prazen Textbox za pravene na korekciii

        for (int i = 1; i <=n ; i++) {
            String command = scanner.nextLine();
            if(command.startsWith("1")){
                stack.push(currentText.toString());
                String toAppend = command.split("\\s+")[1];
                currentText.append(toAppend);
            }else if (command.startsWith("2")){
                stack.push(currentText.toString());
                int count = Integer.parseInt(command.split("\\s+")[1]);
                int StartDeleteIndex = currentText.length()-count;
                currentText.delete(StartDeleteIndex,currentText.length());
            }else if (command.startsWith("3")) {
                int position = Integer.parseInt(command.split("\\s+")[1]);
                System.out.println(currentText.charAt(position-1));

            }else if(command.startsWith("4")){
                if (!stack.isEmpty()) {
                    String last = stack.pop();
                    currentText = new StringBuilder(last);
                }
            }

        }


    }
}
