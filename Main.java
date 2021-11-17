//package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main extends Application {


    public void start(Stage stage) throws Exception{
        String name = "input3.txt";
        StackPane root = new StackPane();
        read(name , root);
//        Scene scene = new Scene(root, 600, 600);
//
//        //Setting title to the scene
//        stage.setTitle("Sample application");
//
//        //Adding the scene to the stage
//        stage.setScene(scene);
//
//        //Displaying the contents of a scene
//        stage.show();
    }

    public static void read(String name , Pane root) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        File file = new File(name);
        Scanner sc = new Scanner(file);
        int size = sc.nextInt();
        sc.nextLine();
        ArrayList<Point> points = new ArrayList<>();
        for(int i=0;i<size;i++) {
            String[] line = sc.nextLine().trim().split(" ");
            points.add(new Point(Double.parseDouble(line[0]) , Double.parseDouble(line[1])));
            line=null;
        }


long start = System.nanoTime();
        Brute brute = new Brute(points);
////        root.getChildren().add(new Circle(brute.sec().getCenter().getX()*10 , brute.sec().getCenter().getY()*10 , brute.sec().getRadius()*100));
        System.out.println(brute.sec().toString());
        long finish = System.nanoTime()-start;
        System.out.println("Time1: " + finish);

long start1 = System.nanoTime();
        Fast fast = new Fast(points);
        System.out.println(fast.sec().toString());
        long finish1 =  System.nanoTime()-start1;
 System.out.println("Time2: " + finish1);

 System.out.println("\n Class Fast working " + finish/finish1 +" faster than class Brute");

    }
}
