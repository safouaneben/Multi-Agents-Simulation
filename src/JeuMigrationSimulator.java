public class JeuMigrationSimulator extends AutomateCellSimu {
    public JeuMigration jeu ;
    
    public JeuMigrationSimulator()
    {
        super();
        jeu = new JeuMigration(40,40,5);
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
        this.date = 0;
        tracer(jeu.couleur,jeu.grille,jeu.n,jeu.m,0);
    }
}