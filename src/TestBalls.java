import java.awt.Point ;
public class TestBalls {
    public static void main(String[] args) {
        Balls balls = new Balls();
        Point p1 = new Point(3,4);
        Point p2 = new Point(10,4);
        Point p3 = new Point(3,7);
        Point p4 = new Point(8,2);
        Point p5 = new Point(2,4);
        Point p6 = new Point(7,2);
        balls.ajouterballs(p1);
        balls.ajouterballs(p2);
        balls.ajouterballs(p3);
        balls.ajouterballs(p4);
        balls.ajouterballs(p5);
        balls.ajouterballs(p6);
        System.out.println(balls.toString());
        balls.translate(1,1);
        balls.translate(1,1);
        System.out.println(balls.toString()+"\n");
        balls.reInit();
        System.out.println(balls.toString()+"\n");

    }
}