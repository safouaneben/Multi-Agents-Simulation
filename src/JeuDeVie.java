public class JeuDeVie extends AutomatesCellulaires{
    // nxm est la taille de la grille;
    public JeuDeVie(int n,int m)
    {
        super(n,m,2);
        this.idAutomate = 0;
    }


    public void test()
    {
        int j1 = m/2;
        int j2 = m/2;
        for (int i=0;i<n/2 && j2>=0 && j1<m;++i)
        {

            initVal(i, j1,1);
            initVal(i, j2,1);
            ++j1;
            --j2;
        }
        for (int i=n/2;i<n && j1>m/2 && j2<m/2;++i)
        {
            --j1;
            ++j2;
            initVal(i, j1,1);
            initVal(i, j2,1);

        }
    }

    private int stateCell(int i, int j)
    {
        int nbrVoisinsViavant=0;
        nbrVoisinsViavant += this.grille[i][cyclique(j+1,m)].getCurrentState();
        nbrVoisinsViavant += this.grille[i][cyclique(j-1,m)].getCurrentState();
        nbrVoisinsViavant += this.grille[cyclique(i+1,n)][cyclique(j+1,m)].getCurrentState();
        nbrVoisinsViavant += this.grille[cyclique(i+1,n)][cyclique(j-1,m)].getCurrentState();
        nbrVoisinsViavant += this.grille[cyclique(i+1,n)][j].getCurrentState();
        nbrVoisinsViavant += this.grille[cyclique(i-1,n)][cyclique(j+1,m)].getCurrentState();
        nbrVoisinsViavant += this.grille[cyclique(i-1,n)][cyclique(j-1,m)].getCurrentState();
        nbrVoisinsViavant += this.grille[cyclique(i-1,n)][j].getCurrentState();
        return nbrVoisinsViavant;
    }

    public void nextStep()
    {
        reInit = 0;
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
                int state = stateCell(i, j);
                if (grille[i][j].getCurrentState() == 1 && state != 3 && state != 2 )
                {
                    grille[i][j].setNextState(0);
                }
                else
                {
                    if (grille[i][j].getCurrentState() == 0 && state ==3)
                    {
                        grille[i][j].setNextState(1);
                    }
                }
            }
        }
        this.updateGrille();
    }

    private void updateGrille()
    {
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
                grille[i][j].setCurrentState( grille[i][j].getNextState());
            }
        }
    }
}
