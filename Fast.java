//package sample;

import java.util.ArrayList;

public class Fast {
    ArrayList<Point> points;
//    Circle circle;

    public Fast(ArrayList<Point> points){
        this.points=points;
    }

    public Circle sec(){
        Circle circle= null;

        ArrayList<Point> arrY = quicksortbyY(points);
        ArrayList<Point> arrX = quicksortbyX(points);

        Point point = furthestpoint(arrX , arrY);


        double max = 0;
        int index = 0;

        for(int i=0;i<points.size();i++){
            if (max < point.distance(points.get(i))){
                max = point.distance(points.get(i));
                index=i;
            }
        }


//        Point point1 = secondfurthestpoint(arrX , arrY , point);

        circle = new Circle(point, points.get(index));

        System.out.println(point.toString());
        System.out.println(points.get(index).toString());

        for(int i=0;i<points.size();i++) {
            if (!circle.contains(points.get(i))) {
                circle = ces(circle);
            }
        }

        return circle;
    }

    private Point secondfurthestpoint(ArrayList<Point> arrX, ArrayList<Point> arrY, Point point) {
        double parraleldist , dist1 , dist2;

        if(Math.abs(point.getX())<=Math.abs(point.getY())){

            if(Math.abs(arrY.get(0).getY())<=Math.abs(arrY.get(arrY.size()-1).getY())){

                parraleldist = arrY.get(arrY.size()-1).distance(arrY.get(0));
                dist1 = point.distance(arrX.get(0));
                dist2 = point.distance(arrX.get(arrX.size()-1));

                if(parraleldist<dist1){
                    if(dist1<dist2){
                        return arrX.get(arrX.size()-1);
                    }
                    else{
                        return arrX.get(0);
                    }
                }
                else{
                    if(parraleldist<dist2){
                        return arrX.get(arrX.size()-1);
                    }
                    else{
                       return arrY.get(0);
                    }
                }
            }
            else{
                parraleldist = point.distance(arrY.get(arrY.size()-1));
                dist1 = point.distance(arrX.get(0));
                dist2 = point.distance(arrX.get(arrX.size()-1));
                if(parraleldist<dist1){
                    if(dist1<dist2){
                        return arrX.get(arrX.size()-1);
                    }
                    else{
                        return arrX.get(0);
                    }
                }
                else{
                    if(parraleldist<dist2){
                        return arrX.get(arrX.size()-1);
                    }
                    else{
                       return arrY.get(arrY.size()-1);
                    }
                }
            }
        }
        else{
            if(Math.abs(arrX.get(0).getX())<=Math.abs(arrX.get(arrX.size()-1).getX())){
                parraleldist = arrX.get(arrX.size()-1).distance(arrX.get(0));
                dist1 = point.distance(arrY.get(0));
                dist2 = point.distance(arrY.get(arrY.size()-1));
                if(parraleldist<dist1){
                    if(dist1<dist2){
                        return arrY.get(arrY.size()-1);
                    }
                    else{
                        return arrY.get(0);
                    }
                }
                else{
                    if(parraleldist<dist2){
                        return arrY.get(arrY.size()-1);
                    }
                    else{
                       return arrX.get(0);
                    }
                }
            }
            else{
                parraleldist = point.distance(arrX.get(arrX.size()-1));
                dist1 = point.distance(arrY.get(0));
                dist2 = point.distance(arrY.get(arrY.size()-1));
                if(parraleldist<dist1){
                    if(dist1<dist2){
                        return arrY.get(arrY.size()-1);
                    }
                    else{
                        return arrY.get(0);
                    }
                }
                else{
                    if(parraleldist<dist2){
                        return arrY.get(arrY.size()-1);
                    }
                    else{
                       return arrX.get(arrX.size()-1);
                    }
                }
            }
        }
    }


    public Circle ces(Circle circle){

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

    private Point furthestpoint(ArrayList<Point> arrX , ArrayList<Point> arrY){

        Point maxpontbyX=(Math.abs(arrX.get(0).getX()) <= Math.abs(arrX.get(arrX.size()-1).getX())) ? arrX.get(arrX.size()-1) : arrX.get(0);

        Point maxpontbyY=(Math.abs(arrY.get(0).getY()) <= Math.abs(arrY.get(arrY.size()-1).getY())) ? arrY.get(arrY.size()-1) : arrY.get(0);

        Point pont = (Math.abs(maxpontbyY.getY()) <= Math.abs(maxpontbyX.getX())) ? maxpontbyX : maxpontbyY;
        return pont;
    }


    private ArrayList<Point> quicksortbyX(ArrayList<Point> input){
        if(input.size() <= 1){
            return input;
        }
        int middle = (int) Math.ceil((double)input.size() / 2);
        Point pivot = input.get(middle);

        ArrayList<Point> less = new ArrayList<Point>();
        ArrayList<Point> greater = new ArrayList<Point>();

        for (int i = 0; i < input.size(); i++) {
            if(input.get(i).getX() <= pivot.getX()){
                if(i == middle){
                    continue;
                }
                less.add(input.get(i));
            }
            else{
                greater.add(input.get(i));
            }
        }

        return concatenate(quicksortbyX(less), pivot, quicksortbyX(greater));
    }

    private ArrayList<Point> concatenate(ArrayList<Point> less, Point pivot, ArrayList<Point> greater){

        ArrayList<Point> list = new ArrayList<Point>();

        for (int i = 0; i < less.size(); i++) {
            list.add(less.get(i));
        }

        list.add(pivot);

        for (int i = 0; i < greater.size(); i++) {
            list.add(greater.get(i));
        }

        return list;
    }

    private ArrayList<Point> quicksortbyY(ArrayList<Point> input){
        if(input.size() <= 1){
            return input;
        }
        int middle = (int) Math.ceil((double)input.size() / 2);
        Point pivot = input.get(middle);

        ArrayList<Point> less = new ArrayList<Point>();
        ArrayList<Point> greater = new ArrayList<Point>();

        for (int i = 0; i < input.size(); i++) {
            if(input.get(i).getY() <= pivot.getY()){
                if(i == middle){
                    continue;
                }
                less.add(input.get(i));
            }
            else{
                greater.add(input.get(i));
            }
        }

        return concatenate(quicksortbyY(less), pivot, quicksortbyY(greater));
    }


}
