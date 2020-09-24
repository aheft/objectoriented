import java.util.*;
import java.io.*;

public class Test{
    public static void main(String[] args){
        Euclidean test2=new Euclidean();
        test2.initPoints(2, 4, 6, 1, 2, 3);
        double dist=test2.calculateDistance();
        System.out.println(dist);
    }
}