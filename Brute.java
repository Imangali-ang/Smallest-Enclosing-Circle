//package sample;

import java.lang.reflect.Array;
import java.util.*;

public class Brute {
    ArrayList<Point> points;

    public Brute(ArrayList<Point> points){
        this.points=points;
    }      // constructor takes array of points

    public Circle sec(){

        double max = 0;
        Circle circle= null;
        int index1=0 , index2=0;

        for(int i=0;i<points.size();i++) {
            for (int j = i + 1; j < points.size() - 1; j++) {
                if (max < points.get(i).distance(points.get(j))) {
                    max = points.get(i).distance(points.get(j));
                    index1=i;
                    index2=j;
                }
            }
        }

        circle = new Circle(points.get(index1) , points.get(index2));
        System.out.println(points.get(index1).toString());
        System.out.println(points.get(index2).toString());

//        points.remove(index1);
//        points.remove(index2);

        for(int i=0;i<points.size();i++) {
            if (!circle.contains(points.get(i))) {
                circle = ces( circle);
            }
        }

        return circle;
    }

    public Circle ces( Circle circle){

        Circle circ=null;
        double max = 0;
        int index = 0;


         for(int i=0;i<points.size();i++) {
             if (max < distance(points.get(i), circle.getP1(), circle.getP2())) {
                 max = distance(points.get(i), circle.getP1(), circle.getP2());
                 index=i;
             }
         }


        circ = new Circle(circle.getP1(), circle.getP2(), points.get(index));
        return circ;
    }


    public double distance(Point p, Point p1, Point p2){
        double d=0;

        double A = p2.getY()- p1.getY();
        double B = p1.getX() - p2.getX();
        double C = p1.getY()*(p2.getX()-p1.getX())-p1.getX()*(p2.getY()- p1.getY());
        d=(Math.abs(A*p.getX() + B*p.getY() + C))/Math.sqrt(Math.pow(A , 2) + Math.pow(B , 2));

        return d;
    }
}
