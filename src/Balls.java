import java.util.LinkedList ;
import java.awt.Point ;
public class Balls extends Point{
    private LinkedList <Ball > balls ;
    private int reInit;
    public Balls(){
        reInit = 0;
        balls = new LinkedList<Ball > ();
    }
    public LinkedList <Ball > getBalls(){
        return this.balls;
    }
    public void translate(int dx, int dy){   //Translater un ensemble de balles
        reInit = 0;
        for ( Ball p : balls){
            p.rebondissement(dx,dy);
            //p.reflectX(dx, 500);
        }
    }
    public void reInit(){     //à la position initiale
        if (reInit == 0)
        {
            for ( Ball p : balls){
                p.x = p.getXInit();
                p.y = p.getYInit();
            }
            reInit=1;
        }
    }
    public void ajouterballs(Ball p){    //ajouter des balles à notre liste de balles
        balls.add(p);
    }
    @Override
    public String toString(){
        String s = new String("les balles sont à :");
        for ( Ball p : balls){
            s+=p.toString();
        }
        return s;
    }

}
