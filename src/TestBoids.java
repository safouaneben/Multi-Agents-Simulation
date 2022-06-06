import java.awt.Color ;
import java.util.concurrent.ThreadLocalRandom;
import gui.GUISimulator ;
import gui.Rectangle ;
public class TestBoids {
    public static void main(String [] args) {
        int taille = 800 ;
        int max = taille;
        int min = 0;
        int max1=10;
        Boid[] boids = new Boid[30];
        for (int i = 0; i<30; i++){
            int test =(int)Math.floor(Math.random()*(max1-min+1)+min);
            int test1 =(int)Math.floor(Math.random()*(max-min+1)+min);
            

            //boids[i] = new Boid((int)Math.floor(Math.random()*(max-min+1)+min),(int)Math.floor(Math.random()*(max-min+1)+min),0,0);
            boids[0] = new Boid(50,50,10,0);
            boids[1] = new Boid(100,50,10,0);
            boids[2] = new Boid(150,100,10,0);
            boids[3] = new Boid(0,50,10,0);
            boids[4] = new Boid(50,0,10,0);
            boids[5] = new Boid(200,200,10,0);
            boids[6] = new Boid(200,250,10,0);
            boids[7] = new Boid(150,200,10,0);
            boids[8] = new Boid(200,150,10,0);
            boids[9] = new Boid(250,200,10,0);
        }
        Boids monboids =new Boids(taille,boids, 20,100000);
        Boidsimulator monsimu = new Boidsimulator(monboids.gui,monboids);
        monsimu.gui.setSimulable(monsimu) ;
    }
}
