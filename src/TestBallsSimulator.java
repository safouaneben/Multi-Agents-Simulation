import gui.GUISimulator ;
import gui.Oval ;
import java.awt.Color ;
import java.awt.Point ;

public class TestBallsSimulator {
    public static void main(String [] args) {
        BallsSimulator balls = new BallsSimulator() ;
        // for ( Point p : balls.balles.balls){
        //     gui.addGraphicalElement( new Oval(p.x,p.y,Color.decode("#E0D726"), Color.decode("#E0D726"), 10)) ;
        // }
        balls.getGui().setSimulable(balls) ;
    }
}