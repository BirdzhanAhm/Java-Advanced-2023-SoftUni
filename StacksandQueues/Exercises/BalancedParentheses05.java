import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BalancedParentheses05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String allCourvs = scanner.nextLine();

        List<String> courvsToList = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
        String result = isBalanced(courvsToList)? "YES":"NO";
        System.out.println(result);
    }

    private static boolean isBalanced(List<String> courvsToList) {
        if(courvsToList.size()%2!=0){
            return false;
        }
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        int firsPart= courvsToList.size()/2;

/*        for (String s : courvsToList) {
            queue.push(s);
        }*/

        for (int i = 0; i < firsPart; i++) {
            stack.offer(courvsToList.get(i));
        }
        for (int i = firsPart; i <courvsToList.size() ; i++) {
            queue.push(courvsToList.get(i));
        }

      for (int i =0; i<firsPart;i++) {
       //   System.out.println(i +"Stack "+ stack.pop()+" Stacck 2 " +queue.pop());
          String a = stack.pop();
          String b =queue.pop();

          if (a.equals("{")){
              if(b.equals(")")||b.equals("]")){
                  return false;
              }
          }else if(a.equals("(")){
              if (b.equals("}")||b.equals("]")){
                  return false;
              }
          }else if(a.equals("[")){
              if(b.equals("}")||b.equals(")")){
                  return false;
              }
          }
              /*switch (a){
                  case "{":
                     if (b.equals(")")){
                         return false;
                  }else if (b.equals("]")){
                         return false;
                     }
                  case "(":
                      if (b.equals("}")){
                          return false;
                      }else if(b.equals("]")){
                          return false;
                      }
                  case "[":
                      if (b.equals(")")){
                          return false;
                      }else if(b.equals("}")){
                          return false;
                      }

              }*/


      }

       // System.out.println("name");
        return true;
    }
}
