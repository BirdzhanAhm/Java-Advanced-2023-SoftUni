import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //Broy elementi koito trqbva da dobavim
        int s = scanner.nextInt(); //Broy elementi koito trqbva da se mahnat
        int x = scanner.nextInt();     // Chislo koeto plroverqvame dali go ima
        ArrayDeque queue = new ArrayDeque(); // sazdavame Opashka

        for (int i = 1; i <= n; i++) {
            queue.add(scanner.nextInt());
        }
        for (int i = 1; i <=s ; i++) {
            queue.poll();
        }
        if(queue.contains(x)){
            System.out.println("true");
        }else if (queue.isEmpty()){
            System.out.println(0);
        }else {
            System.out.println(Collections.min(queue));
        }

    }
}
