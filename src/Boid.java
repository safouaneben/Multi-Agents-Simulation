import static java.lang.Math.*;
public class Boid {

    private float[] positionCourante;  //vecteur position à l'état n
    private float[] positionSuivante;  //vecteur position à l'état n+1
    private float[] vitesseCourante;   //vecteur vitesse
    private float[] vitesseSuivante;   //vecteur vitesse à l'état suivant
    private float[] vitesseOriginal;   //vecteur en vitesse position originale
    private float[] positionOriginal;
    private float[] accelerationCourante;
    public Boid(float positionX, float positionY ,float vitesseX, float vitesseY ){
        this.positionCourante= new float[2];
        this.positionOriginal =  new float[2];
        this.positionCourante[0]=positionX;
        this.positionCourante[1]=positionY;
        this.positionOriginal[0]=positionX;
        this.positionOriginal[1]=positionY;
        this.positionSuivante = new float[2];
        this.vitesseCourante = new float[2];
        this.vitesseOriginal = new float[2];
        this.vitesseSuivante = new float[2];
        this.vitesseCourante[0]=vitesseX;
        this.vitesseCourante[1]=vitesseY;
        this.vitesseOriginal[0]=vitesseX;
        this.vitesseOriginal[1]=vitesseY;
        this.accelerationCourante = new float[2];
        this.accelerationCourante[0]=0;
        this.accelerationCourante[1]=0;
    }
    public void attrape(Boid proie)
    {
        this.positionSuivante[0] = proie.getPositionCourante()[0];
        this.positionSuivante[1] = proie.getPositionCourante()[1]; 
        System.out.println("I gonna beat u "+ this.positionCourante[0]);
    }
    public void setPositionCourante(float positionX, float positionY){
        this.positionCourante[0]=positionX;
        this.positionCourante[1]=positionY;
    }
    public void setPositionSuivante(float positionX, float positionY){
        this.positionSuivante[0]=positionX;
        this.positionSuivante[1]=positionY;
    }
    public void setVitesseCourante(float vitesseX, float vitesseY){
        this.vitesseCourante[0]=vitesseX;
        this.vitesseCourante[1]=vitesseY;
        this.limitationvitesse(8);
    }
    public void setVitesseSuivante(float vitesseX, float vitesseY){
        this.vitesseSuivante[0]=vitesseX;
        this.vitesseSuivante[1]=vitesseY;
    }
    public void setAccelerationCourante(float accelerationX, float accelerationY){
        //this.accelerationCourante= limitationforce(this.accelerationCourante,10);
        this.accelerationCourante[0]=accelerationX;
        this.accelerationCourante[1]=accelerationY;
    }

    public float[] getPositionCourante(){
        return this.positionCourante;
    }
     public float[] getPositionSuivante(){
        return this.positionSuivante;
    }
    public float[] getVitesseCourante(){
        return this.vitesseCourante;
    }
    public float[] getVitesseSuivante(){
        return this.vitesseSuivante;
    }
    public float[] getAccelerationCourante(){
        return this.accelerationCourante;
    }
    public float distancebetween(Boid boid){ //calcule la distance entre notre boid et un boid de la liste donnée
        return (float)sqrt(pow((this.positionCourante[0]-boid.getPositionCourante()[0]),2) + pow((this.positionCourante[1]-boid.getPositionCourante()[1]),2)) ;
    }
    public float normevecteur(float[] vecteur){
        return (float)sqrt(pow(vecteur[0],2) + pow(vecteur[1],2));
    }
    
