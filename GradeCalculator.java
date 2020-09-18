import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;

public class GradeCalculator{
    /* private member variables.  Do not change these*/

    private ArrayList<Double> assignmentGrades = new ArrayList<>();
    private double finalExam;
    private ArrayList<Double> ceGrades = new ArrayList<>();
    private double labTotal;
    private double selfStudyAverage;

//you can use these methods or write your own

    private void setAssignmentGrades(double a1, double a2, double a3){
        /* this is an example of how to add things to an array list
        but it is not a complete method.  You will need to finish it*/

        assignmentGrades.add(a1);
        assignmentGrades.add(a2);
        assignmentGrades.add(a3);
 
    }


    private  void setCeGrades(double s1, double s2, double s3){
        /*this is similar to the setAssignmentGrades method*/


        ceGrades.add(s1);
        ceGrades.add(s2);
        ceGrades.add(s3);
        
    }


    private void  setFinalExamGrade(double grade){

        finalExam = grade;

    }

    private  void setLabTotal(double grade){
   
        labTotal = grade;

    }

    private  void setSelfStudyAverage(double grade){
      
        selfStudyAverage = grade;

    }

    private double getHomeworkGrade(){
        /* 
        this method returns the calculated score for assignments and competence interviews
        possibly useful is the ArrayList get(index) method.  
        somearraylist.get(1) will return the element in the second position
        because ArrayLists are zero indexed */

        int length;

        if (assignmentGrades.size()>ceGrades.size()){
            length = ceGrades.size();
        }

        else{
            length = assignmentGrades.size();
        }

        double sum=0;

        for (int i=0; i<length; i++){
            sum+= assignmentGrades.get(i) * ceGrades.get(i);
        }

        System.out.println(sum/length);
        return (sum/length);

    }
    
    private double getLabGrade(){
        /* returns the lab grade combined with the independent studies grade*/

        return (labTotal*selfStudyAverage);

    }

    public double getFinalCourseGrade(){
        return((getHomeworkGrade()*0.5)+(getLabGrade()*0.2)+(finalExam*0.3));
    }

    public void parseInput(String inputLine){
        /*part of this method is done for you, but not all of it. 
        You will need to finish it*/
    String singles[] = inputLine.split(",");
    setLabTotal(Double.parseDouble(singles[0]));
    setAssignmentGrades(Double.parseDouble(singles[1]) ,Double.parseDouble(singles[2]), Double.parseDouble(singles[3]));
    setCeGrades(Double.parseDouble(singles[4]) ,Double.parseDouble(singles[5]), Double.parseDouble(singles[6]));
    setSelfStudyAverage(Double.parseDouble(singles[7]));
    setFinalExamGrade(Double.parseDouble(singles[8]));
  
    //more code needed here calling the setter methods
    }


}