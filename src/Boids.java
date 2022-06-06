import java.awt.Color ;
import gui.Rectangle ;
import gui.GUISimulator ;
public abstract class Boids{
    public Boid[] boids;
    public int nbrBoids;
    protected float seuilrep;
    protected float seuilvois;
    protected float anglevision;
    public Boids(int nbrBoids, float seuil, float seuilvois,float anglevision)
    {
        this.nbrBoids = nbrBoids;
        this.boids = new Boid[nbrBoids];
        this.seuilrep = seuil;
        this.seuilvois= seuilvois;
        this.anglevision= anglevision;
    }
    public abstract void traitement1();
    public  float getAnglevision()
    {
        return anglevision;
    }
    

    protected void updateBoids()
    {
        for(Boid b : this.boids)
        {
            b.setPositionCourante(b.getPositionSuivante()[0],b.getPositionSuivante()[1]);
            b.setVitesseCourante(b.getVitesseSuivante()[0],b.getVitesseSuivante()[1]);
        }
    }

    public void resetBoids()
    {
        for(Boid b: boids)
        {
            b.resetBoid();
        }
    }

}