    public float[] limitationforce(float [] force,float forceLimite){ //limite la force appliquée
        if (normevecteur(force) > forceLimite){
            force[0]=(float)(((float)force[0]/(float)normevecteur(force))*((float)forceLimite));
            force[1]=(float)(((float)force[1]/(float)normevecteur(force))*((float)forceLimite));
        }
        return force;
    }
    //on limite la vitesse suivant la vitesseLimite
    public void limitationvitesse(float vitesseLimite){
        if (normevecteur(this.vitesseCourante) > vitesseLimite){
            this.vitesseCourante[0]=(float)(((float)this.vitesseCourante[0]/(float)normevecteur(this.vitesseCourante))*((float)vitesseLimite));
            this.vitesseCourante[1]=(float)(((float)this.vitesseCourante[1]/(float)normevecteur(this.vitesseCourante))*((float)vitesseLimite));
        }
    }
    //permet de faire le rebondissement
    public void rebondissement(float taille){
        if( this.positionSuivante[0] < 0 ){
            this.vitesseSuivante[0]=-this.vitesseSuivante[0];
            this.positionSuivante[0]=this.positionCourante[0]-this.vitesseSuivante[0];
        }
        if( this.positionSuivante[1] < 0 ){
            this.vitesseSuivante[1]=-this.vitesseSuivante[1];
            this.positionSuivante[1]=this.positionCourante[1]-this.vitesseSuivante[1];
        }
        if( this.positionSuivante[0] > taille ){
            this.vitesseSuivante[0]=-this.vitesseSuivante[0];
            this.positionSuivante[0]=this.positionCourante[0]-this.vitesseSuivante[0];
        }
        if( this.positionSuivante[1] > taille ){
            this.vitesseSuivante[1]=-this.vitesseSuivante[1];
            this.positionSuivante[1]=this.positionCourante[1]-this.vitesseSuivante[1];
        }
    }
    //calcul la force de cohesion suivant l'algo décrit en annexe
    public float[] Cohesion(Boids boids,float seuilvois,float anglevision,int dominationCohesion){
        float[] cohesion ;
        cohesion = new float[2];
        int nbreVoisin =0;
        for (int i = 0; i < boids.boids.length; i++){
            double distance = this.distancebetween(boids.boids[i]);
            boolean vision=this.dansChampDeVision(boids.boids[i],anglevision);
            if( vision && (distance > 0 ) && ( distance < seuilvois ) ){
            
                cohesion[0]+= boids.boids[i].positionCourante[0];
                cohesion[1]+= boids.boids[i].positionCourante[1];
                nbreVoisin++;
                
            }
        }
        if( nbreVoisin != 0 ){
            cohesion[0]=cohesion[0]/(nbreVoisin);
            cohesion[1]=cohesion[1]/(nbreVoisin);
            cohesion[0]=(cohesion[0]-this.positionCourante[0])/dominationCohesion;
            cohesion[1]=(cohesion[1]-this.positionCourante[1])/dominationCohesion;
            return cohesion;
        }
        else{
            cohesion[0]=0;
            cohesion[1]=0;
            return cohesion;
        }
    
           
    }
    //calcul la force de separation suivant l'algo décrit en annexe
    public float[] Separation(Boids boids, float seuilrep,float anglevision){
        float[] separation ;
        separation = new float[2];
        int NBvoisin = 0;
        for (int i = 0; i < boids.boids.length; i++){
            float distance = this.distancebetween(boids.boids[i]);
            boolean vision=this.dansChampDeVision(boids.boids[i],anglevision);
            if( vision && (distance > 0 ) && (distance < seuilrep )){
                separation[0]+=(this.positionCourante[0]-boids.boids[i].getPositionCourante()[0]);
                separation[1]+=(this.positionCourante[1]-boids.boids[i].getPositionCourante()[1]);
                NBvoisin++;
            }
        }
        if (NBvoisin !=  0){
            //j'ai remarqué que la force de répulsion est trés grande
            separation[0]*=0.9;
            separation[1]*=0.9;
            //separation=limitationforce(separation,8);
            return separation;
        }
        else{
            separation[0]=0;
            separation[1]=0;
            return separation;
        }
    }
    //calcul la force de alignement suivant l'algo décrit en annexe
    public float[] alignement(Boids boids,float seuilvois,float anglevision){
        float[] alignement ;
        alignement = new float[2];
        int NBvoisin = 0;
        for (int i = 0; i < boids.boids.length; i++){
            float distance = this.distancebetween(boids.boids[i]);
            boolean vision=this.dansChampDeVision(boids.boids[i],anglevision);
            if( vision && (distance > 0 ) && (distance < seuilvois )){
                alignement[1]+= boids.boids[i].getVitesseCourante()[1];
                alignement[0]+= boids.boids[i].getVitesseCourante()[0];
                NBvoisin++;
            }
        }
        if (NBvoisin != 0){
            alignement[0]=alignement[0]/NBvoisin;
            alignement[1]=alignement[1]/NBvoisin;
            alignement[0]=alignement[0] - this.vitesseCourante[0];
            alignement[1]=alignement[1] - this.vitesseCourante[1];
            alignement[0]=alignement[0];
            alignement[1]=alignement[1];
            return alignement;
        }
        else{
            
            alignement[0]=0;
            alignement[1]=0;
            return alignement;
        }
    }

