
public class Cellule {
    private int currentState;//1 ou 0
    private int nextState;
    private int originalState;
    private int dimensionCase;
    public Cellule(int vivant,int dimensionCase)
    {
        this.currentState  = vivant;
        this.nextState = vivant;
        this.originalState = vivant;
        this.dimensionCase = dimensionCase;
    }
    public int getCurrentState(){
        return this.currentState;
    }
    public void setCurrentState(int currentState){
      this.currentState = currentState ;
    }
    public int getNextState(){
        return this.nextState;
    }
    public void setNextState(int nextState){
       this.nextState= nextState;
    }
    public int getOriginalState(){
        return this.originalState;
    }
    public void setOriginalState(int originalState){
        this.originalState = originalState;
    }

}
