import gui.GUISimulator;
import gui.Oval;
import java.awt.Color ;
public class BoidsEvent extends Event {
    public static GUISimulator gui = new  GUISimulator (900, 900, Color.WHITE);
    public Boids[] boidsTable;
    public String[] colors;
    public int nbrGrp;
    public BoidsEvent(int nbrGrp)
    {
        super(0);
        this.boidsTable = new Boids[nbrGrp];
        this.nbrGrp = nbrGrp;
        this.colors = new String[nbrGrp];
    }

    protected void traceNextStep()
    {
        int i=0;
        for (Boids boids : boidsTable)
        {
            boids.traitement1();
            for(Boid b: boids.boids)
            {
                BoidsEvent.gui.addGraphicalElement( new Oval((int)b.getPositionCourante()[0],(int)b.getPositionCourante()[1],Color.decode(colors[i]), Color.decode(colors[i]), 10)) ;
            }
            ++i;
        }
    }
    protected void traceResetAll()
    {
        int i=0;
        for (Boids boids : boidsTable)
        {
            boids.resetBoids();
            for(Boid b: boids.boids)
            {
                BoidsEvent.gui.addGraphicalElement( new Oval((int)b.getPositionCourante()[0],(int)b.getPositionCourante()[1],Color.decode(colors[i]), Color.decode(colors[i]), 10)) ;
            }
            ++i;
        }
    }
    public void execute()
    {
        gui.reset();
        traceNextStep();
        this.date ++;
    }

    public void restart()
    {
        this.date = 0;
        gui.reset();
        traceResetAll();

    }

}
