import java.util.Scanner;
import java.util.*;
import java.io.*;

public class GradeTester{
    

public static void main(String args[]){
/* the main method should instantiate a Scanner, 
get the grade string from the user instantiate a new GradeCalculator,
call the parseInput method for the grade calculator and 
get the final grade from the grade calculator- printing it to standard out

hint: use the nextLine() method from the Scanner class
*/

Scanner scn = new Scanner(new File(args[0]));

parseInput(scn.nextLine());

System.out.println(getLabGrade());

// your code here


}

}