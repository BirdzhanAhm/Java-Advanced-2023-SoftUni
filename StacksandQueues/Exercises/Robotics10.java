/*
10. **Robotics
        Somewhere in the future, there will be a robotics factory. The current project is assembly-line robots.
        Each robot has a processing time, the time it needs to process a product. When a robot is free, it should take a
        product for processing and log its name, product, and processing start time.
        Each robot processes a product coming from the assembly line. A product comes from the line each second (so the
        first product should appear at [start time + 1 second]). If a product passes the line and there is no free robot to take
        it, it should be queued at the end of the line again.
        The robots are standing in the line in the order of their appearance.
        Input
        • On the first line, you will get the names of the robots and their processing times in the format
        "robotName-processTime;robotName-processTime;robotName-processTime".
        • On the second line, you will get the starting time in the format "hh:mm:ss".
        • Next, until the "End" command, you will get a product on each line.
*/

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputRobot = scanner.nextLine().split(";"); //всички роботи с времената
        LinkedHashMap<String, Integer> robots = getLinkedHashMap(inputRobot);
        String time = scanner.nextLine(); //час:минути:секунди
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        int seconds = Integer.parseInt(time.split(":")[2]);

        long totalTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

        ArrayDeque<String> products = new ArrayDeque<>();
        int [] workingTime = new int[robots.size()];

        String product = scanner.nextLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }

        while(!products.isEmpty()){
            String currentProduct = products.poll();
            //увеличим текущото време
            totalTimeInSeconds++;
            boolean isAssigned = false;
            //намаляме работното време с 1 секунда
            for (int robot = 0; robot < workingTime.length; robot++) {
                if(workingTime[robot] > 0) {
                    --workingTime[robot];
                }
            }
            //обхождане на работното време
            for (int i = 0; i < workingTime.length; i++) {
                if(workingTime[i] == 0) {
                    //свободен -> кой е робота -> времето
                    int count = 0;
                    for (Map.Entry<String, Integer> robot : robots.entrySet()){
                        if (count == i) {
                            workingTime[i] = robot.getValue();
                            //totalSeconds -> hours, minute, seconds
                            long takenHour =  totalTimeInSeconds / 3600 % 24;
                            long takenMinute = totalTimeInSeconds % 3600 / 60;
                            long takenSeconds = totalTimeInSeconds % 60;
                            System.out.printf("%s - %s [%02d:%02d:%02d]%n", robot.getKey(), currentProduct, takenHour, takenMinute, takenSeconds);
                            isAssigned =  true;
                            break;
                        }
                        count++;
                    }
                    break;
                }
            }
            //проверили всички роботи
            if(!isAssigned) {
                products.offer(currentProduct);
            }

        }



    }

    private static LinkedHashMap<String, Integer> getLinkedHashMap(String[] inputRobot) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (int i = 0; i < inputRobot.length ; i++) {
            //name-time -> ["ROB", "15"]
            String name = inputRobot[i].split("-")[0];
            int time = Integer.parseInt(inputRobot[i].split("-")[1]);
            robots.put(name, time);
        }
        return robots;
    }
}
