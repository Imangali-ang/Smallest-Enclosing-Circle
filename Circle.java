//package sample;

public class Circle {
    Point p1 , p2 , p3  , center;
    double radius;

    public Circle(Point p1, Point p2) {
        this.p1=p1;
        this.p2=p2;
        radius=p1.distance(p2)/2;
        center=p1.center(p2);
    }

    public Point getCenter(){
        return center;
    }

    public double getRadius(){
        return radius;
    }

    public Circle(Point p1, Point p2, Point p3){
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
        radius=findRadius();
        center= new Point(findX() , findY());
    }

    private double findY() {
        double[][] es = {{(Math.pow(p1.getX(), 2) + Math.pow(p1.getY() , 2)) , p1.getX() , 1},
                         {(Math.pow(p2.getX(), 2) + Math.pow(p2.getY() , 2)) , p2.getX() , 1},
                         {(Math.pow(p3.getX(), 2) + Math.pow(p3.getY() , 2)) , p3.getX() , 1}};

        double e = determinant(es);

        double[][] as = {{p1.getX() , p1.getY() , 1},
                         {p2.getX() , p2.getY() , 1},
                         {p3.getX() , p3.getY() , 1}};

        double a = determinant(as);
        return -e/(2*a);
    }



    private double findX(){
        double[][] ds = {{(Math.pow(p1.getX(), 2) + Math.pow(p1.getY() , 2)) , p1.getY() , 1},
                {(Math.pow(p2.getX(), 2) + Math.pow(p2.getY() , 2)) , p2.getY() , 1},
                {(Math.pow(p3.getX(), 2) + Math.pow(p3.getY() , 2)) , p3.getY() , 1}};

        double d = determinant(ds);

        double[][] as = {{p1.getX() , p1.getY() , 1},
                         {p2.getX() , p2.getY() , 1},
                         {p3.getX() , p3.getY() , 1}};

        double a = determinant(as);

        return d/(2*a);
    }



    private double findRadius() {
        double[][] es = {{(Math.pow(p1.getX(), 2) + Math.pow(p1.getY() , 2)) , p1.getX() , 1},
                {(Math.pow(p2.getX(), 2) + Math.pow(p2.getY() , 2)) , p2.getX() , 1},
                {(Math.pow(p3.getX(), 2) + Math.pow(p3.getY() , 2)) , p3.getX() , 1}};

        double e = determinant(es);

        double[][] as = {{p1.getX() , p1.getY() , 1},
                {p2.getX() , p2.getY() , 1},
                {p3.getX() , p3.getY() , 1}};

        double a = determinant(as);

        double[][] ds = {{(Math.pow(p1.getX(), 2) + Math.pow(p1.getY() , 2)) , p1.getY() , 1},
                {(Math.pow(p2.getX(), 2) + Math.pow(p2.getY() , 2)) , p2.getY() , 1},
                {(Math.pow(p3.getX(), 2) + Math.pow(p3.getY() , 2)) , p3.getY() , 1}};

        double d = determinant(ds);

        double[][] fs = {{(Math.pow(p1.getX(), 2) + Math.pow(p1.getY() , 2)) , p1.getX() , p1.getY()},
                {(Math.pow(p2.getX(), 2) + Math.pow(p2.getY() , 2)) , p2.getX() , p2.getY()},
                {(Math.pow(p3.getX(), 2) + Math.pow(p3.getY() , 2)) , p3.getX() , p3.getY()}};

        double f = determinant(fs);

        double r1 = (Math.pow(d , 2)+Math.pow(e , 2))/(4*Math.pow(a , 2));
        double r2 = f/a;

        return Math.sqrt(r1+r2);
    }




    public double determinant(double[][] arr)
    {
        double x , y , z , determinant;
        x = (arr[1][1] * arr[2][2]) - (arr[2][1] * arr[1][2]);
        y = (arr[1][0] * arr[2][2]) - (arr[2][0] * arr[1][2]);
        z = (arr[1][0] * arr[2][1]) - (arr[2][0] * arr[1][1]);

      return determinant = (arr[0][0] * x)- (arr[0][1] * y) + (arr[0][2] * z);
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public boolean contains(Point p){
        if((Math.pow(p.getX()-center.getX() , 2) + Math.pow(p.getY()-center.getY() , 2)) <= Math.pow(radius , 2))
            return true;
        return false;
    }

    public String toString(){
        return "X is " + center.getX() + ", Y is " + center.getY() + " Radius is " + radius;
    }
}
