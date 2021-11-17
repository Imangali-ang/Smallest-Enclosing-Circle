//package sample;
public class Point {
    private double x , y ;

    public Point(double x , double y){
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point p){
        double distance = Math.sqrt(Math.pow(p.getX()-x, 2) + Math.pow(p.getY()-y , 2));
        return distance;
    }

    public Point center(Point p){
        return new Point((x+ p.getX())/2  , (y+ p.getY())/2);
    }

    public String toString(){
        return "X is " + x + ", Y is " + y;
    }
}
