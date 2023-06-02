/*
8.*User Logs
        Marian is a famous system administrator. The person to overcome the security of his servers has not yet been born. However, there is a new type of threat where users flood the server with messages that are hard to be detected since they change their IP address all the time. Well, Marian is a system administrator and is not so into programming. Therefore, he needs a skillful programmer to track the user logs of his servers. You are the chosen one to help him!
        You are given an input in the format:
        "IP={IP.Address} message={A&sample&message} user={username}"
        Your task is to parse the IP and the username from the input, and for every user, you have to display every IP from which the corresponding user has sent a message and the count of the messages sent with the corresponding IP. In the output, the usernames must be sorted alphabetically, while their IP addresses should be displayed in the order of their first appearance. The output should be in the following format:
        "username:
        {IP} => {count}, {IP} => {count}."
        For example, given the following input - IP=192.23.30.40 message='Hello&derps.' user=destroyer, you have to get the username destroyer and the IP 192.23.30.40 and display it in the following format:
        "destroyer:
        192.23.30.40 => 1. "
        The username destroyer has sent a message from IP 192.23.30.40 once.
        Check the examples below. They will further clarify the assignment.
        Input
        The input comes from the console as a varying number of lines. You have to parse every command until the command that follows is "end". The input will be in the format displayed above. There is no need to check it explicitly.
        Output
        For every user found, you have to display each log in the format:
        The IP addresses must be split with a comma, and each line of IP addresses must end with a dot.
        Constraints
        •	The number of commands will be in the range [1..50].
        •	The IP addresses will be in the format of either IPv4 or IPv6
        o	Example: IPv4 - 123.45.67.89 , IPv6 - 2001:db8::ff00:42:8329
        •	The messages will be in the format: This&is&a&message.
        •	The username will be a string with a length in the range [3..50].
        •	Time limit: 300ms/16MB.

*/


import java.util.*;

public class P08_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> data = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end")){
            String ip = input.split("\\s+")[0].split("=")[1];
         //   String msg = input.split("\\s+")[1].split("=")[1]; //not nesseserry
            String username = input.split("\\s+")[2].split("=")[1];

            if(!data.containsKey(username)){
                data.put(username, new LinkedHashMap<>());
            }
            Map<String, Integer> currentIps = data.get(username);
                if(!currentIps.containsKey(ip)){
                    currentIps.put(ip, 1);
                }else {
                    currentIps.put(ip, currentIps.get(ip)+1);
                }

            input = scanner.nextLine();
        }

        for (String username:data.keySet()) {
            System.out.println(username+ ": ");
            Map<String, Integer> currentIps = data.get(username);
            int countIps = currentIps.size();
            for(String ip:currentIps.keySet()){
                if (countIps == 1) {
                    //Последното ip за отпечатване
                    System.out.println(ip + " => " + currentIps.get(ip) + ".");
                } else {
                    //не ми е последното ip
                    System.out.print(ip + " => " + currentIps.get(ip) + ", ");
                }
                countIps--;
            }
        }
    }

}
