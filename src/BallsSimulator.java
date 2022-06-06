import gui.Simulable ;
import gui.Oval ;
import java.awt.Color ;
import gui.GUISimulator ;
import java.awt.Point ;
public class BallsSimulator implements Simulable {
    private Balls balles ;
    private GUISimulator gui;
    public BallsSimulator(){
        balles = new Balls();
        gui = new GUISimulator (500, 500, Color.BLACK) ;
        Ball p1 = new Ball(20,40);
        Ball p2 = new Ball(100,400);
        Ball p3 = new Ball(250,200);
        Ball p4 = new Ball(80,232);
        this.balles.ajouterballs(p1);
        this.balles.ajouterballs(p2);
        this.balles.ajouterballs(p3);
        this.balles.ajouterballs(p4);
    }
    public Balls getBalls(){
        return this.balles;
    }
    public GUISimulator getGui(){
        return this.gui;
    }
    @Override
    public void next() {
        this.balles.translate(10,10);
        System.out.println(balles.toString());
        gui.reset();
        for ( Ball p : balles.getBalls()){
            gui.addGraphicalElement( new Oval(p.x,p.y,Color.decode("#E0D726"), Color.decode("#E0D726"), 10)) ;
        }
    }
    @Override
    public void restart () {
        this.balles.reInit();
        System.out.println(balles.toString());
        gui.reset();
        for ( Ball p : balles.getBalls()){
            gui.addGraphicalElement( new Oval(p.x,p.y,Color.decode("#E0D726"), Color.decode("#E0D726"), 10)) ;
        }
    }
}