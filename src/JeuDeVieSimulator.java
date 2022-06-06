public class JeuDeVieSimulator extends AutomateCellSimu{
    public JeuDeVie jeu ;
    public JeuDeVieSimulator(){
        super();
        jeu = new JeuDeVie(40,40);
        jeu.initGrid();
        jeu.test();
        
    }
    
    public void execute() {
        this.jeu.nextStep();
        ++this.date;
        gui.reset();
        tracer(jeu.couleur,jeu.grille,jeu.n,jeu.m,0);
    }

    
    public void restart () 
    {
        gui.reset();
        jeu.reInit();
        this.date=0;
        tracer(jeu.couleur,jeu.grille,jeu.n,jeu.m,0);
    }
}
