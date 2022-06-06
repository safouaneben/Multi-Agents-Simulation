import gui.Rectangle ;
import java.awt.Color ;
import gui.GUISimulator ;
import java.awt.Point ;

public abstract class AutomateCellSimu extends Event {
    public GUISimulator gui;
    public AutomateCellSimu()
    {
        super(0);
        gui = new GUISimulator (900, 900, Color.BLACK) ;
    }

    protected void tracer(String[] couleur,Cellule[][] grille,int n,int m,int idShelling)
    {
        int mState;
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
                mState = grille[i][j].getCurrentState();
                gui.addGraphicalElement( new Rectangle(j*20+10,i*20+10,Color.decode(couleur[mState+idShelling]), Color.decode(couleur[mState+idShelling]), 15)) ;

            }
        }
    }
    public abstract void execute();
    public abstract void restart();

}
