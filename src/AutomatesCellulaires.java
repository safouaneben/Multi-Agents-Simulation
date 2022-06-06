import java.util.Random;
public  class AutomatesCellulaires
{
    public int n ;
    public int m;
    public int idAutomate;
    protected int reInit;
    protected int nbrEtats;
    public String[] couleur;
    public Cellule[][] grille;
    AutomatesCellulaires(int n,int m,int etats)
    {
        this.m = m;
        this.n =n;
        this.grille = new Cellule[n][m];
        this.nbrEtats = etats;
        this.couleur = new String[etats];
        reInit = 0;
    }
    protected int cyclique(int i, int limite)
    {
        if (i<0)
        {
            return limite-1;
        }
        if (i>= limite)
        {
            return 0;
        }
        else{
            return i;
        }
    }
    protected void initCouleur(int nbrCols)
    {
        couleur[0]="#ffffff";
        for(int k=1;k<nbrCols;++k)
        {
            String col="#";
            for(int i=0;i<6;++i)
            {
                Random r = new Random();
                int a = r.nextInt(10)%10;
                //System.out.println("What  "+a);
                col = col + a;
            }
            couleur[k] = col;
        }

    }
    protected void initGrid()
    {
        initCouleur(nbrEtats);
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
                Cellule cell = new Cellule(0,10);
                grille[i][j] = cell;
            }
        }
    }
    public void reInit()
    {
        if (reInit == 0)
        {
            for(int i=0;i<n;++i)
            {
                for(int j=0;j<m;++j)
                {
                    this.grille[i][j].setCurrentState(this.grille[i][j].getOriginalState() );
                    this.grille[i][j].setNextState(this.grille[i][j].getOriginalState() );
                }
            }
            reInit = 1;
        }
    }

    protected void initVal(int i,int j,int value)
    {
        grille[i][j].setCurrentState(value);
        grille[i][j].setNextState(value);
        grille[i][j].setOriginalState(value);
    }

    //public abstract void execute();
}
