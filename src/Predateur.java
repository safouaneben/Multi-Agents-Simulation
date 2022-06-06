import gui.Rectangle;
import java.awt.Color ; 

public class Predateur extends BoidsEvent{
    Boids proies;
    Boids predateur;
    //Si vous voulez rendre la poursuite plus logique enlever la limitation vitesse de la paroie dans la methode setVitesseCourrante.
    public Predateur(int nbrPredateur,int nbrProie,int distance, float angleVision)
    {
        super(2);
        boidsTable[1] = new Boids(nbrPredateur,0,distance,angleVision);
        boidsTable[0] = new Boids(nbrProie,0,distance,angleVision);
    }

    public void attaque()
    {
        int i =0;
        
        for(Boid p :boidsTable[1].boids)
        {
            for(Boid proie:boidsTable[0].boids)
            {
                if(p.dansChampDeVision(proie,boidsTable[1].getAnglevision()))
                {
                    i++;
                    p.attrape(proie);
                    break;
                }
                
            }
        }
        if (i == 0)
        {
            boidsTable[1].traitement1();
            boidsTable[1].updateBoids();
        }
    }


    public void nextStep()
    {
        
        boidsTable[0].traitement1();
        attaque();
        boidsTable[0].updateBoids();
        for(Boid b: boidsTable[0].boids)
        {
            BoidsEvent.gui.addGraphicalElement( new Rectangle(b.getPositionCourrante()[0],b.getPositionCourrante()[1],Color.decode(colors[0]), Color.decode(colors[0]), 10)) ;
        }
        for(Boid b: boidsTable[1].boids)
        {
            BoidsEvent.gui.addGraphicalElement( new Rectangle(b.getPositionCourrante()[0],b.getPositionCourrante()[1],Color.decode(colors[1]), Color.decode(colors[1]), 10)) ;
        }
    }

    @Override
    public void execute()
    {
        BoidsEvent.gui.reset();
        this.nextStep();
        this.date ++;
    }
} 