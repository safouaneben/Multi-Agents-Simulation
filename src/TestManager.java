import gui.Simulable;
public class TestManager{
    public static void main(String[] args)
   {
       GameManager manager = new GameManager();
       JeuMigrationSimulator jeuMi = new JeuMigrationSimulator() ;
       manager.addEvent(jeuMi);
       ShellingSimu jeuSh = new ShellingSimu();
       manager.addEvent(jeuSh);

       JeuDeVieSimulator jeuCo = new JeuDeVieSimulator();
       manager.addEvent(jeuCo);
        BoidsEvent boidsEvent = new BoidsEvent(4);
        boidsEvent.colors[0] = "#930707";
        boidsEvent.colors[1] = "#239307";
        boidsEvent.colors[2] = "#074493";
        boidsEvent.colors[3] = "#000000";
        BoidsAllignement boidsAllignement = new BoidsAllignement(4,200,(float)2.3);
        BoidsCohesion boidsCohesion = new BoidsCohesion(30,70,(float)2.3);
        BoidsRepulsifs boidsRepulsifs = new BoidsRepulsifs(50, 10, 50,(float)2.5);
        BoidsOrdinaire boidsOrdinaire = new BoidsOrdinaire(100, 10,60 , (float)2.8);
        //boidsEvent.colors[2] = "#6532AC";  
        float max = BoidsEvent.gui.getPanelHeight() ; 

        for (int i = 0; i<30; i++){
            float min = 0;
            float max1=10;
            boidsCohesion.boids[i] = new Boid((float)Math.floor(Math.random()*(max-min+1)+min),(float)Math.floor(Math.random()*(max-min+1)+min),(float)Math.floor(Math.random()*(max1-min+1)+min),(float)Math.floor(Math.random()*(max1-min+1)+min));
        }
        for (int i = 0; i<50; i++){
            float min = 0;
            float max1=10;
            boidsRepulsifs.boids[i] = new Boid((float)Math.floor(Math.random()*(max-min+1)+min),(float)Math.floor(Math.random()*(max-min+1)+min),(float)Math.floor(Math.random()*(max1-min+1)+min),(float)Math.floor(Math.random()*(max1-min+1)+min));
        }
        for (int i = 0; i<100; i++){
            float min = 0;
            float max1=20;
            boidsOrdinaire.boids[i] = new Boid((float)Math.floor(Math.random()*(max-min+1)+min),(float)Math.floor(Math.random()*(max-min+1)+min),(float)Math.floor(Math.random()*(max1-min+1)+min),(float)Math.floor(Math.random()*(max1-min+1)+min));
        }
        boidsAllignement.boids[0] = new Boid(100,50,15,0);
        boidsAllignement.boids[1] = new Boid(100,100,0,10);
        boidsAllignement.boids[2]  = new Boid(100,150,5,5);
        boidsAllignement.boids[3]  = new Boid(100,200,6,0);
        boidsEvent.boidsTable[0] = boidsCohesion;
        boidsEvent.boidsTable[1] = boidsAllignement;
        boidsEvent.boidsTable[2] = boidsRepulsifs;
        boidsEvent.boidsTable[3] = boidsOrdinaire;
        manager.addEvent(boidsEvent);

        boidsEvent.gui.setSimulable(manager);
        jeuMi.gui.setSimulable(manager);
        jeuSh.gui.setSimulable(manager);
        jeuCo.gui.setSimulable(manager);

   }
}
