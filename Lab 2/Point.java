import java.util.*;
import java.io.*;

public class Point {
    // TODO: Add required fields to represent a 3D Cartesian point (x,y,z),
    // A constructor to initialize the fields and any required getter and setter
    // methods.
    
    double x;
    double y;
    double z;


    public Point(double x, double y, double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public double getx(){
        return this.x;
    }

    public double gety(){
        return this.y;
    }

    public double getz(){
        return this.z;
    }

    public void setx(double x){
        this.x=x;
        return;
    }

    public void sety(double y){
        this.y=y;
        return;
    }

    public void setz(double z){
        this.z=z;
        return;
    }

}