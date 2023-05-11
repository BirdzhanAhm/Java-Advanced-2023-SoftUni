/*
4. Matching Brackets
        We are given an arithmetical expression with brackets. Scan through the string and extract each sub-expression.
        Print the result back at the terminal.
        Hints
        • Use a stack, namely an ArrayDeque().
        • Scan through the expression searching for brackets:
        o If you find an opening bracket, push the index into the stack.
        o If you find a closing bracket, pop the topmost element from the stack. This is the index of the
        opening bracket.
        o Use the current and the popped index to extract the sub-expression.
*/

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String expretiontext = scanner.nextLine();
        ArrayDeque<Integer> inputString = new ArrayDeque<>();

      for (int i=0; i<expretiontext.length();i++){ //Obhojdame celiq niz char po char
          {

              char currentChar = expretiontext.charAt(i);  //Corektniq char

              if (currentChar == '(') {  //Ako Char e raven Na '('
                  inputString.push(i);      //Dobavi v opashkata
              } else if (currentChar == ')') { //Proviven sluchay ako e ')'
                  int lastOpenIndex = inputString.pop(); //vzemi ot steka
                  String subExpretion = expretiontext.substring(lastOpenIndex, i + 1); //ot posledniq otvoren do i
                  System.out.println(subExpretion);

                // System.out.println(expretiontext.substring(inputString.pop(),i+1));  //Last 3 Line on One line


              }
          }
      }


    }
}
