public class BoidsCohesion extends Boids{
    public BoidsCohesion(int nbrBoids, int distance, float angleVision )
    {
        super(nbrBoids,0,distance,angleVision);
    }

    public void traitement1()
    {
        
        //calcul d'acceleration
        for (int i = 0; i < boids.length; i++) 
        {
            float[] acceleration;
            float[] vitesse;
            float[] position;
            position = new float[2];
            vitesse = new float[2];
            acceleration = new float[2];

            acceleration[0]=boids[i].Cohesion(this,seuilvois,anglevision,1)[0];
            acceleration[1]=boids[i].Cohesion(this,seuilvois,anglevision,1)[1];
            
            boids[i].setAccelerationCourante(acceleration[0],acceleration[1]);

            vitesse[0]=boids[i].getVitesseCourante()[0] + acceleration[0];
            vitesse[1]=boids[i].getVitesseCourante()[1]+ acceleration[1];
            boids[i].setVitesseSuivante(vitesse[0],vitesse[1]);
            
            position[0]=boids[i].getPositionCourante()[0]+ boids[i].getVitesseSuivante()[0];
            position[1]=boids[i].getPositionCourante()[1]+ boids[i].getVitesseSuivante()[1];
            boids[i].setPositionSuivante(position[0],position[1]);
            
            boids[i].rebondissement(BoidsEvent.gui.getPanelHeight());

        }
        updateBoids();

    
    }
}