    //la fonction suivante applique les trois lois sur notre boid et renvoie la somme des 3 lois elle est plus optimiées
    //en termes du temps
    public float[] appliquerlois(Boids boids,float seuilvois, float seuilrep,float anglevision){
        // velocity1 : centre de masse , velocity2: repulsion , velocity3 : alignement
        float[] velocity2 ;
        velocity2 = new float[2];
        float[] velocity3 ;
        velocity3 = new float[2];
        float[] velocity ;
        velocity = new float[2];
        float positionX1 = 0;
        float positionY1 = 0;
        float nbreVoisin = 0;
        float count = 0;
        for (int i = 0; i < boids.boids.length; i++){
            float distance = this.distancebetween(boids.boids[i]);
            boolean vision=this.dansChampDeVision(boids.boids[i],anglevision);
            if( vision && (distance > 0 ) && (this.distancebetween(boids.boids[i]) < seuilvois ) && ((this.positionCourante[0] != boids.boids[i].getPositionCourante()[0] || this.positionCourante[1] != boids.boids[i].getPositionCourante()[1]))){
                nbreVoisin++;

                positionY1+= boids.boids[i].positionCourante[1];
                positionX1+=boids.boids[i].positionCourante[0];
                velocity3[0]+=boids.boids[i].getVitesseCourante()[0];
                velocity3[1]+=boids.boids[i].getVitesseCourante()[1];

                if ( distance < seuilrep ){
                    velocity2[0]+=this.positionCourante[0]-boids.boids[i].getPositionCourante()[0];
                    velocity2[1]+=this.positionCourante[1]-boids.boids[i].getPositionCourante()[1];
                    if (normevecteur(velocity2) > 0){
                        velocity2[0]= velocity2[0]/normevecteur(velocity2);
                        velocity2[1]= velocity2[0]/normevecteur(velocity2);
                    }
                    velocity2[0]= velocity2[0]/distance;
                    velocity2[1]= velocity2[0]/distance;
                    count ++;
                }


            }
        }
        if( nbreVoisin == 0 ){
            velocity[0]=0;
            velocity[1]=0;
            return velocity;
        }
        velocity3[0]=velocity3[0]/(nbreVoisin);
        velocity3[1]=velocity3[1]/(nbreVoisin);
        velocity3[1]=(velocity3[1]-this.vitesseCourante[1])/8;
        velocity3[0]=(velocity3[0]-this.vitesseCourante[0])/8;
        //move it 10% toward the center
        positionX1=positionX1/(nbreVoisin);
        positionY1=positionY1/(nbreVoisin);
        positionX1=(positionX1-this.positionCourante[0])/20;
        positionY1=(positionY1-this.positionCourante[1])/20;
        if(count > 0){
            velocity2[0]= velocity2[0]/count;
            velocity2[1]= velocity2[0]/count;
        }

        float[] velocity1 ;
        velocity1 = new float[2];
        velocity1[0]=positionX1;
        velocity1[1]=positionY1;
            velocity[0]=velocity1[0]+velocity2[0]+velocity3[0];
            velocity[1]=velocity1[1]+velocity2[1]+velocity3[1];

        return velocity ;
    }
    //permet d'effectuer le produit scalaire entre notre vecteur directeur et un vecteur donné
    public float produitscalaire(float[] vector){
        return this.vitesseCourante[0]*vector[0] + this.vitesseCourante[1]*vector[1];
    }
    public boolean dansChampDeVision(Boid boid, float theta){
        float[] vector;
        vector= new float[2];
        vector[0] = boid.positionCourante[0] - this.positionCourante[0];
        vector[1] = boid.positionCourante[1] - this.positionCourante[1];
        if (normevecteur(this.vitesseCourante) !=0 && normevecteur(vector) !=0 ){
            return (float)Math.acos((produitscalaire(vector)/(normevecteur(this.vitesseCourante)*normevecteur(vector)))) <= theta;
        }
        else{
            return true;
        }
    }

    public void resetBoid()
    {
        this.positionCourante[0]=positionOriginal[0];

        this.positionCourante[1]=positionOriginal[1];
        this.vitesseCourante[0]=vitesseOriginal[0];
        this.vitesseCourante[1]=vitesseOriginal[1];
        this.accelerationCourante[0]=0;
        this.accelerationCourante[1]=0;

    }
}
